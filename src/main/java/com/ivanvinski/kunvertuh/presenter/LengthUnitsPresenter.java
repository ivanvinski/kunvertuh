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
import java.util.Objects;

public class LengthUnitsPresenter {

  private LengthUnitsView view;
  private LengthUnitsModel model;

  public LengthUnitsPresenter(LengthUnitsView view, LengthUnitsModel model) {
    Objects.requireNonNull(view, "LengthUnitsView can't be null");
    Objects.requireNonNull(model, "LengthUnitsModel can't be null");
    this.view = view;
    this.model = model;
    bindEventsToImplementation();
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

  private void convert(String sourceLength, Object sourceUnit) {
    BigDecimal conversionValue = sourceLength == null ? null : new BigDecimal(sourceLength);
    model.convert(conversionValue, sourceUnit);
  }
}
