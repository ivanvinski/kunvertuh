package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.NonSI.LITER;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class TestVolumeUnitsModelImpl {

  private static final BigDecimal SOURCE_VOLUME = new BigDecimal(10430d);

  private VolumeUnitsModel model = new VolumeUnitsModelImpl();

  @Before
  public void setUp() {
    model.convert(SOURCE_VOLUME, LITER);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(new BigDecimal(0d), null);
  }

  @Test
  public void convertsNullSourceVolumeToNullValues() {
    model.convert(null, LITER);
    assertEquals(null, model.getLiters());
  }

  @Test
  public void convertNonNullVolumeToLiters() {
    assertEquals(10430d, model.getLiters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToCubicMeters() {
    assertEquals(10.43000d, model.getCubicMeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToGallons() {
    assertEquals(2294.279d, model.getGallons().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullVolumeToCubicInches() {
    assertEquals(636477.65d, model.getCubicInches().doubleValue(), IMPERIAL_DELTA);
  }
}
