package com.ivanvinski.kunvertuh.unit;

import static com.ivanvinski.kunvertuh.TestUtils.assertEqualsCompare;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;

public class MassUnitTest {

  private static final BigDecimal SOURCE_MASS = new BigDecimal(1d);
  private static final BigDecimal ONE_GRAM_IN_GRAMS = new BigDecimal(1d);

  private static final BigDecimal ONE_GRAM_IN_DEKAGRAMS = new BigDecimal(.1d);
  private static final BigDecimal ONE_GRAM_IN_KILOGRAMS = new BigDecimal(.001d);
  private static final BigDecimal ONE_GRAM_IN_GRAINS = new BigDecimal(15.43236d);
  private static final BigDecimal ONE_GRAM_IN_OUNCES = new BigDecimal(.03527396d);
  private static final BigDecimal ONE_GRAM_IN_POUNDS = new BigDecimal(.002204623d);

  private static final BigDecimal ONE_DEKAGRAM_IN_GRAMS = new BigDecimal(10d);
  private static final BigDecimal ONE_KILOGRAM_IN_GRAMS = new BigDecimal(1000d);
  private static final BigDecimal ONE_GRAIN_IN_GRAMS = new BigDecimal(.06479891d);
  private static final BigDecimal ONE_OUNCE_IN_GRAMS = new BigDecimal(28.34952d);
  private static final BigDecimal ONE_POUND_IN_GRAMS = new BigDecimal(453.5924d);

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceMassIsNull() {
    MassUnit.GRAMS.convert(null, MassUnit.GRAMS);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    MassUnit.GRAMS.convert(new BigDecimal(0d), null);
  }

  @Test
  public void convertsGramsToGrams() {
    assertEqualsCompare(ONE_GRAM_IN_GRAMS, MassUnit.GRAMS.toGrams(SOURCE_MASS));
  }

  @Test
  public void convertsGramsToDekagrams() {
    assertEqualsCompare(ONE_GRAM_IN_DEKAGRAMS, MassUnit.GRAMS.toDekagrams(SOURCE_MASS));
  }

  @Test
  public void convertsGramsToKilograms() {
    assertEqualsCompare(ONE_GRAM_IN_KILOGRAMS, MassUnit.GRAMS.toKilograms(SOURCE_MASS));
  }

  @Test
  public void convertsGramsToGrains() {
    assertEqualsCompare(ONE_GRAM_IN_GRAINS, MassUnit.GRAMS.toGrains(SOURCE_MASS));
  }

  @Test
  public void convertsGramsToOunces() {
    assertEqualsCompare(ONE_GRAM_IN_OUNCES, MassUnit.GRAMS.toOunces(SOURCE_MASS));
  }

  @Test
  public void convertsGramsToPounds() {
    assertEqualsCompare(ONE_GRAM_IN_POUNDS, MassUnit.GRAMS.toPounds(SOURCE_MASS));
  }

  @Test
  public void convertsDekagramsToGrams() {
    assertEqualsCompare(ONE_DEKAGRAM_IN_GRAMS, MassUnit.DEKAGRAMS.toGrams(SOURCE_MASS));
  }

  @Test
  public void convertsKilogramsToGrams() {
    assertEqualsCompare(ONE_KILOGRAM_IN_GRAMS, MassUnit.KILOGRAMS.toGrams(SOURCE_MASS));
  }

  @Test
  public void convertsGrainsToGrams() {
    assertEqualsCompare(ONE_GRAIN_IN_GRAMS, MassUnit.GRAINS.toGrams(SOURCE_MASS));
  }

  @Test
  public void convertsOuncesToGrams() {
    assertEqualsCompare(ONE_OUNCE_IN_GRAMS, MassUnit.OUNCES.toGrams(SOURCE_MASS));
  }

  @Test
  public void convertsPoundsToGrams() {
    assertEqualsCompare(ONE_POUND_IN_GRAMS, MassUnit.POUNDS.toGrams(SOURCE_MASS));
  }

  @Test
  public void testGramsAbbreviation() {
    assertEquals("g", MassUnit.GRAMS.getAbbreviation());
  }

  @Test
  public void testDekagramsAbbreviation() {
    assertEquals("dag", MassUnit.DEKAGRAMS.getAbbreviation());
  }

  @Test
  public void testKilogramsAbbreviation() {
    assertEquals("kg", MassUnit.KILOGRAMS.getAbbreviation());
  }

  @Test
  public void testGrainsAbbreviation() {
    assertEquals("gr", MassUnit.GRAINS.getAbbreviation());
  }

  @Test
  public void testOuncesAbbreviation() {
    assertEquals("oz", MassUnit.OUNCES.getAbbreviation());
  }

  @Test
  public void testPoundsAbbreviation() {
    assertEquals("lb", MassUnit.POUNDS.getAbbreviation());
  }
}
