package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.AboutModel;
import com.ivanvinski.kunvertuh.view.AboutView;
import com.ivanvinski.kunvertuh.view.javafx.AboutViewImpl;

public class AboutPresenterModule extends AbstractModule {

  private AboutModel model;

  public AboutPresenterModule(AboutModel model) {
    this.model = model;
  }

  @Override
  protected void configure() {
    bind(AboutView.class).to(AboutViewImpl.class);
    bind(AboutModel.class).toInstance(model);
  }
}
