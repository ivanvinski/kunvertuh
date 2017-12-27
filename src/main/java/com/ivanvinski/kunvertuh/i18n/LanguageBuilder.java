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
