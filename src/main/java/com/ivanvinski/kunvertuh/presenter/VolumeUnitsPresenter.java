package com.ivanvinski.kunvertuh.presenter;

import static javax.measure.unit.NonSI.CUBIC_INCH;
import static javax.measure.unit.NonSI.GALLON_UK;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.SI.CUBIC_METRE;

import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Objects;

public class VolumeUnitsPresenter {

  private VolumeUnitsView view;
  private VolumeUnitsModel model;
  private DecimalFormat decimalFormat = new DecimalFormat("#0.##########");

  public VolumeUnitsPresenter(VolumeUnitsView view, VolumeUnitsModel model) {
    Objects.requireNonNull(view, "MassUnitsView can't be null");
    Objects.requireNonNull(model, "MassUnitsModel can't be null");
    this.view = view;
    this.model = model;
    bindEventsToImplementation();
  }

  public void convert(String sourceMass, Object sourceUnit) {
    BigDecimal conversionValue = toBigDecimal(sourceMass);
    model.convert(conversionValue, sourceUnit);
    view.setLiters(formatBigDecimal(model.getLiters()));
    view.setCubicMeters(formatBigDecimal(model.getCubicMeters()));
    view.setGallons(formatBigDecimal(model.getGallons()));
    view.setCubicInches(formatBigDecimal(model.getCubicInches()));
  }

  public DecimalFormat getDecimalFormat() {
    return decimalFormat;
  }

  private void bindEventsToImplementation() {
    view.setOnLitersActionEvent(liters -> convert(liters, LITER));
    view.setOnCubicMetersActionEvent(cubicMeters -> convert(cubicMeters, CUBIC_METRE));
    view.setOnGallonsActionEvent(gallons -> convert(gallons, GALLON_UK));
    view.setOnCubicInchesActionEvent(cubicInches -> convert(cubicInches, CUBIC_INCH));
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
