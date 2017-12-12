package com.ivanvinski.kunvertuh.model;

import static javax.measure.unit.NonSI.FOOT;
import static javax.measure.unit.NonSI.INCH;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.YARD;
import static javax.measure.unit.SI.CENTIMETER;
import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static javax.measure.unit.SI.MILLIMETER;

import com.ivanvinski.kunvertuh.util.SimpleUnitConverter;
import com.ivanvinski.kunvertuh.util.UnitConverter;
import java.math.BigDecimal;
import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

public class LengthUnitsModelImpl implements LengthUnitsModel<Unit<Length>> {

  private UnitConverter<Unit<Length>> unitConverter = new SimpleUnitConverter<>();
  private BigDecimal millimeters, centimeters, meters, kilometers;
  private BigDecimal inches, feet, yards, miles;

  @Override
  public void convert(BigDecimal sourceLength, Unit<Length> sourceUnit) {
    millimeters = unitConverter.convert(sourceLength, sourceUnit, MILLIMETER);
    centimeters = unitConverter.convert(sourceLength, sourceUnit, CENTIMETER);
    meters = unitConverter.convert(sourceLength, sourceUnit, METER);
    kilometers = unitConverter.convert(sourceLength, sourceUnit, KILOMETER);
    inches = unitConverter.convert(sourceLength, sourceUnit, INCH);
    feet = unitConverter.convert(sourceLength, sourceUnit, FOOT);
    yards = unitConverter.convert(sourceLength, sourceUnit, YARD);
    miles = unitConverter.convert(sourceLength, sourceUnit, MILE);
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
}
