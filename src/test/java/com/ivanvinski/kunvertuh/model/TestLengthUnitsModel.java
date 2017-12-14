package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class TestLengthUnitsModelImpl {

  private static final BigDecimal SOURCE_LENGTH = new BigDecimal(2017d);

  private LengthUnitsModel model = new LengthUnitsModelImpl();

  @Before
  public void setUp() {
    model.convert(SOURCE_LENGTH, METER);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(new BigDecimal(0d), null);
  }

  @Test
  public void convertsNullSourceLengthToNullValues() {
    model.convert(null, METER);
    assertEquals(null, model.getMeters());
  }

  @Test
  public void convertsNonNullLengthToMillimeters() {
    assertEquals(2017000d, model.getMillimeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToCentimeters() {
    assertEquals(201700d, model.getCentimeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToMeters() {
    model.convert(SOURCE_LENGTH, KILOMETER);
    assertEquals(2017000d, model.getMeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToKilometers() {
    assertEquals(2.017d, model.getKilometers().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToInches() {
    assertEquals(79409.45d, model.getInches().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullLengthToFeet() {
    assertEquals(6617.45d, model.getFeet().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullLengthToYards() {
    assertEquals(2205.81d, model.getYards().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullLengthToMiles() {
    assertEquals(1.25d, model.getMiles().doubleValue(), IMPERIAL_DELTA);
  }
}
