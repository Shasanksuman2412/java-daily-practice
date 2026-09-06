package com.javadailypractice.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @SpringBootTest loads the FULL application context - controllers,
// services, security, everything - the most realistic (and slowest) kind
// of test. @AutoConfigureMockMvc lets us simulate real HTTP requests
// WITHOUT actually starting a server on a real port.
@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // ---- Security: no credentials at all ----
    @Test
    void getTasksWithoutAuthReturnsUnauthorized() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andExpect(status().isUnauthorized()); // 401 - Day 55/57's security rules
    }

    // ---- Security: authenticated as USER, reading is allowed ----
    @Test
    @WithMockUser(roles = "USER") // fakes an authenticated USER for JUST this test
    void getTasksAsUserReturnsOk() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk());
    }

    // ---- Security: USER role trying to create - should be forbidden ----
    @Test
    @WithMockUser(roles = "USER")
    void createTaskAsUserReturnsForbidden() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Should fail\"}"))
                .andExpect(status().isForbidden()); // 403 - correct role, wrong permission
    }

    // ---- Security: ADMIN role creating - should succeed ----
    @Test
    @WithMockUser(roles = "ADMIN")
    void createTaskAsAdminReturnsOk() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Valid new task\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Valid new task"))
                .andExpect(jsonPath("$.completed").value(false)); // new tasks always start incomplete
    }

    // ---- Validation: blank title should be rejected ----
    @Test
    @WithMockUser(roles = "ADMIN")
    void createTaskWithBlankTitleReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Title is required")); // Day 52's validation message
    }

    // ---- Not found: a task that doesn't exist ----
    @Test
    @WithMockUser(roles = "USER")
    void getNonExistentTaskReturnsNotFound() throws Exception {
        mockMvc.perform(get("/tasks/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Task not found with id: 99999"));
    }

    // ---- Full lifecycle: create, then delete, confirm gone ----
    @Test
    @WithMockUser(roles = "ADMIN")
    void deletedTaskCanNoLongerBeFound() throws Exception {
        String response = mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Temporary task\"}"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        int id = com.jayway.jsonpath.JsonPath.read(response, "$.id");

        mockMvc.perform(delete("/tasks/" + id))
                .andExpect(status().isNoContent()); // 204

        mockMvc.perform(get("/tasks/" + id))
                .andExpect(status().isNotFound()); // confirms it's genuinely gone
    }
}
