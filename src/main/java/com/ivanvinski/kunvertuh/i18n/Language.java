/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.i18n;

import java.text.NumberFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Language {

  public static final Language ENGLISH = new LanguageBuilder("English", "en")
      .setGroupingSeparator(',')
      .setDecimalSeparator('.')
      .build();
  public static final Language CROATIAN = new LanguageBuilder("Hrvatski", "hr")
      .setGroupingSeparator('.')
      .setDecimalSeparator(',')
      .build();
  public static final Language[] ALL = new Language[]{ENGLISH, CROATIAN};

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

  @Override
  public String toString() {
    return getName();
  }
}
