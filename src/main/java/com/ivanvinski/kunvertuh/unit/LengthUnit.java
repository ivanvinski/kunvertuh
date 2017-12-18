package com.ivanvinski.kunvertuh.unit;

public final class LengthUnit extends MeasurementUnit {

  public static final LengthUnit MILLIMETERS = new LengthUnit("mm", .001d);
  public static final LengthUnit CENTIMETERS = new LengthUnit("cm", .01d);
  public static final LengthUnit DECIMETERS = new LengthUnit("dm", .1d);
  public static final LengthUnit METERS = new LengthUnit("m", 1d);
  public static final LengthUnit KILOMETERS = new LengthUnit("km", 1000d);

  public static final LengthUnit INCHES = new LengthUnit("in", .0254d);
  public static final LengthUnit FEET = new LengthUnit("ft", .3048d);
  public static final LengthUnit YARDS = new LengthUnit("yd", .9144d);
  public static final LengthUnit MILES = new LengthUnit("mi", 1609.344d);

  private LengthUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
