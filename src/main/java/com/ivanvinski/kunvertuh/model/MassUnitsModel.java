package com.ivanvinski.kunvertuh.model;

import java.math.BigDecimal;

public interface MassUnitsModel<U> {

  void convert(BigDecimal sourceMass, U sourceUnit);

  BigDecimal getGrams();

  BigDecimal getKilograms();

  BigDecimal getMetricTons();

  BigDecimal getOunces();

  BigDecimal getPounds();

  BigDecimal getImperialTons();
}
