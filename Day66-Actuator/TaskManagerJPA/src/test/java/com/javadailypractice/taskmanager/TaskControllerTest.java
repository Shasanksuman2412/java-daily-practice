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

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTasksWithoutAuthReturnsUnauthorized() throws Exception {
        mockMvc.perform(get("/tasks")).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "USER")
    void getTasksAsUserReturnsOk() throws Exception {
        mockMvc.perform(get("/tasks")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "USER")
    void createTaskAsUserReturnsForbidden() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Should fail\"}"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void createTaskAsAdminReturnsOk() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Valid new task\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Valid new task"))
                .andExpect(jsonPath("$.completed").value(false));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void createTaskWithBlankTitleReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Title is required"));
    }

    @Test
    @WithMockUser(roles = "USER")
    void getNonExistentTaskReturnsNotFound() throws Exception {
        mockMvc.perform(get("/tasks/99999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Task not found with id: 99999"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void deletedTaskCanNoLongerBeFound() throws Exception {
        String response = mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Temporary task\"}"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        int id = com.jayway.jsonpath.JsonPath.read(response, "$.id");

        mockMvc.perform(delete("/tasks/" + id)).andExpect(status().isNoContent());
        mockMvc.perform(get("/tasks/" + id)).andExpect(status().isNotFound());
    }
}
