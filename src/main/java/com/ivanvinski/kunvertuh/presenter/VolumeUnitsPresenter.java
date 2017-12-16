package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.util.Objects;

public class VolumeUnitsPresenter extends AbstractPresenter<VolumeUnitsView, VolumeUnitsModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public VolumeUnitsPresenter(VolumeUnitsView view, VolumeUnitsModel model,
      DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
    getView()
        .setOnMillilitersActionEvent(milliliters -> convert(milliliters, VolumeUnit.MILLILITERS));
    getView().setOnLitersActionEvent(liters -> convert(liters, VolumeUnit.LITERS));
    getView()
        .setOnCubicMetersActionEvent(cubicMeters -> convert(cubicMeters, VolumeUnit.CUBIC_METERS));
    getView()
        .setOnFluidOuncesActionEvent(fluidOunces -> convert(fluidOunces, VolumeUnit.FLUID_OUNCES));
    getView().setOnPintsActionEvent(pints -> convert(pints, VolumeUnit.PINTS));
    getView().setOnGallonsActionEvent(gallons -> convert(gallons, VolumeUnit.GALLONS));
  }

  public void convert(String sourceMass, VolumeUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    getModel().convert(conversionValue, sourceUnit);
    getView().setMilliliters(valueConverter.format(getModel().getMilliliters()));
    getView().setLiters(valueConverter.format(getModel().getLiters()));
    getView().setCubicMeters(valueConverter.format(getModel().getCubicMeters()));
    getView().setFluidOunces(valueConverter.format(getModel().getFluidOunces()));
    getView().setPints(valueConverter.format(getModel().getPints()));
    getView().setGallons(valueConverter.format(getModel().getGallons()));
  }
}
