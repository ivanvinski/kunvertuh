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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public final class LanguageBuilder {

  private final String name;
  private final Locale locale;
  private String numberFormatPattern = "###,###,###,##0.00########";
  private char groupingSeparator = '.', decimalSeparator = ',';

  public LanguageBuilder(String name, String languageTag) {
    this.name = name;
    locale = new Locale.Builder()
        .setLanguageTag(languageTag)
        .build();
  }

  public Language build() {
    DecimalFormatSymbols numberFormatSymbols = DecimalFormatSymbols.getInstance();
    numberFormatSymbols.setGroupingSeparator(groupingSeparator);
    numberFormatSymbols.setDecimalSeparator(decimalSeparator);
    NumberFormat numberFormat = new DecimalFormat(numberFormatPattern, numberFormatSymbols);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("language.language", locale);
    return new Language(name, numberFormat, resourceBundle);
  }

  public LanguageBuilder setNumberFormatPattern(String numberFormatPattern) {
    this.numberFormatPattern = numberFormatPattern;
    return this;
  }

  public LanguageBuilder setGroupingSeparator(char groupingSeparator) {
    this.groupingSeparator = groupingSeparator;
    return this;
  }

  public LanguageBuilder setDecimalSeparator(char decimalSeparator) {
    this.decimalSeparator = decimalSeparator;
    return this;
  }
}
