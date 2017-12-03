package com.ivanvinski.kunvertuh.unit;

import static com.ivanvinski.kunvertuh.TestUtils.assertEqualsCompare;

import java.math.BigDecimal;
import org.junit.Test;

public class LengthUnitTest {

  private static final BigDecimal SOURCE_LENGTH = new BigDecimal(1d);
  private static final BigDecimal ONE_METER_IN_METERS = new BigDecimal(1d);

  private static final BigDecimal ONE_METER_IN_MILLIMETERS = new BigDecimal(1000d);
  private static final BigDecimal ONE_METER_IN_CENTIMETERS = new BigDecimal(100d);
  private static final BigDecimal ONE_METER_IN_KILOMETERS = new BigDecimal(.001d);
  private static final BigDecimal ONE_METER_IN_INCHES = new BigDecimal(39.37008d);
  private static final BigDecimal ONE_METER_IN_FEET = new BigDecimal(3.28084d);
  private static final BigDecimal ONE_METER_IN_YARDS = new BigDecimal(1.093613d);
  private static final BigDecimal ONE_METER_IN_MILES = new BigDecimal(.0006213712d);

  private static final BigDecimal ONE_MILLIMETER_IN_METERS = new BigDecimal(.001d);
  private static final BigDecimal ONE_CENTIMETER_IN_METERS = new BigDecimal(.01d);
  private static final BigDecimal ONE_KILOMETER_IN_METERS = new BigDecimal(1000d);
  private static final BigDecimal ONE_INCH_IN_METERS = new BigDecimal(.0254d);
  private static final BigDecimal ONE_FOOT_IN_METERS = new BigDecimal(.3048d);
  private static final BigDecimal ONE_YARD_IN_METERS = new BigDecimal(.9144d);
  private static final BigDecimal ONE_MILE_IN_METERS = new BigDecimal(1609.344d);

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceLengthIsNull() {
    LengthUnit.METERS.convert(null, LengthUnit.METERS);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    LengthUnit.METERS.convert(new BigDecimal(0d), null);
  }

  @Test
  public void convertsMetersToMeters() {
    assertEqualsCompare(ONE_METER_IN_METERS, LengthUnit.METERS.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToMillimeters() {
    assertEqualsCompare(ONE_METER_IN_MILLIMETERS, LengthUnit.METERS.toMillimeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToCentimeters() {
    assertEqualsCompare(ONE_METER_IN_CENTIMETERS, LengthUnit.METERS.toCentimeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToKilometers() {
    assertEqualsCompare(ONE_METER_IN_KILOMETERS, LengthUnit.METERS.toKilometers(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToInches() {
    assertEqualsCompare(ONE_METER_IN_INCHES, LengthUnit.METERS.toInches(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToFeet() {
    assertEqualsCompare(ONE_METER_IN_FEET, LengthUnit.METERS.toFeet(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToYards() {
    assertEqualsCompare(ONE_METER_IN_YARDS, LengthUnit.METERS.toYards(SOURCE_LENGTH));
  }

  @Test
  public void convertsMetersToMiles() {
    assertEqualsCompare(ONE_METER_IN_MILES, LengthUnit.METERS.toMiles(SOURCE_LENGTH));
  }

  @Test
  public void convertsMillimetersToMeters() {
    assertEqualsCompare(ONE_MILLIMETER_IN_METERS, LengthUnit.MILLIMETERS.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsCentimetersToMeters() {
    assertEqualsCompare(ONE_CENTIMETER_IN_METERS, LengthUnit.CENTIMETERS.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsKilometersToMeters() {
    assertEqualsCompare(ONE_KILOMETER_IN_METERS, LengthUnit.KILOMETERS.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsInchesToMeters() {
    assertEqualsCompare(ONE_INCH_IN_METERS, LengthUnit.INCHES.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsFeetToMeters() {
    assertEqualsCompare(ONE_FOOT_IN_METERS, LengthUnit.FEET.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsYardsToMeters() {
    assertEqualsCompare(ONE_YARD_IN_METERS, LengthUnit.YARDS.toMeters(SOURCE_LENGTH));
  }

  @Test
  public void convertsMilesToMeters() {
    assertEqualsCompare(ONE_MILE_IN_METERS, LengthUnit.MILES.toMeters(SOURCE_LENGTH));
  }
}
