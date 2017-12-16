package com.ivanvinski.kunvertuh.model;

import java.util.Objects;
import javafx.application.HostServices;

public class AboutModel {

  private HostServices services;

  public AboutModel(HostServices services) {
    this.services = Objects.requireNonNull(services, "Host services can't be null");
  }

  public void openInBrowser(String webPageURI) {
    services.showDocument(webPageURI);
  }
}
