package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.MassUnit;
import com.ivanvinski.kunvertuh.unit.converter.MassUnitConverter;

public class MassUnitsModel implements UnitsModel<MassUnit> {

  private MassUnitConverter unitConverter = new MassUnitConverter();
  private Double milligrams, grams, dekagrams, kilograms;
  private Double grains, drams, ounces, pounds;

  @Override
  public void convert(Double sourceMass, MassUnit sourceUnit) {
    milligrams = getUnitConverter().toMilligrams(sourceMass, sourceUnit);
    grams = getUnitConverter().toGrams(sourceMass, sourceUnit);
    dekagrams = getUnitConverter().toDekagrams(sourceMass, sourceUnit);
    kilograms = getUnitConverter().toKilograms(sourceMass, sourceUnit);
    grains = getUnitConverter().toGrains(sourceMass, sourceUnit);
    drams = getUnitConverter().toDrams(sourceMass, sourceUnit);
    ounces = getUnitConverter().toOunces(sourceMass, sourceUnit);
    pounds = getUnitConverter().toPounds(sourceMass, sourceUnit);
  }

  @Override
  public MassUnitConverter getUnitConverter() {
    return unitConverter;
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
