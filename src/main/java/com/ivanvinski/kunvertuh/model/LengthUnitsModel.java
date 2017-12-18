package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import com.ivanvinski.kunvertuh.unit.converter.LengthUnitConverter;

public class LengthUnitsModel implements UnitsModel<LengthUnit> {

  private LengthUnitConverter unitConverter = new LengthUnitConverter();
  private Double millimeters, centimeters, decimeters, meters, kilometers;
  private Double inches, feet, yards, miles;

  @Override
  public void convert(Double sourceLength, LengthUnit sourceUnit) {
    millimeters = getUnitConverter().toMillimeters(sourceLength, sourceUnit);
    centimeters = getUnitConverter().toCentimeters(sourceLength, sourceUnit);
    decimeters = getUnitConverter().toDecimeters(sourceLength, sourceUnit);
    meters = getUnitConverter().toMeters(sourceLength, sourceUnit);
    kilometers = getUnitConverter().toKilometers(sourceLength, sourceUnit);
    inches = getUnitConverter().toInches(sourceLength, sourceUnit);
    feet = getUnitConverter().toFeet(sourceLength, sourceUnit);
    yards = getUnitConverter().toYards(sourceLength, sourceUnit);
    miles = getUnitConverter().toMiles(sourceLength, sourceUnit);
  }

  @Override
  public LengthUnitConverter getUnitConverter() {
    return unitConverter;
  }

  public Double getMillimeters() {
    return millimeters;
  }

  public Double getCentimeters() {
    return centimeters;
  }

  public Double getDecimeters() {
    return decimeters;
  }

  public Double getMeters() {
    return meters;
  }

  public Double getKilometers() {
    return kilometers;
  }

  public Double getInches() {
    return inches;
  }

  public Double getFeet() {
    return feet;
  }

  public Double getYards() {
    return yards;
  }

  public Double getMiles() {
    return miles;
  }
}
