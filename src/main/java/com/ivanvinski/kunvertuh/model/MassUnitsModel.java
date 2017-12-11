package com.ivanvinski.kunvertuh.model;

import java.math.BigDecimal;

public interface MassUnitsModel<U> extends UnitsModel<U> {

  @Override
  void convert(BigDecimal sourceMass, U sourceUnit);

  BigDecimal getGrams();

  BigDecimal getKilograms();

  BigDecimal getMetricTons();

  BigDecimal getOunces();

  BigDecimal getPounds();

  BigDecimal getImperialTons();
}
