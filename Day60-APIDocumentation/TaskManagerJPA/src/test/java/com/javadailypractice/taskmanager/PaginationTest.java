package com.javadailypractice.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PaginationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void seedTasks() {
        taskRepository.deleteAll(); // clean slate for each test
        taskRepository.save(new Task("Charlie task", false));
        taskRepository.save(new Task("Alpha task", false));
        taskRepository.save(new Task("Bravo task", false));
        taskRepository.save(new Task("Delta task", false));
        taskRepository.save(new Task("Echo task", false));
    }

    @Test
    @WithMockUser(roles = "USER")
    void defaultPageSizeReturnsUpToTenItems() throws Exception {
        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(5)) // only 5 tasks exist, all fit on one page
                .andExpect(jsonPath("$.totalItems").value(5))
                .andExpect(jsonPath("$.totalPages").value(1));
    }

    @Test
    @WithMockUser(roles = "USER")
    void customPageSizeLimitsResults() throws Exception {
        mockMvc.perform(get("/tasks?page=0&size=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(2)) // only 2 per page now
                .andExpect(jsonPath("$.totalItems").value(5))
                .andExpect(jsonPath("$.totalPages").value(3)); // 5 items, 2 per page = 3 pages
    }

    @Test
    @WithMockUser(roles = "USER")
    void secondPageReturnsDifferentItems() throws Exception {
        mockMvc.perform(get("/tasks?page=0&size=2&sort=title,asc"))
                .andExpect(jsonPath("$.content[0].title").value("Alpha task")); // alphabetically first

        mockMvc.perform(get("/tasks?page=1&size=2&sort=title,asc"))
                .andExpect(jsonPath("$.content[0].title").value("Charlie task")); // third alphabetically, first on page 2
    }

    @Test
    @WithMockUser(roles = "USER")
    void sortDescendingReversesOrder() throws Exception {
        mockMvc.perform(get("/tasks?sort=title,desc"))
                .andExpect(jsonPath("$.content[0].title").value("Echo task")); // alphabetically last, first when descending
    }
}
