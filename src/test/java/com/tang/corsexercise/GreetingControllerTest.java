package com.tang.corsexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class GreetingControllerTest {

  @InjectMocks
  private GreetingController controller;

  private MockMvc mvc;

  @BeforeEach
  void setUp() {
    mvc = standaloneSetup(controller).build();
  }

  @Test
  void greetingDefault() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/greeting"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\": 1, \"content\": \"Hello, World!\"}"));
  }

  @Test
  void greetingHasRequestParam() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/greeting?name=Han"))
        .andExpect(status().isOk())
        .andExpect(content().json("{\"id\": 1, \"content\": \"Hello, Han!\"}"));
  }

  @Test
  void greetingHasTwoRequestParams() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/greeting?name=dog&nickName=cat"))
      .andExpect(status().isOk())
      .andExpect(content().json("{\"id\": 1, \"content\": \"Hello, dog! cat\"}"));
  }
}