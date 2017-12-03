package com.ivanvinski.kunvertuh.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public enum VolumeUnit {

  MILLILITERS("ml", 1000d),
  DECILITERS("dl", 10d),
  LITERS("l", 1d),

  FLUID_OUNCES("fl oz", 35.19503d),
  QUARTS("qt", .8798789d),
  GALLONS("gal", .2199692d);

  private String acronym;
  private BigDecimal scale;

  VolumeUnit(String acronym, double scale) {
    this.acronym = acronym;
    this.scale = new BigDecimal(scale);
  }

  public BigDecimal convert(BigDecimal sourceVolume, VolumeUnit sourceUnit) {
    Objects.requireNonNull(sourceVolume, "Can't convert null volume");
    Objects.requireNonNull(sourceUnit, "Can't convert null volume unit");
    BigDecimal liters = sourceVolume.divide(sourceUnit.getScale(), 3, RoundingMode.HALF_EVEN);
    return liters.multiply(getScale());
  }

  public String getAcronym() {
    return acronym;
  }

  public BigDecimal getScale() {
    return scale;
  }

  @Override
  public String toString() {
    return String.format("%s (%s)", super.toString().toLowerCase(), getAcronym());
  }

  public BigDecimal toMillimeters(BigDecimal volume) {
    return toVolumeUnit(VolumeUnit.MILLILITERS, volume);
  }

  public BigDecimal toDeciliters(BigDecimal volume) {
    return toVolumeUnit(VolumeUnit.DECILITERS, volume);
  }

  public BigDecimal toLiters(BigDecimal volume) {
    return toVolumeUnit(VolumeUnit.LITERS, volume);
  }

  public BigDecimal toFluidOunces(BigDecimal volume) {
    return toVolumeUnit(VolumeUnit.FLUID_OUNCES, volume);
  }

  public BigDecimal toQuarts(BigDecimal volume) {
    return toVolumeUnit(VolumeUnit.QUARTS, volume);
  }

  public BigDecimal toGallons(BigDecimal volume) {
    return toVolumeUnit(VolumeUnit.GALLONS, volume);
  }

  private BigDecimal toVolumeUnit(VolumeUnit resultUnit, BigDecimal sourceVolume) {
    return resultUnit.convert(sourceVolume, this);
  }
}
