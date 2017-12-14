package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.unit.LengthUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import java.util.Objects;

public class LengthUnitsPresenter implements Presenter<LengthUnitsView, LengthUnitsModel> {

  private LengthUnitsView view;
  private LengthUnitsModel model;
  private DoubleStringConverter valueConverter;

  @Inject
  public LengthUnitsPresenter(LengthUnitsView view, LengthUnitsModel model,
      DoubleStringConverter valueConverter) {
    this.view = Objects.requireNonNull(view, "LengthUnitsView can't be null");
    this.model = Objects.requireNonNull(model, "LengthUnitsModel can't be null");
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
    view.setOnMillimetersActionEvent(millimeters -> convert(millimeters, LengthUnit.MILLIMETERS));
    view.setOnCentimetersActionEvent(centimeters -> convert(centimeters, LengthUnit.CENTIMETERS));
    view.setOnDecimetersActionEvent(decimeters -> convert(decimeters, LengthUnit.DECIMETERS));
    view.setOnMetersActionEvent(meters -> convert(meters, LengthUnit.METERS));
    view.setOnKilometersActionEvent(kilometers -> convert(kilometers, LengthUnit.KILOMETERS));
    view.setOnInchesActionEvent(inches -> convert(inches, LengthUnit.INCHES));
    view.setOnFeetChanged(feet -> convert(feet, LengthUnit.FEET));
    view.setOnYardsChanged(yards -> convert(yards, LengthUnit.YARDS));
    view.setOnMilesChanged(miles -> convert(miles, LengthUnit.MILES));
  }

  public void convert(String sourceLength, LengthUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceLength);
    model.convert(conversionValue, sourceUnit);
    view.setMillimeters(valueConverter.format(model.getMillimeters()));
    view.setCentimeters(valueConverter.format(model.getCentimeters()));
    view.setDecimeters(valueConverter.format(model.getDecimeters()));
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
  public LengthUnitsModel getModel() {
    return model;
  }
}
