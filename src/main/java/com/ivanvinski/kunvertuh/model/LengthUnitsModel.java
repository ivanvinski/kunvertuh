package com.ivanvinski.kunvertuh.model;

import java.math.BigDecimal;

public interface LengthUnitsModel<U> {

  void convert(BigDecimal sourceLength, U sourceUnit);

  BigDecimal getMillimeters();

  BigDecimal getCentimeters();

  BigDecimal getMeters();

  BigDecimal getKilometers();

  BigDecimal getInches();

  BigDecimal getFeet();

  BigDecimal getYards();

  BigDecimal getMiles();
}
