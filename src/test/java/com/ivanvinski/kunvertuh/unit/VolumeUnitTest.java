package com.ivanvinski.kunvertuh.unit;

import static com.ivanvinski.kunvertuh.TestUtils.assertEqualsCompare;

import java.math.BigDecimal;
import org.junit.Test;

public class VolumeUnitTest {

  private static final BigDecimal SOURCE_VOLUME = new BigDecimal(1d);
  private static final BigDecimal ONE_LITER_IN_LITERS = new BigDecimal(1d);

  private static final BigDecimal ONE_LITER_IN_MILLILITERS = new BigDecimal(1000d);
  private static final BigDecimal ONE_LITER_IN_DECILITERS = new BigDecimal(10d);
  private static final BigDecimal ONE_LITER_IN_FLUID_OUNCES = new BigDecimal(35.19503d);
  private static final BigDecimal ONE_LITER_IN_QUARTS = new BigDecimal(.8798789d);
  private static final BigDecimal ONE_LITER_IN_GALLONS = new BigDecimal(.2199692d);

  private static final BigDecimal ONE_MILLILITER_IN_LITERS = new BigDecimal(.001d);
  private static final BigDecimal ONE_DECILITER_IN_LITERS = new BigDecimal(.1d);
  private static final BigDecimal ONE_FLUID_OUNCE_IN_LITERS = new BigDecimal(.0284131d);
  private static final BigDecimal ONE_QUART_IN_LITERS = new BigDecimal(1.13652d);
  private static final BigDecimal ONE_GALLON_IN_LITERS = new BigDecimal(4.54609d);

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceVolumeIsNull() {
    VolumeUnit.LITERS.convert(null, VolumeUnit.LITERS);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    VolumeUnit.LITERS.convert(new BigDecimal(0d), null);
  }

  @Test
  public void convertsLitersToLiters() {
    assertEqualsCompare(ONE_LITER_IN_LITERS, VolumeUnit.LITERS.toLiters(SOURCE_VOLUME));
  }

  @Test
  public void convertsLitersToMilliliters() {
    assertEqualsCompare(ONE_LITER_IN_MILLILITERS, VolumeUnit.LITERS.toMillimeters(SOURCE_VOLUME));
  }

  @Test
  public void convertsLitersToDeciliters() {
    assertEqualsCompare(ONE_LITER_IN_DECILITERS, VolumeUnit.LITERS.toDeciliters(SOURCE_VOLUME));
  }

  @Test
  public void convertsLitersToFluidOunces() {
    assertEqualsCompare(ONE_LITER_IN_FLUID_OUNCES, VolumeUnit.LITERS.toFluidOunces(SOURCE_VOLUME));
  }

  @Test
  public void convertsLitersToQuarts() {
    assertEqualsCompare(ONE_LITER_IN_QUARTS, VolumeUnit.LITERS.toQuarts(SOURCE_VOLUME));
  }

  @Test
  public void convertsLitersToGallons() {
    assertEqualsCompare(ONE_LITER_IN_GALLONS, VolumeUnit.LITERS.toGallons(SOURCE_VOLUME));
  }

  @Test
  public void convertsMillilitersToLiters() {
    assertEqualsCompare(ONE_MILLILITER_IN_LITERS, VolumeUnit.MILLILITERS.toLiters(SOURCE_VOLUME));
  }

  @Test
  public void convertsDecilitersToLiters() {
    assertEqualsCompare(ONE_DECILITER_IN_LITERS, VolumeUnit.DECILITERS.toLiters(SOURCE_VOLUME));
  }

  @Test
  public void convertsFluidOuncesToLiters() {
    assertEqualsCompare(ONE_FLUID_OUNCE_IN_LITERS, VolumeUnit.FLUID_OUNCES.toLiters(SOURCE_VOLUME));
  }

  @Test
  public void convertsQuartsToLiters() {
    assertEqualsCompare(ONE_QUART_IN_LITERS, VolumeUnit.QUARTS.toLiters(SOURCE_VOLUME));
  }

  @Test
  public void convertsGallonsToLiters() {
    assertEqualsCompare(ONE_GALLON_IN_LITERS, VolumeUnit.GALLONS.toLiters(SOURCE_VOLUME));
  }
}
