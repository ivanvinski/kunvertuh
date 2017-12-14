package com.ivanvinski.kunvertuh.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;

public class DoubleStringConverter implements StringConverter<Double> {

  private NumberFormat valueFormat;

  public DoubleStringConverter() {
    this(new DecimalFormat("#0.000#######"));
  }

  public DoubleStringConverter(NumberFormat valueFormat) {
    this.valueFormat = Objects.requireNonNull(valueFormat);
  }

  @Override
  public String format(Double value) {
    return value == null ? "" : valueFormat.format(value);
  }

  @Override
  public Double parse(String value) {
    try {
      return value == null ? null : valueFormat.parse(value).doubleValue();
    } catch (ParseException e) {
      return null;
    }
  }
}
