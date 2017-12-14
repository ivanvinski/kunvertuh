package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.MassUnit;
import java.util.Objects;

public class MassUnitsModelImpl implements MassUnitsModel {

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

  @Override
  public Double getMilligrams() {
    return milligrams;
  }

  @Override
  public Double getGrams() {
    return grams;
  }

  @Override
  public Double getDekagrams() {
    return dekagrams;
  }

  @Override
  public Double getKilograms() {
    return kilograms;
  }

  @Override
  public Double getGrains() {
    return grains;
  }

  @Override
  public Double getDrams() {
    return drams;
  }

  @Override
  public Double getOunces() {
    return ounces;
  }

  @Override
  public Double getPounds() {
    return pounds;
  }
}
