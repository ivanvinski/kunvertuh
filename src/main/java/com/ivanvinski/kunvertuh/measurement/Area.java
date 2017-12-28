package com.ivanvinski.kunvertuh.measurement;

import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.IMPERIAL_AND_US_CUSTOMARY;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.METRIC;

public enum Area implements Unit {

  SQUARE_MILLIMETER(.000001d, "mm2", METRIC),
  SQUARE_CENTIMETER(.0001d, "cm2", METRIC),
  SQUARE_METER(1d, "m2", METRIC),
  HECTARE(10000d, "ha", METRIC),
  SQUARE_KILOMETER(1000000d, "km2", METRIC),

  SQUARE_INCH(.00064516d, "in2", IMPERIAL_AND_US_CUSTOMARY),
  SQUARE_FOOT(.092903d, "ft2", IMPERIAL_AND_US_CUSTOMARY),
  SQUARE_YARD(.836127d, "yd2", IMPERIAL_AND_US_CUSTOMARY),
  ACRE(4046.86d, "ac2", IMPERIAL_AND_US_CUSTOMARY),
  SQUARE_MILE(2590000d, "mi2", IMPERIAL_AND_US_CUSTOMARY);

  private double baseUnitFactor;
  private String symbol;
  private MeasurementSystem measurementSystem;

  Area(double baseUnitFactor, String symbol, MeasurementSystem measurementSystem) {
    this.baseUnitFactor = baseUnitFactor;
    this.symbol = symbol;
    this.measurementSystem = measurementSystem;
  }

  @Override
  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  @Override
  public MeasurementSystem getSystem() {
    return measurementSystem;
  }
}