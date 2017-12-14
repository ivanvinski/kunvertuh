package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.MassUnit;

public interface MassUnitsModel extends UnitsModel<MassUnit> {

  @Override
  void convert(Double sourceMass, MassUnit sourceUnit);

  Double getMilligrams();

  Double getGrams();

  Double getDekagrams();

  Double getKilograms();

  Double getGrains();

  Double getDrams();

  Double getOunces();

  Double getPounds();
}
