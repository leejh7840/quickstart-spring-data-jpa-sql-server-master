package com.example.demo;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TodoController.class})
@ExtendWith(SpringExtension.class)
class TodoControllerTest {

  @Autowired
  private TodoController todoController;

  @MockBean
  private TodoRepository todoRepository;

  /**
   * Method under test: {@link TodoController#createTodo(Todo)}
   */
  @Test
  void testCreateTodo() throws Exception {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(123L);
    when(this.todoRepository.save((Todo) any())).thenReturn(todo);

    Todo todo1 = new Todo();
    todo1.setDescription("The characteristics of someone or something");
    todo1.setDetails("Details");
    todo1.setDone(true);
    todo1.setId(123L);
    String content = (new ObjectMapper()).writeValueAsString(todo1);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/todo/create")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.todoController)
        .build()
        .perform(requestBuilder);
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"id\":123,\"description\":\"The characteristics of someone or something\",\"details\":\"Details\","
                    + "\"done\":true}"));
  }

  /**
   * Method under test: {@link TodoController#getTodos()}
   */
  @Test
  void testGetTodos() throws Exception {
    when(this.todoRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/todo/list");
    MockMvcBuilders.standaloneSetup(this.todoController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test: {@link TodoController#getTodos()}
   */
  @Test
  void testGetTodos2() throws Exception {
    when(this.todoRepository.findAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/todo/list");
    getResult.contentType("https://example.org/example");
    MockMvcBuilders.standaloneSetup(this.todoController)
        .build()
        .perform(getResult)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }
}

