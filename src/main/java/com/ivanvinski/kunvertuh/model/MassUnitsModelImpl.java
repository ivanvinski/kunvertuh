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

public class MassUnitsModelImpl extends AbstractUnitsModel<Mass> implements
    MassUnitsModel<Unit<Mass>> {

  private BigDecimal grams, kilograms, metricTons;
  private BigDecimal ounces, pounds, imperialTons;

  @Override
  public void convert(BigDecimal sourceMass, Unit<Mass> sourceUnit) {
    grams = convertSafely(sourceMass, sourceUnit, GRAM);
    kilograms = convertSafely(sourceMass, sourceUnit, KILOGRAM);
    metricTons = convertSafely(sourceMass, sourceUnit, METRIC_TON);
    ounces = convertSafely(sourceMass, sourceUnit, OUNCE);
    pounds = convertSafely(sourceMass, sourceUnit, POUND);
    imperialTons = convertSafely(sourceMass, sourceUnit, TON_UK);
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
}
