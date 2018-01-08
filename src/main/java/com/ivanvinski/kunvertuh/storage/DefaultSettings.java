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

package com.ivanvinski.kunvertuh.storage;

import com.ivanvinski.kunvertuh.Kunvertuh;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.i18n.NumberFormats;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Optional;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class DefaultSettings implements Settings {

  private static final String LANGUAGE_KEY = "language";
  private static final String DECIMAL_SEPARATOR_KEY = "decimal_separator";
  private static final String GROUPING_SEPARATOR_KEY = "grouping_separator";

  private final Preferences preferences = Preferences.userNodeForPackage(Kunvertuh.class);

  @Override
  public void reset() {
    try {
      preferences.clear();
    } catch (BackingStoreException e) {
      throw new RuntimeException("Error resetting settings");
    }
    saveAndSync("Error while persisting settings reset");
  }

  @Override
  public Optional<Language> getLanguage() {
    String languageName = preferences.get(LANGUAGE_KEY, "");
    Language language = getLanguageByName(languageName);
    return Optional.ofNullable(language);
  }

  @Override
  public void setLanguage(Language language) {
    Objects.requireNonNull(language, "Can't store null language");
    preferences.put(LANGUAGE_KEY, language.getName());
    saveAndSync("Error while persisting language change");
  }

  @Override
  public Optional<NumberFormat> getNumberFormat() {
    String decimalSeparator = preferences.get(DECIMAL_SEPARATOR_KEY, "");
    NumberFormat numberFormat = getNumberFormatByDecimalSeparator(decimalSeparator);
    return Optional.ofNullable(numberFormat);
  }

  @Override
  public void setNumberFormat(NumberFormat numberFormat) {
    Objects.requireNonNull(numberFormat, "Can't store null number format");
    DecimalFormatSymbols formatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
    preferences.put(DECIMAL_SEPARATOR_KEY, "" + formatSymbols.getDecimalSeparator());
    preferences.put(GROUPING_SEPARATOR_KEY, "" + formatSymbols.getGroupingSeparator());
    saveAndSync("Error while persisting number format change");
  }

  private Language getLanguageByName(String languageName) {
    for (Language language : Language.ALL) {
      if (languageName.equals(language.getName())) {
        return language;
      }
    }
    return null;
  }

  private NumberFormat getNumberFormatByDecimalSeparator(String decimalSeparator) {
    if (decimalSeparator.equals(".")) {
      return NumberFormats.DOT_AS_DECIMAL_SEPARATOR;
    } else if (decimalSeparator.equals(",")) {
      return NumberFormats.COMMA_AS_DECIMAL_SEPARATOR;
    }
    return null;
  }

  private void saveAndSync(String errorMessage) {
    try {
      preferences.flush();
      preferences.sync();
    } catch (BackingStoreException e) {
      throw new RuntimeException(errorMessage);
    }
  }
}
