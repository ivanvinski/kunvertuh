package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.LengthUnit;

public interface LengthUnitsModel extends UnitsModel<LengthUnit> {

  @Override
  void convert(Double sourceLength, LengthUnit sourceUnit);

  Double getMillimeters();

  Double getCentimeters();

  Double getDecimeters();

  Double getMeters();

  Double getKilometers();

  Double getInches();

  Double getFeet();

  Double getYards();

  Double getMiles();
}
