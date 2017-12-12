package com.ivanvinski.kunvertuh.presenter;

import static javax.measure.unit.NonSI.CUBIC_INCH;
import static javax.measure.unit.NonSI.GALLON_UK;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.SI.CUBIC_METRE;

import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.math.BigDecimal;
import java.util.Objects;
import javax.measure.quantity.Volume;
import javax.measure.unit.Unit;

public class VolumeUnitsPresenter implements UnitsPresenter<Unit<Volume>> {

  private VolumeUnitsView view;
  private VolumeUnitsModel<Unit<Volume>> model;
  private StringConverter<BigDecimal> valueConverter;

  public VolumeUnitsPresenter(VolumeUnitsView view, VolumeUnitsModel<Unit<Volume>> model,
      StringConverter<BigDecimal> valueConverter) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
    wireModelAndPresenter();
  }

  @Override
  public void convert(String sourceMass, Unit<Volume> sourceUnit) {
    BigDecimal conversionValue = valueConverter.parse(sourceMass);
    model.convert(conversionValue, sourceUnit);
    view.setLiters(valueConverter.format(model.getLiters()));
    view.setCubicMeters(valueConverter.format(model.getCubicMeters()));
    view.setGallons(valueConverter.format(model.getGallons()));
    view.setCubicInches(valueConverter.format(model.getCubicInches()));
  }

  private void wireModelAndPresenter() {
    view.setOnLitersActionEvent(liters -> convert(liters, LITER));
    view.setOnCubicMetersActionEvent(cubicMeters -> convert(cubicMeters, CUBIC_METRE));
    view.setOnGallonsActionEvent(gallons -> convert(gallons, GALLON_UK));
    view.setOnCubicInchesActionEvent(cubicInches -> convert(cubicInches, CUBIC_INCH));
  }
}
