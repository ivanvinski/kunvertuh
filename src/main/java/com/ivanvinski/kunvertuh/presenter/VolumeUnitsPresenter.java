package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.math.BigDecimal;
import java.util.Objects;
import javax.measure.quantity.Volume;
import javax.measure.unit.Unit;

public class VolumeUnitsPresenter implements Presenter<VolumeUnitsView, VolumeUnitsModel> {

  private VolumeUnitsView view;
  private VolumeUnitsModel model;
  private StringConverter<BigDecimal> valueConverter;

  @Inject
  public VolumeUnitsPresenter(VolumeUnitsView view, VolumeUnitsModel model,
      StringConverter valueConverter) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
    view.setOnMillilitersActionEvent(milliliters -> convert(milliliters, VolumeUnit.MILLILITERS));
    view.setOnLitersActionEvent(liters -> convert(liters, VolumeUnit.LITERS));
    view.setOnCubicMetersActionEvent(cubicMeters -> convert(cubicMeters, VolumeUnit.CUBIC_METERS));
    view.setOnFluidOuncesActionEvent(fluidOunces -> convert(fluidOunces, VolumeUnit.FLUID_OUNCES));
    view.setOnPintsActionEvent(pints -> convert(pints, VolumeUnit.PINTS));
    view.setOnGallonsActionEvent(gallons -> convert(gallons, VolumeUnit.GALLONS));
  }

  public void convert(String sourceMass, VolumeUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    model.convert(conversionValue, sourceUnit);
    view.setMilliliters(valueConverter.format(model.getMilliliters()));
    view.setLiters(valueConverter.format(model.getLiters()));
    view.setCubicMeters(valueConverter.format(model.getCubicMeters()));
    view.setFluidOunces(valueConverter.format(model.getFluidOunces()));
    view.setPints(valueConverter.format(model.getPints()));
    view.setGallons(valueConverter.format(model.getGallons()));
  }

  @Override
  public VolumeUnitsView getView() {
    return view;
  }

  @Override
  public VolumeUnitsModel<Unit<Volume>> getModel() {
    return model;
  }
}
