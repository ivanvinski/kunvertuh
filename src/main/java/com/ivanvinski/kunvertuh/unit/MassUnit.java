package com.ivanvinski.kunvertuh.unit;

import java.util.Objects;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Mass;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.Unit;

public enum MassUnit {

  GRAMS(new BaseUnit<>("g")),
  MILLIGRAM(GRAMS.massUnit.times(1000d)),
  DEKAGRAMS(GRAMS.massUnit.divide(10d)),
  KILOGRAMS(GRAMS.massUnit.divide(1000d)),

  GRAINS(GRAMS.massUnit.times(15.432d)),
  DRAMS(GRAMS.massUnit.divide(1.772d)),
  OUNCES(GRAMS.massUnit.times(0.035274d)),
  POUNDS(GRAMS.massUnit.times(0.0022046d));

  private Unit<Mass> massUnit;

  MassUnit(Unit<Mass> massUnit) {
    this.massUnit = massUnit;
  }

  public Double convert(Double sourceMass, MassUnit sourceUnit) {
    if (sourceMass == null) {
      return null;
    }
    Unit<Mass> actualSourceUnit = Objects.requireNonNull(sourceUnit).massUnit;
    UnitConverter converter = massUnit.getConverterTo(actualSourceUnit);
    return converter.convert(sourceMass);
  }

  public Double toMilligrams(Double sourceMass) {
    return MILLIGRAM.convert(sourceMass, this);
  }

  public Double toGrams(Double sourceMass) {
    return GRAMS.convert(sourceMass, this);
  }

  public Double toDekagrams(Double sourceMass) {
    return DEKAGRAMS.convert(sourceMass, this);
  }

  public Double toKilograms(Double sourceMass) {
    return KILOGRAMS.convert(sourceMass, this);
  }

  public Double toGrains(Double sourceMass) {
    return GRAINS.convert(sourceMass, this);
  }

  public Double toDrams(Double sourceMass) {
    return DRAMS.convert(sourceMass, this);
  }

  public Double toOunces(Double sourceMass) {
    return OUNCES.convert(sourceMass, this);
  }

  public Double toPounds(Double sourceMass) {
    return POUNDS.convert(sourceMass, this);
  }
}
