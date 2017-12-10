package com.ivanvinski.kunvertuh.model;

import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.OUNCE;
import static javax.measure.unit.NonSI.POUND;
import static javax.measure.unit.NonSI.TON_UK;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;

import java.math.BigDecimal;
import javax.measure.quantity.Mass;
import javax.measure.unit.Unit;

public class MassUnitsModelImpl implements MassUnitsModel<Unit<Mass>> {

  private BigDecimal grams, kilograms, metricTons;
  private BigDecimal ounces, pounds, imperialTons;

  @Override
  public void convert(BigDecimal sourceMass, Unit<Mass> sourceUnit) {
    grams = convert(sourceMass, sourceUnit, GRAM);
    kilograms = convert(sourceMass, sourceUnit, KILOGRAM);
    metricTons = convert(sourceMass, sourceUnit, METRIC_TON);
    ounces = convert(sourceMass, sourceUnit, OUNCE);
    pounds = convert(sourceMass, sourceUnit, POUND);
    imperialTons = convert(sourceMass, sourceUnit, TON_UK);
  }

  @Override
  public BigDecimal getGrams() {
    return grams;
  }

  @Override
  public BigDecimal getKilograms() {
    return kilograms;
  }

  @Override
  public BigDecimal getMetricTons() {
    return metricTons;
  }

  @Override
  public BigDecimal getOunces() {
    return ounces;
  }

  @Override
  public BigDecimal getPounds() {
    return pounds;
  }

  @Override
  public BigDecimal getImperialTons() {
    return imperialTons;
  }

  private BigDecimal convert(BigDecimal sourceLength, Unit<Mass> sourceUnit,
      Unit<Mass> toUnit) {
    return sourceLength == null ? null : new BigDecimal(sourceUnit
        .getConverterTo(toUnit)
        .convert(sourceLength.doubleValue()));
  }
}
