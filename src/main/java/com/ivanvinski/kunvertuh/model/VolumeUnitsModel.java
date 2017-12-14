package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;

public interface VolumeUnitsModel extends UnitsModel<VolumeUnit> {

  @Override
  void convert(Double sourceVolume, VolumeUnit sourceUnit);

  Double getMilliliters();

  Double getLiters();

  Double getCubicMeters();

  Double getFluidOunces();

  Double getPints();

  Double getGallons();
}
