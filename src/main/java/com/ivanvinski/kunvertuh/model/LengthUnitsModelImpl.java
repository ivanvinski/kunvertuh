package com.ivanvinski.kunvertuh.model;

import static javax.measure.unit.NonSI.FOOT;
import static javax.measure.unit.NonSI.INCH;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.YARD;
import static javax.measure.unit.SI.CENTIMETER;
import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static javax.measure.unit.SI.MILLIMETER;

import java.math.BigDecimal;
import java.util.Objects;
import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

public class LengthUnitsModelImpl implements LengthUnitsModel<Unit<Length>> {

  private BigDecimal millimeters, centimeters, meters, kilometers;
  private BigDecimal inches, feet, yards, miles;

  @Override
  public void convert(BigDecimal sourceLength, Unit<Length> sourceUnit) {
    Objects.requireNonNull(sourceUnit, "Can't convert null source unit");
    millimeters = convert(sourceLength, sourceUnit, MILLIMETER);
    centimeters = convert(sourceLength, sourceUnit, CENTIMETER);
    meters = convert(sourceLength, sourceUnit, METER);
    kilometers = convert(sourceLength, sourceUnit, KILOMETER);
    inches = convert(sourceLength, sourceUnit, INCH);
    feet = convert(sourceLength, sourceUnit, FOOT);
    yards = convert(sourceLength, sourceUnit, YARD);
    miles = convert(sourceLength, sourceUnit, MILE);
  }

  @Override
  public BigDecimal getMillimeters() {
    return millimeters;
  }

  @Override
  public BigDecimal getCentimeters() {
    return centimeters;
  }

  @Override
  public BigDecimal getMeters() {
    return meters;
  }

  @Override
  public BigDecimal getKilometers() {
    return kilometers;
  }

  @Override
  public BigDecimal getInches() {
    return inches;
  }

  @Override
  public BigDecimal getFeet() {
    return feet;
  }

  @Override
  public BigDecimal getYards() {
    return yards;
  }

  @Override
  public BigDecimal getMiles() {
    return miles;
  }

  private BigDecimal convert(BigDecimal sourceLength, Unit<Length> sourceUnit,
      Unit<Length> toUnit) {
    return sourceLength == null ? null : new BigDecimal(sourceUnit
        .getConverterTo(toUnit)
        .convert(sourceLength.doubleValue()));
  }
}
