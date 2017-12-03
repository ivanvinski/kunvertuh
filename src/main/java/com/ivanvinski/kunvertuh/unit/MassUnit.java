package com.ivanvinski.kunvertuh.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public enum MassUnit {

  GRAMS("g", 1d),
  DEKAGRAMS("dag", .1d),
  KILOGRAMS("kg", .001d),

  GRAINS("gr", 15.43236d),
  OUNCES("oz", .03527396d),
  POUNDS("lb", .002204623d);

  private String acronym;
  private BigDecimal scale;

  MassUnit(String acronym, double scale) {
    this.acronym = acronym;
    this.scale = new BigDecimal(scale);
  }

  public BigDecimal convert(BigDecimal sourceMass, MassUnit sourceUnit) {
    Objects.requireNonNull(sourceMass, "Can't convert null mass");
    Objects.requireNonNull(sourceUnit, "Can't convert null mass unit");
    BigDecimal grams = sourceMass.divide(sourceUnit.getScale(), 3, RoundingMode.HALF_EVEN);
    return grams.multiply(getScale());
  }

  public String getAcronym() {
    return acronym;
  }

  public BigDecimal getScale() {
    return scale;
  }

  @Override
  public String toString() {
    return String.format("%s (%s)", super.toString().toLowerCase(), getAcronym());
  }

  public BigDecimal toGrams(BigDecimal mass) {
    return toMassUnit(MassUnit.GRAMS, mass);
  }

  public BigDecimal toDekagrams(BigDecimal mass) {
    return toMassUnit(MassUnit.DEKAGRAMS, mass);
  }

  public BigDecimal toKilograms(BigDecimal mass) {
    return toMassUnit(MassUnit.KILOGRAMS, mass);
  }

  public BigDecimal toGrains(BigDecimal mass) {
    return toMassUnit(MassUnit.GRAINS, mass);
  }

  public BigDecimal toOunces(BigDecimal mass) {
    return toMassUnit(MassUnit.OUNCES, mass);
  }

  public BigDecimal toPounds(BigDecimal mass) {
    return toMassUnit(MassUnit.POUNDS, mass);
  }

  private BigDecimal toMassUnit(MassUnit resultUnit, BigDecimal sourceMass) {
    return resultUnit.convert(sourceMass, this);
  }
}
