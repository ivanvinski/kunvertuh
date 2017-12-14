package com.ivanvinski.kunvertuh.unit;

import java.util.Objects;
import javax.measure.converter.UnitConverter;
import javax.measure.quantity.Volume;
import javax.measure.unit.BaseUnit;
import javax.measure.unit.Unit;

public enum VolumeUnit {

  LITERS(new BaseUnit<>("l")),
  MILLILITERS(LITERS.volumeUnit.times(1000d)),
  CUBIC_METERS(LITERS.volumeUnit.divide(1000d)),

  FLUID_OUNCES(LITERS.volumeUnit.times(35.195d)),
  PINTS(LITERS.volumeUnit.times(1.7598d)),
  GALLONS(LITERS.volumeUnit.times(0.21997d));

  private Unit<Volume> volumeUnit;

  VolumeUnit(Unit<Volume> volumeUnit) {
    this.volumeUnit = volumeUnit;
  }

  public Double convert(Double sourceVolume, VolumeUnit sourceUnit) {
    if (sourceVolume == null) {
      return null;
    }
    Unit<Volume> actualSourceUnit = Objects.requireNonNull(sourceUnit).volumeUnit;
    UnitConverter converter = volumeUnit.getConverterTo(actualSourceUnit);
    return converter.convert(sourceVolume);
  }

  public Double toMilliliters(Double sourceVolume) {
    return MILLILITERS.convert(sourceVolume, this);
  }

  public Double toLiters(Double sourceVolume) {
    return LITERS.convert(sourceVolume, this);
  }

  public Double toCubicMeters(Double sourceVolume) {
    return CUBIC_METERS.convert(sourceVolume, this);
  }

  public Double toFluidOunces(Double sourceVolume) {
    return FLUID_OUNCES.convert(sourceVolume, this);
  }

  public Double toPints(Double sourceVolume) {
    return PINTS.convert(sourceVolume, this);
  }

  public Double toGallons(Double sourceVolume) {
    return GALLONS.convert(sourceVolume, this);
  }
}
