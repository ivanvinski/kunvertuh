package com.ivanvinski.kunvertuh.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthUnitTest {

  @Test
  public void validateMillimetersAbbreviation() {
    assertEquals("mm", LengthUnit.MILLIMETERS.getAbbreviation());
  }

  @Test
  public void validateCentimetersAbbreviation() {
    assertEquals("cm", LengthUnit.CENTIMETERS.getAbbreviation());
  }

  @Test
  public void validateDecimetersAbbreviation() {
    assertEquals("dm", LengthUnit.DECIMETERS.getAbbreviation());
  }

  @Test
  public void validateMetersAbbreviation() {
    assertEquals("m", LengthUnit.METERS.getAbbreviation());
  }

  @Test
  public void validateKilometersAbbreviation() {
    assertEquals("km", LengthUnit.KILOMETERS.getAbbreviation());
  }

  @Test
  public void validateInchesAbbreviation() {
    assertEquals("in", LengthUnit.INCHES.getAbbreviation());
  }

  @Test
  public void validateFeetAbbreviation() {
    assertEquals("ft", LengthUnit.FEET.getAbbreviation());
  }

  @Test
  public void validateYardsAbbreviation() {
    assertEquals("yd", LengthUnit.YARDS.getAbbreviation());
  }

  @Test
  public void validateMilesAbbreviation() {
    assertEquals("mi", LengthUnit.MILES.getAbbreviation());
  }
}
