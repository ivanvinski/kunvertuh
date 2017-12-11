package com.ivanvinski.kunvertuh.model;

import java.math.BigDecimal;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public abstract class AbstractUnitsModel<Q extends Quantity> implements UnitsModel<Unit<Q>> {

  protected BigDecimal convertSafely(BigDecimal sourceValue, Unit<Q> sourceUnit,
      Unit<Q> outputUnit) {
    return sourceValue == null ? null : convertNonNullValue(sourceValue, sourceUnit, outputUnit);
  }

  private BigDecimal convertNonNullValue(BigDecimal sourceValue, Unit<Q> sourceUnit,
      Unit<Q> outputUnit) {
    return new BigDecimal(sourceUnit.getConverterTo(outputUnit).convert(sourceValue.doubleValue()));
  }
}
