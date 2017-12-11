package com.ivanvinski.kunvertuh.model;

import java.math.BigDecimal;

public interface VolumeUnitsModel<U> {

  void convert(BigDecimal sourceVolume, U sourceUnit);

  BigDecimal getLiters();

  BigDecimal getCubicMeters();

  BigDecimal getGallons();

  BigDecimal getCubicInches();
}
