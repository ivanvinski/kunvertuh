package com.ivanvinski.kunvertuh.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MassUnitTest {

  @Test
  public void validateMilligramsAbbreviation() {
    assertEquals("mg", MassUnit.MILLIGRAMS.getAbbreviation());
  }

  @Test
  public void validateGramsAbbreviation() {
    assertEquals("g", MassUnit.GRAMS.getAbbreviation());
  }

  @Test
  public void validateDekagramsAbbreviation() {
    assertEquals("dag", MassUnit.DEKAGRAMS.getAbbreviation());
  }

  @Test
  public void validateKilogramsAbbreviation() {
    assertEquals("kg", MassUnit.KILOGRAMS.getAbbreviation());
  }

  @Test
  public void validateGrainsAbbreviation() {
    assertEquals("gr", MassUnit.GRAINS.getAbbreviation());
  }

  @Test
  public void validateDramsAbbreviation() {
    assertEquals("dr", MassUnit.DRAMS.getAbbreviation());
  }

  @Test
  public void validateOuncesAbbreviation() {
    assertEquals("oz", MassUnit.OUNCES.getAbbreviation());
  }

  @Test
  public void validatePoundsAbbreviation() {
    assertEquals("lb", MassUnit.POUNDS.getAbbreviation());
  }
}
