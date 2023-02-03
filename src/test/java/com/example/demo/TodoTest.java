package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TodoTest {

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link Todo#Todo()}
   *   <li>{@link Todo#setDescription(String)}
   *   <li>{@link Todo#setDetails(String)}
   *   <li>{@link Todo#setDone(boolean)}
   *   <li>{@link Todo#setId(Long)}
   * </ul>
   */
  @Test
  void testConstructor() {
    Todo actualTodo = new Todo();
    actualTodo.setDescription("The characteristics of someone or something");
    actualTodo.setDetails("Details");
    actualTodo.setDone(true);
    actualTodo.setId(123L);
    assertEquals("The characteristics of someone or something", actualTodo.getDescription());
    assertEquals("Details", actualTodo.getDetails());
    assertEquals(123L, actualTodo.getId().longValue());
    assertTrue(actualTodo.isDone());
  }

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link Todo#Todo(String, String, boolean)}
   *   <li>{@link Todo#setDescription(String)}
   *   <li>{@link Todo#setDetails(String)}
   *   <li>{@link Todo#setDone(boolean)}
   *   <li>{@link Todo#setId(Long)}
   * </ul>
   */
  @Test
  void testConstructor2() {
    Todo actualTodo = new Todo("The characteristics of someone or something", "Details", true);
    actualTodo.setDescription("The characteristics of someone or something");
    actualTodo.setDetails("Details");
    actualTodo.setDone(true);
    actualTodo.setId(123L);
    assertEquals("The characteristics of someone or something", actualTodo.getDescription());
    assertEquals("Details", actualTodo.getDetails());
    assertEquals(123L, actualTodo.getId().longValue());
    assertTrue(actualTodo.isDone());
  }

  /**
   * Method under test: {@link Todo#equals(Object)}
   */
  @Test
  void testEquals() {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(123L);
    assertNotEquals(todo, null);
  }

  /**
   * Method under test: {@link Todo#equals(Object)}
   */
  @Test
  void testEquals2() {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(123L);
    assertNotEquals(todo, "Different type to Todo");
  }

  /**
   * Method under test: {@link Todo#equals(Object)}
   */
  @Test
  void testEquals3() {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(123L);
    assertEquals(todo, todo);
    int expectedHashCodeResult = todo.hashCode();
    assertEquals(expectedHashCodeResult, todo.hashCode());
  }

  /**
   * Method under test: {@link Todo#equals(Object)}
   */
  @Test
  void testEquals4() {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(123L);

    Todo todo1 = new Todo();
    todo1.setDescription("The characteristics of someone or something");
    todo1.setDetails("Details");
    todo1.setDone(true);
    todo1.setId(123L);
    assertEquals(todo, todo1);
    int expectedHashCodeResult = todo.hashCode();
    assertEquals(expectedHashCodeResult, todo1.hashCode());
  }

  /**
   * Method under test: {@link Todo#equals(Object)}
   */
  @Test
  void testEquals5() {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(1L);

    Todo todo1 = new Todo();
    todo1.setDescription("The characteristics of someone or something");
    todo1.setDetails("Details");
    todo1.setDone(true);
    todo1.setId(123L);
    assertNotEquals(todo, todo1);
  }

  /**
   * Method under test: {@link Todo#equals(Object)}
   */
  @Test
  void testEquals6() {
    Todo todo = new Todo();
    todo.setDescription("The characteristics of someone or something");
    todo.setDetails("Details");
    todo.setDone(true);
    todo.setId(null);

    Todo todo1 = new Todo();
    todo1.setDescription("The characteristics of someone or something");
    todo1.setDetails("Details");
    todo1.setDone(true);
    todo1.setId(123L);
    assertNotEquals(todo, todo1);
  }
}

