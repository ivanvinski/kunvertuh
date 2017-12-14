package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.MassUnit;
import java.util.Objects;

public class MassUnitsModel implements UnitsModel<MassUnit> {

  private Double milligrams, grams, dekagrams, kilograms;
  private Double grains, drams, ounces, pounds;

  @Override
  public void convert(Double sourceMass, MassUnit sourceUnit) {
    Objects.requireNonNull(sourceUnit, "Source unit can't be null");
    milligrams = sourceUnit.toMilligrams(sourceMass);
    grams = sourceUnit.toGrams(sourceMass);
    dekagrams = sourceUnit.toDekagrams(sourceMass);
    kilograms = sourceUnit.toKilograms(sourceMass);
    grains = sourceUnit.toGrains(sourceMass);
    drams = sourceUnit.toDrams(sourceMass);
    ounces = sourceUnit.toOunces(sourceMass);
    pounds = sourceUnit.toPounds(sourceMass);
  }

  public Double getMilligrams() {
    return milligrams;
  }

  public Double getGrams() {
    return grams;
  }

  public Double getDekagrams() {
    return dekagrams;
  }

  public Double getKilograms() {
    return kilograms;
  }

  public Double getGrains() {
    return grains;
  }

  public Double getDrams() {
    return drams;
  }

  public Double getOunces() {
    return ounces;
  }

  public Double getPounds() {
    return pounds;
  }
}
