package com.ivanvinski.kunvertuh.util;

import java.util.Objects;
import javafx.application.HostServices;

public final class JFXBrowser implements Browser {

  private HostServices hostServices;

  public JFXBrowser(HostServices hostServices) {
    this.hostServices = Objects.requireNonNull(hostServices, "Host services can't be null");
  }

  @Override
  public void open(String uri) {
    hostServices.showDocument(uri);
  }
}
