package com.ivanvinski.kunvertuh.unit.converter;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;

public final class VolumeUnitConverter extends MeasurementUnitConverter<VolumeUnit> {

  public Double toMilliliters(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.MILLILITERS);
  }

  public Double toLiters(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.LITERS);
  }

  public Double toCubicMeters(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.CUBIC_METERS);
  }

  public Double toFluidOunces(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.FLUID_OUNCES);
  }

  public Double toPints(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.PINTS);
  }

  public Double toGallons(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.GALLONS);
  }
}
