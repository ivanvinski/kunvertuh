package com.ivanvinski.kunvertuh.unit;

public final class VolumeUnit extends MeasurementUnit {

  public static final VolumeUnit MILLILITERS = new VolumeUnit("ml", .001d);
  public static final VolumeUnit LITERS = new VolumeUnit("l", 1d);
  public static final VolumeUnit CUBIC_METERS = new VolumeUnit("m3", 1000d);

  public static final VolumeUnit FLUID_OUNCES = new VolumeUnit("fl oz", .0284131d);
  public static final VolumeUnit PINTS = new VolumeUnit("pt", .5682612d);
  public static final VolumeUnit GALLONS = new VolumeUnit("gal", 4.54609d);

  private VolumeUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
