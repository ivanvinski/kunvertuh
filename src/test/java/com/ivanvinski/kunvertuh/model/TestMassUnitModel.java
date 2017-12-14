package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.unit.MassUnit;
import org.junit.Before;
import org.junit.Test;

public class TestMassUnitModel {

  private static final Double SOURCE_MASS = 1998d;
  private MassUnitsModel model = new MassUnitsModel();

  @Before
  public void setUp() {
    model.convert(SOURCE_MASS, MassUnit.GRAMS);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(0d, null);
  }

  @Test
  public void convertsNullSourceMassToNullValues() {
    model.convert(null, MassUnit.GRAMS);
    assertEquals(null, model.getGrams());
  }

  @Test
  public void convertsNonNullMassToMilligrams() {
    assertEquals(1998000d, model.getMilligrams(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToGrams() {
    assertEquals(1998d, model.getGrams(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToDekagrams() {
    assertEquals(199.8d, model.getDekagrams(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToKilograms() {
    assertEquals(1.998d, model.getKilograms(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToGrains() {
    assertEquals(30833.14d, model.getGrains(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullMassToDrams() {
    assertEquals(1127.54d, model.getDrams(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullMassToOunces() {
    assertEquals(70.477d, model.getOunces(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullMassToPounds() {
    assertEquals(4.405d, model.getPounds(), IMPERIAL_DELTA);
  }
}
