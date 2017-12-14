package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import java.util.Objects;

public class VolumeUnitsModel implements UnitsModel<VolumeUnit> {

  private Double milliliters, liters, cubicMeters;
  private Double fluidOunces, pints, gallons;

  @Override
  public void convert(Double sourceVolume, VolumeUnit sourceUnit) {
    Objects.requireNonNull(sourceUnit, "Source unit can't be null");
    milliliters = sourceUnit.toMilliliters(sourceVolume);
    liters = sourceUnit.toLiters(sourceVolume);
    cubicMeters = sourceUnit.toCubicMeters(sourceVolume);
    fluidOunces = sourceUnit.toFluidOunces(sourceVolume);
    pints = sourceUnit.toPints(sourceVolume);
    gallons = sourceUnit.toGallons(sourceVolume);
  }

  public Double getMilliliters() {
    return milliliters;
  }

  public Double getLiters() {
    return liters;
  }

  public Double getCubicMeters() {
    return cubicMeters;
  }

  public Double getFluidOunces() {
    return fluidOunces;
  }

  public Double getPints() {
    return pints;
  }

  public Double getGallons() {
    return gallons;
  }
}
