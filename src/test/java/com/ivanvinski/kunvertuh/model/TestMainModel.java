package com.ivanvinski.kunvertuh.model;

import org.junit.Test;

public class TestMainModel {

  @Test(expected = NullPointerException.class)
  public void nullViewsInitializationThrowsException() {
    new MainModel(null);
  }
}
