package com.ivanvinski.kunvertuh.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.junit.Test;

public class TestBigDecimalStringConverter {

  private NumberFormat valueFormat = new DecimalFormat("#0.00");
  private BigDecimalStringConverter converter = new BigDecimalStringConverter(valueFormat);

  @Test(expected = NullPointerException.class)
  public void nullNumberFormatInstantiationThrowsException() {
    new BigDecimalStringConverter(null);
  }

  @Test
  public void formattingNullBigDecimalReturnsEmptyString() {
    assertEquals("", converter.format(null));
  }

  @Test
  public void formattingNonNullBigDecimalReturnsFormattedString() {
    assertEquals("150.12", converter.format(new BigDecimal(150.125d)));
  }

  @Test
  public void parsingNullStringReturnsNull() {
    assertEquals(null, converter.parse(null));
  }

  @Test
  public void parsingInvalidNumberReturnsNull() {
    assertEquals(null, converter.parse("a123.d5"));
  }

  @Test
  public void parsingValidNumberReturnsBigDecimal() {
    assertEquals(150.125d, converter.parse("150.125").doubleValue(), 0d);
  }
}
