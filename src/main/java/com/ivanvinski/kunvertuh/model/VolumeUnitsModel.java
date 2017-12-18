package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.unit.converter.VolumeUnitConverter;

public class VolumeUnitsModel implements UnitsModel<VolumeUnit> {

  private VolumeUnitConverter unitConverter = new VolumeUnitConverter();
  private Double milliliters, liters, cubicMeters;
  private Double fluidOunces, pints, gallons;

  @Override
  public void convert(Double sourceVolume, VolumeUnit sourceUnit) {
    milliliters = getUnitConverter().toMilliliters(sourceVolume, sourceUnit);
    liters = getUnitConverter().toLiters(sourceVolume, sourceUnit);
    cubicMeters = getUnitConverter().toCubicMeters(sourceVolume, sourceUnit);
    fluidOunces = getUnitConverter().toFluidOunces(sourceVolume, sourceUnit);
    pints = getUnitConverter().toPints(sourceVolume, sourceUnit);
    gallons = getUnitConverter().toGallons(sourceVolume, sourceUnit);
  }

  @Override
  public VolumeUnitConverter getUnitConverter() {
    return unitConverter;
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
