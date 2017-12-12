package com.ivanvinski.kunvertuh.util;

import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;

public class TestSimpleUnitConverter {

  private SimpleUnitConverter converter = new SimpleUnitConverter();

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    converter.convert(new BigDecimal(0d), null, METER);
  }

  @Test(expected = NullPointerException.class)
  public void nullOutputUnitConversionThrowsException() {
    converter.convert(new BigDecimal(0d), METER, null);
  }

  @Test
  public void nullSourceValueConversionReturnsNull() {
    assertEquals(null, converter.convert(null, METER, KILOMETER));
  }

  @Test
  public void nonNullSourceValueConversionReturnsConvertedValue() {
    BigDecimal input = new BigDecimal(10.430d);
    assertEquals(10430d, converter.convert(input, KILOMETER, METER).doubleValue(), 0d);
  }
}
