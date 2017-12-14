package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import java.util.Objects;

public class LengthUnitsModelImpl implements LengthUnitsModel {

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

  @Override
  public Double getMillimeters() {
    return millimeters;
  }

  @Override
  public Double getCentimeters() {
    return centimeters;
  }

  @Override
  public Double getDecimeters() {
    return decimeters;
  }

  @Override
  public Double getMeters() {
    return meters;
  }

  @Override
  public Double getKilometers() {
    return kilometers;
  }

  @Override
  public Double getInches() {
    return inches;
  }

  @Override
  public Double getFeet() {
    return feet;
  }

  @Override
  public Double getYards() {
    return yards;
  }

  @Override
  public Double getMiles() {
    return miles;
  }
}
