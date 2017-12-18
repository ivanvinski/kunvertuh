package com.ivanvinski.kunvertuh.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VolumeUnitTest {

  @Test
  public void validateMillilitersAbbreviation() {
    assertEquals("ml", VolumeUnit.MILLILITERS.getAbbreviation());
  }

  @Test
  public void validateLitersAbbreviation() {
    assertEquals("l", VolumeUnit.LITERS.getAbbreviation());
  }

  @Test
  public void validateCubicMetersAbbreviation() {
    assertEquals("m3", VolumeUnit.CUBIC_METERS.getAbbreviation());
  }

  @Test
  public void validateFluidOuncesAbbreviation() {
    assertEquals("fl oz", VolumeUnit.FLUID_OUNCES.getAbbreviation());
  }

  @Test
  public void validatePintsAbbreviation() {
    assertEquals("pt", VolumeUnit.PINTS.getAbbreviation());
  }

  @Test
  public void validateGallonsAbbreviation() {
    assertEquals("gal", VolumeUnit.GALLONS.getAbbreviation());
  }
}
