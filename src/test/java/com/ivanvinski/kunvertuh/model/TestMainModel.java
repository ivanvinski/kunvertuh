package com.ivanvinski.kunvertuh.model;

import org.junit.Test;

public class TestMainModelImpl {

  @Test(expected = NullPointerException.class)
  public void nullViewsInitializationThrowsException() {
    new MainModelImpl(null);
  }
}
