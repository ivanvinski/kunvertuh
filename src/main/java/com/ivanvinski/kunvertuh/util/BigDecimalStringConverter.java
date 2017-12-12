package com.ivanvinski.kunvertuh.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Objects;

public class BigDecimalStringConverter implements Converter<String, BigDecimal> {

  private NumberFormat valueFormat;

  public BigDecimalStringConverter() {
    this(new DecimalFormat("#0.000#######"));
  }

  public BigDecimalStringConverter(NumberFormat valueFormat) {
    this.valueFormat = Objects.requireNonNull(valueFormat);
  }

  @Override
  public String format(BigDecimal value) {
    return value == null ? "" : valueFormat.format(value);
  }

  @Override
  public BigDecimal parse(String value) {
    try {
      return new BigDecimal(valueFormat.parse(value).longValue());
    } catch (ParseException e) {
      return null;
    }
  }
}
