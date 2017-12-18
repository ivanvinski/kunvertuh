package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.MeasurementUnit;
import com.ivanvinski.kunvertuh.unit.converter.MeasurementUnitConverter;

public interface UnitsModel<U extends MeasurementUnit> {

  void convert(Double sourceValue, U sourceUnit);

  MeasurementUnitConverter<U> getUnitConverter();
}
