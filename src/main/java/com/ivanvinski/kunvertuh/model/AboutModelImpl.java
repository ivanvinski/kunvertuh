package com.ivanvinski.kunvertuh.model;

import java.util.Objects;
import javafx.application.HostServices;

public class AboutModelImpl implements AboutModel {

  private HostServices services;

  public AboutModelImpl(HostServices services) {
    this.services = Objects.requireNonNull(services, "Host services can't be null");
  }

  @Override
  public void openInBrowser(String uri) {
    services.showDocument(uri);
  }
}
