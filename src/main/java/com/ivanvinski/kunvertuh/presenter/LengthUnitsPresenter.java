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
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import java.math.BigDecimal;
import java.util.Objects;
import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

public class LengthUnitsPresenter implements UnitsPresenter<Unit<Length>> {

  private LengthUnitsView view;
  private LengthUnitsModel<Unit<Length>> model;
  private StringConverter<BigDecimal> valueConverter;

  public LengthUnitsPresenter(LengthUnitsView view, LengthUnitsModel model,
      StringConverter valueConverter) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
    view.setOnMillimetersActionEvent(millimeters -> convert(millimeters, MILLIMETER));
    view.setOnCentimetersActionEvent(centimeters -> convert(centimeters, CENTIMETER));
    view.setOnMetersActionEvent(meters -> convert(meters, METER));
    view.setOnKilometersActionEvent(kilometers -> convert(kilometers, KILOMETER));
    view.setOnInchesActionEvent(inches -> convert(inches, INCH));
    view.setOnFeetChanged(feet -> convert(feet, FOOT));
    view.setOnYardsChanged(yards -> convert(yards, YARD));
    view.setOnMilesChanged(miles -> convert(miles, MILE));
  }

  @Override
  public void convert(String sourceLength, Unit<Length> sourceUnit) {
    BigDecimal conversionValue = valueConverter.parse(sourceLength);
    model.convert(conversionValue, sourceUnit);
    view.setMillimeters(valueConverter.format(model.getMillimeters()));
    view.setCentimeters(valueConverter.format(model.getCentimeters()));
    view.setMeters(valueConverter.format(model.getMeters()));
    view.setKilometers(valueConverter.format(model.getKilometers()));
    view.setInches(valueConverter.format(model.getInches()));
    view.setFeet(valueConverter.format(model.getFeet()));
    view.setYards(valueConverter.format(model.getYards()));
    view.setMiles(valueConverter.format(model.getMiles()));
  }

  @Override
  public LengthUnitsView getView() {
    return view;
  }

  @Override
  public LengthUnitsModel<Unit<Length>> getModel() {
    return model;
  }
}
