package com.ivanvinski.kunvertuh.model;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.i18n.Language;

public class SettingsModel {

  private Language language;

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }
}
