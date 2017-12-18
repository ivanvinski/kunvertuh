package com.ivanvinski.kunvertuh.unit;

public final class MassUnit extends MeasurementUnit {

  public static final MassUnit MILLIGRAMS = new MassUnit("mg", .001d);
  public static final MassUnit GRAMS = new MassUnit("g", 1d);
  public static final MassUnit DEKAGRAMS = new MassUnit("dag", 10d);
  public static final MassUnit KILOGRAMS = new MassUnit("kg", 1000d);

  public static final MassUnit GRAINS = new MassUnit("gr", .06479891d);
  public static final MassUnit DRAMS = new MassUnit("dr", 1.771845d);
  public static final MassUnit OUNCES = new MassUnit("oz", 28.34952d);
  public static final MassUnit POUNDS = new MassUnit("lb", 453.5924d);

  private MassUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
