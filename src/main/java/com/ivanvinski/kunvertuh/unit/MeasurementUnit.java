package com.ivanvinski.kunvertuh.unit;

public class MeasurementUnit {

  private String abbreviation;
  private double baseUnitFactor;

  public MeasurementUnit(String abbreviation, double baseUnitFactor) {
    this.abbreviation = abbreviation;
    this.baseUnitFactor = baseUnitFactor;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }
}
