package com.ivanvinski.kunvertuh.model;

import static javax.measure.unit.NonSI.CUBIC_INCH;
import static javax.measure.unit.NonSI.GALLON_UK;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.SI.CUBIC_METRE;

import java.math.BigDecimal;
import javax.measure.quantity.Volume;
import javax.measure.unit.Unit;

public class VolumeUnitsModelImpl extends AbstractUnitsModel<Volume> implements
    VolumeUnitsModel<Unit<Volume>> {

  private BigDecimal liters, cubicMeters;
  private BigDecimal gallons, cubicInches;

  @Override
  public void convert(BigDecimal sourceVolume, Unit<Volume> sourceUnit) {
    liters = convertSafely(sourceVolume, sourceUnit, LITER);
    cubicMeters = convertSafely(sourceVolume, sourceUnit, CUBIC_METRE);
    gallons = convertSafely(sourceVolume, sourceUnit, GALLON_UK);
    cubicInches = convertSafely(sourceVolume, sourceUnit, CUBIC_INCH);
  }

  @Override
  public BigDecimal getLiters() {
    return liters;
  }

  @Override
  public BigDecimal getCubicMeters() {
    return cubicMeters;
  }

  @Override
  public BigDecimal getGallons() {
    return gallons;
  }

  @Override
  public BigDecimal getCubicInches() {
    return cubicInches;
  }
}
