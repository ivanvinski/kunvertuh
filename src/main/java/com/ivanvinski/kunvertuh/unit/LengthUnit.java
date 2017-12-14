package com.ivanvinski.kunvertuh.unit;

import java.util.Objects;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Length;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.Unit;

public enum LengthUnit {

  METERS(new BaseUnit<>("m")),
  MILLIMETERS(METERS.lengthUnit.times(1000d)),
  CENTIMETERS(METERS.lengthUnit.times(100d)),
  DECIMETERS(METERS.lengthUnit.times(10d)),
  KILOMETERS(METERS.lengthUnit.divide(1000d)),

  INCHES(METERS.lengthUnit.times(39.370d)),
  FEET(METERS.lengthUnit.times(3.2808d)),
  YARDS(METERS.lengthUnit.times(1.0936d)),
  MILES(METERS.lengthUnit.times(0.00062137d));

  private Unit<Length> lengthUnit;

  LengthUnit(Unit<Length> lengthUnit) {
    this.lengthUnit = lengthUnit;
  }

  public Double convert(Double sourceLength, LengthUnit sourceUnit) {
    if (sourceLength == null) {
      return null;
    }
    Unit<Length> actualSourceUnit = Objects.requireNonNull(sourceUnit).lengthUnit;
    UnitConverter converter = lengthUnit.getConverterTo(actualSourceUnit);
    return converter.convert(sourceLength);
  }

  public Double toMillimeters(Double sourceLength) {
    return MILLIMETERS.convert(sourceLength, this);
  }

  public Double toCentimeters(Double sourceLength) {
    return CENTIMETERS.convert(sourceLength, this);
  }

  public Double toMeters(Double sourceLength) {
    return METERS.convert(sourceLength, this);
  }

  public Double toDecimeters(Double sourceLength) {
    return DECIMETERS.convert(sourceLength, this);
  }

  public Double toKilometers(Double sourceLength) {
    return KILOMETERS.convert(sourceLength, this);
  }

  public Double toInches(Double sourceLength) {
    return INCHES.convert(sourceLength, this);
  }

  public Double toFeet(Double sourceLength) {
    return FEET.convert(sourceLength, this);
  }

  public Double toYards(Double sourceLength) {
    return YARDS.convert(sourceLength, this);
  }

  public Double toMiles(Double sourceLength) {
    return MILES.convert(sourceLength, this);
  }
}
