package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.presenter.Presenter;

public class ViewModule extends AbstractModule {

  private Presenter presenter;

  public ViewModule(Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  protected void configure() {
    bind(Presenter.class).toInstance(presenter);
  }
}
