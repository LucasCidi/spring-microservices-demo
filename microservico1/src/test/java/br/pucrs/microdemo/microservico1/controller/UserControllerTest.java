package br.pucrs.microdemo.microservico1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUser_returnsNamesDuplicated() throws Exception {
        mockMvc.perform(get("/user").param("fn", "John").param("ln", "Doe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("JohnJohn"))
                .andExpect(jsonPath("$.lastName").value("DoeDoe"));
    }

    @Test
    void getUser_missingParams_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isBadRequest());
    }
}
