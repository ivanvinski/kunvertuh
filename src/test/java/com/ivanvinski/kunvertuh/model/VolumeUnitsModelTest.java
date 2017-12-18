package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.LITERS;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VolumeUnitsModelTest {

  private final VolumeUnitsModel model = new VolumeUnitsModel();
  private final Double sourceVolume = 10430d;

  @Before
  public void setUp() {
    model.convert(sourceVolume, LITERS);
  }

  @Test
  public void nullSourceVolumeConversionReturnsNull() {
    model.convert(null, LITERS);
    assertEquals(null, model.getLiters());
  }

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    model.convert(sourceVolume, null);
  }

  @Test
  public void convertsToMilliliters() {
    assertEquals(10430000d, model.getMilliliters(), METRIC_DELTA);
  }

  @Test
  public void convertsToLiters() {
    assertEquals(10430d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void convertsToCubicMeters() {
    assertEquals(10.43d, model.getCubicMeters(), METRIC_DELTA);
  }

  @Test
  public void convertsToFluidOunces() {
    assertEquals(367084.197d, model.getFluidOunces(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToPints() {
    assertEquals(18354.236d, model.getPints(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToGallons() {
    assertEquals(2294.279d, model.getGallons(), IMPERIAL_DELTA);
  }
}
