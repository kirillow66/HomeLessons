package ru.sberbank.jd.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@SpringBootTest
@AutoConfigureMockMvc
class GiftControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getAllGiftsTest() throws Exception {
        mockMvc.perform(get("/api/gifts"))
                .andExpect(status().isOk());
    }

    @Test
    public void createGiftGetAndGiftByIdTest() throws Exception {
        String newGiftJson = "{\"description\": \"Second gift\", \"name\": \"Gift\", \"price\": \"100\"}";
        MockHttpServletRequestBuilder request = post("/api/gifts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newGiftJson);

       mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"Gift\","
                        + "\"description\":\"Second gift\",\"price\":100.0}"));

        mockMvc.perform(get("/api/gifts/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"Gift\",\"description\":"
                        + "\"Second gift\",\"price\":100.0}"));
    }

    @Test
    void updateGift() throws Exception {
        String newGiftJson = "{\"description\": \"Second gift\", \"name\": \"Gift\", \"price\": \"100\"}";

        MockHttpServletRequestBuilder request = post("/api/gifts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newGiftJson);

        mockMvc.perform(request);
        String updatedGiftJson = "{\"description\": \"Second gift2\", \"name\": \"Gift2\", \"price\": \"100\"}";
        MockHttpServletRequestBuilder request2 = put("/api/gifts/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedGiftJson);

        mockMvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Gift2\","
                        + "\"description\":\"Second gift2\",\"price\":100.0}"));

    }

    @Test
    void deleteGift() throws Exception {
        String newGiftJson = "{\"description\": \"Second gift\", \"name\": \"Gift\", \"price\": \"100\"}";

        MockHttpServletRequestBuilder request = post("/api/gifts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newGiftJson);
        mockMvc.perform(request);
        mockMvc.perform(delete("/api/gifts/1"))
                .andExpect(status().isNoContent());
    }
}