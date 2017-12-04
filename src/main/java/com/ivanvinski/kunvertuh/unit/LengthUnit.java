package com.ivanvinski.kunvertuh.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public enum LengthUnit {

  MILLIMETERS("mm", 1000d),
  CENTIMETERS("cm", 100d),
  METERS("m", 1d),
  KILOMETERS("km", .001d),

  INCHES("in", 39.37008d),
  FEET("ft", 3.28084d),
  YARDS("yd", 1.093613d),
  MILES("mi", .0006213712d);

  private String abbreviation;
  private BigDecimal scale;

  LengthUnit(String abbreviation, double scale) {
    this.abbreviation = abbreviation;
    this.scale = new BigDecimal(scale);
  }

  public BigDecimal convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
    Objects.requireNonNull(sourceLength, "Can't convert null length");
    Objects.requireNonNull(sourceUnit, "Can't convert null length unit");
    BigDecimal meters = sourceLength.divide(sourceUnit.getScale(), 3, RoundingMode.HALF_EVEN);
    return meters.multiply(getScale());
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public BigDecimal getScale() {
    return scale;
  }

  public BigDecimal toMillimeters(BigDecimal length) {
    return toLengthUnit(LengthUnit.MILLIMETERS, length);
  }

  public BigDecimal toCentimeters(BigDecimal length) {
    return toLengthUnit(LengthUnit.CENTIMETERS, length);
  }

  public BigDecimal toMeters(BigDecimal length) {
    return toLengthUnit(LengthUnit.METERS, length);
  }

  public BigDecimal toKilometers(BigDecimal length) {
    return toLengthUnit(LengthUnit.KILOMETERS, length);
  }

  public BigDecimal toInches(BigDecimal length) {
    return toLengthUnit(LengthUnit.INCHES, length);
  }

  public BigDecimal toFeet(BigDecimal length) {
    return toLengthUnit(LengthUnit.FEET, length);
  }

  public BigDecimal toYards(BigDecimal length) {
    return toLengthUnit(LengthUnit.YARDS, length);
  }

  public BigDecimal toMiles(BigDecimal length) {
    return toLengthUnit(LengthUnit.MILES, length);
  }

  private BigDecimal toLengthUnit(LengthUnit resultUnit, BigDecimal sourceLength) {
    return resultUnit.convert(sourceLength, this);
  }
}
