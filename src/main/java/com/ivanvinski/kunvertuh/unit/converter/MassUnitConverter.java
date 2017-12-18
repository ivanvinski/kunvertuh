package com.ivanvinski.kunvertuh.unit.converter;

import com.ivanvinski.kunvertuh.unit.MassUnit;

public final class MassUnitConverter extends MeasurementUnitConverter<MassUnit> {

  public Double toMilligrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.MILLIGRAMS);
  }

  public Double toGrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.GRAMS);
  }

  public Double toDekagrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.DEKAGRAMS);
  }

  public Double toKilograms(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.KILOGRAMS);
  }

  public Double toGrains(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.GRAINS);
  }

  public Double toDrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.DRAMS);
  }

  public Double toOunces(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.OUNCES);
  }

  public Double toPounds(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.POUNDS);
  }
}
