package com.ivanvinski.kunvertuh.i18n;

import java.text.NumberFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Language {

  private String name;
  private NumberFormat numberFormat;
  private ResourceBundle resourceBundle;

  Language(String name, NumberFormat numberFormat, ResourceBundle resourceBundle) {
    this.name = name;
    this.numberFormat = numberFormat;
    this.resourceBundle = resourceBundle;
  }

  public String getName() {
    return name;
  }

  public NumberFormat getNumberFormat() {
    return numberFormat;
  }

  public String getString(String key) {
    try {
      return resourceBundle.getString(key);
    } catch (NullPointerException | MissingResourceException e) {
      return "%null%";
    }
  }
}
