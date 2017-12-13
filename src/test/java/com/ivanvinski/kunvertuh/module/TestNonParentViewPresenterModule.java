package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.view.TestNonParentView;

public class TestNonParentViewPresenterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TestNonParentView.class).toInstance(new TestNonParentView());
  }
}
