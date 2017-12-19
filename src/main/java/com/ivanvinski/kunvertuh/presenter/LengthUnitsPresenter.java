package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.unit.LengthUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import java.util.Objects;

public final class LengthUnitsPresenter extends
    AbstractPresenter<LengthUnitsView, LengthUnitsModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public LengthUnitsPresenter(LengthUnitsView view, LengthUnitsModel model,
      DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
  }

  public void conversionRequested(String sourceLength, LengthUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceLength);
    getModel().convert(conversionValue, sourceUnit);
    getView().setMillimeters(valueConverter.format(getModel().getMillimeters()));
    getView().setCentimeters(valueConverter.format(getModel().getCentimeters()));
    getView().setDecimeters(valueConverter.format(getModel().getDecimeters()));
    getView().setMeters(valueConverter.format(getModel().getMeters()));
    getView().setKilometers(valueConverter.format(getModel().getKilometers()));
    getView().setInches(valueConverter.format(getModel().getInches()));
    getView().setFeet(valueConverter.format(getModel().getFeet()));
    getView().setYards(valueConverter.format(getModel().getYards()));
    getView().setMiles(valueConverter.format(getModel().getMiles()));
  }
}
