package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.util.Converter;
import java.math.BigDecimal;

public interface VolumeUnitsModel<U> extends UnitsModel<U> {

  @Override
  void convert(BigDecimal sourceVolume, U sourceUnit);

  BigDecimal getLiters();

  BigDecimal getCubicMeters();

  BigDecimal getGallons();

  BigDecimal getCubicInches();
}
