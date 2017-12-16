package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import org.junit.Before;
import org.junit.Test;

public class LengthUnitsModelTest {

  private static final Double SOURCE_LENGTH = 2017d;
  private LengthUnitsModel model = new LengthUnitsModel();

  @Before
  public void setUp() {
    model.convert(SOURCE_LENGTH, LengthUnit.METERS);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(0d, null);
  }

  @Test
  public void convertsNullSourceLengthToNullValues() {
    model.convert(null, LengthUnit.METERS);
    assertEquals(null, model.getMeters());
  }

  @Test
  public void convertsNonNullLengthToMillimeters() {
    assertEquals(2017000d, model.getMillimeters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToCentimeters() {
    assertEquals(201700d, model.getCentimeters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToDecimeters() {
    assertEquals(20170d, model.getDecimeters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToMeters() {
    assertEquals(2017d, model.getMeters(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToKilometers() {
    assertEquals(2.017d, model.getKilometers(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullLengthToInches() {
    assertEquals(79409.29d, model.getInches(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullLengthToFeet() {
    assertEquals(6617.45d, model.getFeet(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullLengthToYards() {
    assertEquals(2205.81d, model.getYards(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullLengthToMiles() {
    assertEquals(1.25d, model.getMiles(), IMPERIAL_DELTA);
  }
}
