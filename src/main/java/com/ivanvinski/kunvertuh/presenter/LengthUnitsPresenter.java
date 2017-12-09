package com.ivanvinski.kunvertuh.presenter;

import static javax.measure.unit.NonSI.FOOT;
import static javax.measure.unit.NonSI.INCH;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.YARD;
import static javax.measure.unit.SI.CENTIMETER;
import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static javax.measure.unit.SI.MILLIMETER;

import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Objects;

public class LengthUnitsPresenter {

  private LengthUnitsView view;
  private LengthUnitsModel model;
  private DecimalFormat decimalFormat = new DecimalFormat("#0.##########");

  public LengthUnitsPresenter(LengthUnitsView view, LengthUnitsModel model) {
    Objects.requireNonNull(view, "LengthUnitsView can't be null");
    Objects.requireNonNull(model, "LengthUnitsModel can't be null");
    this.view = view;
    this.model = model;
    bindEventsToImplementation();
  }

  public void convert(String sourceLength, Object sourceUnit) {
    BigDecimal conversionValue = toBigDecimal(sourceLength);
    model.convert(conversionValue, sourceUnit);
    view.setMillimeters(formatBigDecimal(model.getMillimeters()));
    view.setCentimeters(formatBigDecimal(model.getCentimeters()));
    view.setMeters(formatBigDecimal(model.getMeters()));
    view.setKilometers(formatBigDecimal(model.getKilometers()));
    view.setInches(formatBigDecimal(model.getInches()));
    view.setFeet(formatBigDecimal(model.getFeet()));
    view.setYards(formatBigDecimal(model.getYards()));
    view.setMiles(formatBigDecimal(model.getMiles()));
  }

  public DecimalFormat getDecimalFormat() {
    return decimalFormat;
  }

  private void bindEventsToImplementation() {
    view.setOnMillimetersActionEvent(millimeters -> convert(millimeters, MILLIMETER));
    view.setOnCentimetersActionEvent(centimeters -> convert(centimeters, CENTIMETER));
    view.setOnMetersActionEvent(meters -> convert(meters, METER));
    view.setOnKilometersActionEvent(kilometers -> convert(kilometers, KILOMETER));
    view.setOnInchesActionEvent(inches -> convert(inches, INCH));
    view.setOnFeetChanged(feet -> convert(feet, FOOT));
    view.setOnYardsChanged(yards -> convert(yards, YARD));
    view.setOnMilesChanged(miles -> convert(miles, MILE));
  }

  private BigDecimal toBigDecimal(String value) {
    try {
      return new BigDecimal(getDecimalFormat().parse(value).doubleValue());
    } catch (ParseException e) {
      return null;
    }
  }

  private String formatBigDecimal(BigDecimal value) {
    try {
      return getDecimalFormat().format(value);
    } catch (IllegalArgumentException e) {
      return "";
    }
  }
}
