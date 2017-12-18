package com.ivanvinski.kunvertuh.unit.converter;

import com.ivanvinski.kunvertuh.unit.MeasurementUnit;
import java.util.Objects;

public class MeasurementUnitConverter<U extends MeasurementUnit> {

  public Double convert(Double sourceValue, U sourceUnit, U outputUnit) {
    Objects.requireNonNull(sourceUnit, "Source unit can't be null");
    Objects.requireNonNull(outputUnit, "Output unit can't be null");
    if (sourceValue == null) {
      return null;
    }
    double baseUnitValue = sourceValue / sourceUnit.getBaseUnitFactor();
    return baseUnitValue * outputUnit.getBaseUnitFactor();
  }
}
