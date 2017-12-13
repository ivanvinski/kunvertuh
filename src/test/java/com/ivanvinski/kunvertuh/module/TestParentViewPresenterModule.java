package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.view.TestParentView;

public class TestParentViewPresenterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TestParentView.class).toInstance(new TestParentView());
  }
}
