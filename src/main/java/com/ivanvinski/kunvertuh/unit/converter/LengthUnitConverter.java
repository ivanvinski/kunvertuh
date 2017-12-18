package com.ivanvinski.kunvertuh.unit.converter;

import com.ivanvinski.kunvertuh.unit.LengthUnit;

public final class LengthUnitConverter extends MeasurementUnitConverter<LengthUnit> {

  public Double toMillimeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.MILLIMETERS);
  }

  public Double toCentimeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.CENTIMETERS);
  }

  public Double toDecimeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.DECIMETERS);
  }

  public Double toMeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.METERS);
  }

  public Double toKilometers(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.KILOMETERS);
  }

  public Double toInches(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.INCHES);
  }

  public Double toFeet(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.FEET);
  }

  public Double toYards(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.YARDS);
  }

  public Double toMiles(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.MILES);
  }
}
