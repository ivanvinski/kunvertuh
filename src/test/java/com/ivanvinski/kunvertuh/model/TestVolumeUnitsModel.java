package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import org.junit.Before;
import org.junit.Test;

public class TestVolumeUnitsModel {

  private static final Double SOURCE_VOLUME = 10430d;
  private VolumeUnitsModel model = new VolumeUnitsModel();

  @Before
  public void setUp() {
    model.convert(SOURCE_VOLUME, VolumeUnit.LITERS);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(0d, null);
  }

  @Test
  public void convertsNullSourceVolumeToNullValues() {
    model.convert(null, VolumeUnit.LITERS);
    assertEquals(null, model.getLiters());
  }

  @Test
  public void conversNonNullVolumeToMilliliters() {
    assertEquals(10430000d, model.getMilliliters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToLiters() {
    assertEquals(10430d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToCubicMeters() {
    assertEquals(10.43d, model.getCubicMeters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToFluidOunces() {
    assertEquals(367084.2d, model.getFluidOunces(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToPints() {
    assertEquals(18354.23d, model.getPints(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToGallons() {
    assertEquals(2294.28d, model.getGallons(), IMPERIAL_DELTA);
  }
}
