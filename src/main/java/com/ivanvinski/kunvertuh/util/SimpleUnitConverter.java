package com.ivanvinski.kunvertuh.util;

import java.math.BigDecimal;
import java.util.Objects;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

public class SimpleUnitConverter<Q extends Quantity> implements UnitConverter<Unit<Q>> {

  public BigDecimal convert(BigDecimal sourceValue, Unit<Q> sourceUnit, Unit<Q> outputUnit) {
    Objects.requireNonNull(sourceUnit, "Can't convert null source unit");
    Objects.requireNonNull(outputUnit, "Can't convert to null output unit");
    return sourceValue == null ? null : convertNonNullValue(sourceValue, sourceUnit, outputUnit);
  }

  private BigDecimal convertNonNullValue(BigDecimal sourceValue, Unit<Q> sourceUnit,
      Unit<Q> outputUnit) {
    return new BigDecimal(sourceUnit.getConverterTo(outputUnit).convert(sourceValue.doubleValue()));
  }
}
