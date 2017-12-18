package com.ivanvinski.kunvertuh.unit.converter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.LITERS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VolumeUnitConverterTest {

  private final VolumeUnitConverter unitConverter = new VolumeUnitConverter();
  private final double sourceVolume = 1d;

  @Test
  public void convertsLitersToMilliliters() {
    assertEquals(1000d, unitConverter.toMilliliters(sourceVolume, LITERS), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToLiters() {
    assertEquals(sourceVolume, unitConverter.toLiters(sourceVolume, LITERS), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToCubicMeters() {
    assertEquals(0.001d, unitConverter.toCubicMeters(sourceVolume, LITERS), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToFluidOunces() {
    assertEquals(35.195d, unitConverter.toFluidOunces(sourceVolume, LITERS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsLitersToPints() {
    assertEquals(1.760d, unitConverter.toPints(sourceVolume, LITERS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsLitersToGallons() {
    assertEquals(0.220d, unitConverter.toGallons(sourceVolume, LITERS), IMPERIAL_DELTA);
  }
}
