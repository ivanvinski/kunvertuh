package com.ivanvinski.kunvertuh.model;

public class AboutModelMock implements AboutModel {

  private String openedWebsite;

  @Override
  public void openInBrowser(String uri) {
    openedWebsite = uri;
  }

  public String getOpenedWebsite() {
    return openedWebsite;
  }
}
