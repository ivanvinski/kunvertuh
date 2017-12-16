package com.ivanvinski.kunvertuh.unit;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VolumeUnitTest {

  private static final double SOURCE_VOLUME = 25d;

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    VolumeUnit.LITERS.convert(SOURCE_VOLUME, null);
  }

  @Test
  public void nullSourceVolumeConversionReturnsNull() {
    assertEquals(null, VolumeUnit.LITERS.convert(null, VolumeUnit.LITERS));
  }

  @Test
  public void convertsLitersToMilliliters() {
    assertEquals(25000d, VolumeUnit.LITERS.toMilliliters(SOURCE_VOLUME), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToLiters() {
    assertEquals(25d, VolumeUnit.LITERS.toLiters(SOURCE_VOLUME), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToCubicMeters() {
    assertEquals(0.025d, VolumeUnit.LITERS.toCubicMeters(SOURCE_VOLUME), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToFluidOunces() {
    assertEquals(879.88d, VolumeUnit.LITERS.toFluidOunces(SOURCE_VOLUME), IMPERIAL_DELTA);
  }

  @Test
  public void convertsLitersToPints() {
    assertEquals(43.99d, VolumeUnit.LITERS.toPints(SOURCE_VOLUME), IMPERIAL_DELTA);
  }

  @Test
  public void convertsLitersToGallons() {
    assertEquals(5.5d, VolumeUnit.LITERS.toGallons(SOURCE_VOLUME), IMPERIAL_DELTA);
  }
}
