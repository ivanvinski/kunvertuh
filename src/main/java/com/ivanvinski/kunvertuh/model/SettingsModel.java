package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.i18n.Language;

public class SettingsModel {

  private Language[] languages;
  private Language activeLanguage;

  public SettingsModel(Language[] languages) {
    this.languages = languages;
  }

  public Language[] getLanguages() {
    return languages;
  }

  public Language getActiveLanguage() {
    return activeLanguage;
  }

  public void setActiveLanguage(Language activeLanguage) {
    this.activeLanguage = activeLanguage;
  }
}
