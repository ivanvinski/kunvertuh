package com.ivanvinski.kunvertuh.unit.converter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.unit.MeasurementUnit;
import org.junit.Test;

public class MeasurementUnitConverterTest {

  private final MeasurementUnitConverter unitConverter = new MeasurementUnitConverter();
  private final MeasurementUnit unit = new MeasurementUnit("", 0d);

  @Test
  public void nullSourceValueConversionReturnsNull() {
    assertEquals(null, unitConverter.convert(null, unit, unit));
  }

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    unitConverter.convert(0d, null, unit);
  }

  @Test(expected = NullPointerException.class)
  public void nullOutputUnitConversionThrowsException() {
    unitConverter.convert(0d, unit, null);
  }
}
