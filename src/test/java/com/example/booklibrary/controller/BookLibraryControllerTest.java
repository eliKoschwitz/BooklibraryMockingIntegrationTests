package com.example.booklibrary.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BookLibraryControllerTest {

    // Integrations Tests

    @Autowired
    private MockMvc mvc;

    @Test
    void getBooksExpectedJsonArrayList() throws Exception {
        //GIVEN
        String expectedJSON = """
                    [
                        {
                            "isbn": 12314,
                            "title": "Harry Potter",
                            "autor": "J.K"
                        },
                        {
                            "isbn": 12345,
                            "title": "Book of Eli",
                            "autor": "Jesus"
                        }
                    ]
                """;
        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.get("/myapi/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void putSafeBookExpected() throws Exception {
        //GIVEN
        String requestBody = """
                    {
                    "isbn": 123456,
                    "title":"Der Steppenwolf",
                    "autor":"Johann Wolfgang von Goethe"
                    }
                """;

        String expectedJSON = """           
                {
                    "isbn": 123456,
                    "title": "Der Steppenwolf",
                    "autor": "Johann Wolfgang von Goethe"
                }
            """;


        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.put("/myapi/books/123456")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));
    }

    @Test
    void delete_ShouldReturnTrue_AndRemoveBook() throws Exception {
        //GIVEN
        int isbn = 12314;

        String expectedJSON = """           
                        {
                            "isbn": 12314,
                            "title": "Harry Potter",
                            "autor": "J.K"
                        }
            """;


        //WHEN & THEN
        mvc.perform(MockMvcRequestBuilders.delete("/myapi/books/"+isbn))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJSON));

        //Extra Test to check if it was deleted
        mvc.perform(MockMvcRequestBuilders.get("/myapi/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                   [
                        {
                            "isbn": 12345,
                            "title": "Book of Eli",
                            "autor": "Jesus"
                        }
                    ]
                    """));
    }
}