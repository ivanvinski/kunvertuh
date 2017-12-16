package com.ivanvinski.kunvertuh.unit;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MassUnitTest {

  private static final double SOURCE_MASS = 100d;

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    MassUnit.GRAMS.convert(SOURCE_MASS, null);
  }

  @Test
  public void nullSourceMassConversionReturnsNull() {
    assertEquals(null, MassUnit.GRAMS.convert(null, MassUnit.GRAMS));
  }

  @Test
  public void convertsGramsToMilligrams() {
    assertEquals(100000d, MassUnit.GRAMS.toMilligrams(SOURCE_MASS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToGrams() {
    assertEquals(100d, MassUnit.GRAMS.toGrams(SOURCE_MASS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToDekagrams() {
    assertEquals(10d, MassUnit.GRAMS.toDekagrams(SOURCE_MASS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToKilograms() {
    assertEquals(0.1d, MassUnit.GRAMS.toKilograms(SOURCE_MASS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToGrains() {
    assertEquals(1543.24d, MassUnit.GRAMS.toGrains(SOURCE_MASS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToDrams() {
    assertEquals(56.44d, MassUnit.GRAMS.toDrams(SOURCE_MASS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToOunces() {
    assertEquals(3.53d, MassUnit.GRAMS.toOunces(SOURCE_MASS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToPounds() {
    assertEquals(0.22d, MassUnit.GRAMS.toPounds(SOURCE_MASS), IMPERIAL_DELTA);
  }
}
