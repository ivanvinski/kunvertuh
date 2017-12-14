package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import java.util.Objects;

public class VolumeUnitsModelImpl implements VolumeUnitsModel {

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

  @Override
  public Double getMilliliters() {
    return milliliters;
  }

  @Override
  public Double getLiters() {
    return liters;
  }

  @Override
  public Double getCubicMeters() {
    return cubicMeters;
  }

  @Override
  public Double getFluidOunces() {
    return fluidOunces;
  }

  @Override
  public Double getPints() {
    return pints;
  }

  @Override
  public Double getGallons() {
    return gallons;
  }
}
