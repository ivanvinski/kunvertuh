package com.ivanvinski.kunvertuh.model;

import org.junit.Test;

public class MainModelTest {

  @Test(expected = NullPointerException.class)
  public void nullViewsInitializationThrowsException() {
    new MainModel(null);
  }
}
