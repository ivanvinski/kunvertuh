package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import java.util.Objects;

public class LengthUnitsModel implements UnitsModel<LengthUnit> {

  private Double millimeters, centimeters, decimeters, meters, kilometers;
  private Double inches, feet, yards, miles;

  @Override
  public void convert(Double sourceLength, LengthUnit sourceUnit) {
    Objects.requireNonNull(sourceUnit, "Source unit can't be null");
    millimeters = sourceUnit.toMillimeters(sourceLength);
    centimeters = sourceUnit.toCentimeters(sourceLength);
    decimeters = sourceUnit.toDecimeters(sourceLength);
    meters = sourceUnit.toMeters(sourceLength);
    kilometers = sourceUnit.toKilometers(sourceLength);
    inches = sourceUnit.toInches(sourceLength);
    feet = sourceUnit.toFeet(sourceLength);
    yards = sourceUnit.toYards(sourceLength);
    miles = sourceUnit.toMiles(sourceLength);
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
