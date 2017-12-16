package com.ivanvinski.kunvertuh.unit;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthUnitTest {

  private static final double SOURCE_LENGTH = 50d;

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    LengthUnit.METERS.convert(SOURCE_LENGTH, null);
  }

  @Test
  public void nullSourceLengthConversionReturnsNull() {
    assertEquals(null, LengthUnit.METERS.convert(null, LengthUnit.METERS));
  }

  @Test
  public void convertsMetersToMillimeters() {
    assertEquals(50000d, LengthUnit.METERS.toMillimeters(SOURCE_LENGTH), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToCentimeters() {
    assertEquals(5000d, LengthUnit.METERS.toCentimeters(SOURCE_LENGTH), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToDecimeters() {
    assertEquals(500d, LengthUnit.METERS.toDecimeters(SOURCE_LENGTH), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToMeters() {
    assertEquals(50d, LengthUnit.METERS.toMeters(SOURCE_LENGTH), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToKilometers() {
    assertEquals(0.05d, LengthUnit.METERS.toKilometers(SOURCE_LENGTH), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToInches() {
    assertEquals(1968.50d, LengthUnit.METERS.toInches(SOURCE_LENGTH), IMPERIAL_DELTA);
  }

  @Test
  public void convertsMetersToFeet() {
    assertEquals(164.04d, LengthUnit.METERS.toFeet(SOURCE_LENGTH), IMPERIAL_DELTA);
  }

  @Test
  public void convertsMetersToYards() {
    assertEquals(54.68d, LengthUnit.METERS.toYards(SOURCE_LENGTH), IMPERIAL_DELTA);
  }

  @Test
  public void convertsMetersToMiles() {
    assertEquals(0.031d, LengthUnit.METERS.toMiles(SOURCE_LENGTH), IMPERIAL_DELTA);
  }
}
