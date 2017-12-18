package com.ivanvinski.kunvertuh.unit.converter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static com.ivanvinski.kunvertuh.unit.MassUnit.GRAMS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MassUnitConverterTest {

  private final MassUnitConverter unitConverter = new MassUnitConverter();
  private final double sourceMass = 1d;

  @Test
  public void convertsGramsToMilligrams() {
    assertEquals(1000d, unitConverter.toMilligrams(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToGrams() {
    assertEquals(sourceMass, unitConverter.toGrams(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToDekagrams() {
    assertEquals(.1d, unitConverter.toDekagrams(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToKilograms() {
    assertEquals(.001d, unitConverter.toKilograms(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToGrains() {
    assertEquals(15.432d, unitConverter.toGrains(sourceMass, GRAMS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToDrams() {
    assertEquals(.564d, unitConverter.toDrams(sourceMass, GRAMS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToOunces() {
    assertEquals(0.035d, unitConverter.toOunces(sourceMass, GRAMS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToPounds() {
    assertEquals(0.002d, unitConverter.toPounds(sourceMass, GRAMS), IMPERIAL_DELTA);
  }
}
