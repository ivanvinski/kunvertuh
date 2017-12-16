package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.AboutModel;
import com.ivanvinski.kunvertuh.view.AboutView;
import com.ivanvinski.kunvertuh.view.javafx.AboutViewImpl;
import javafx.application.HostServices;

public class AboutPresenterModule extends AbstractModule {

  private HostServices hostServices;

  public AboutPresenterModule(HostServices hostServices) {
    this.hostServices = hostServices;
  }

  @Override
  protected void configure() {
    bind(AboutView.class).to(AboutViewImpl.class);
    bind(AboutModel.class).toInstance(new AboutModel(hostServices));
  }
}
