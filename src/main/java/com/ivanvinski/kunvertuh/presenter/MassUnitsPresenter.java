package com.ivanvinski.kunvertuh.presenter;

import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.OUNCE;
import static javax.measure.unit.NonSI.POUND;
import static javax.measure.unit.NonSI.TON_UK;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;

import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Objects;

public class MassUnitsPresenter {

  private MassUnitsView view;
  private MassUnitsModel model;
  private DecimalFormat decimalFormat = new DecimalFormat("#0.##########");

  public MassUnitsPresenter(MassUnitsView view, MassUnitsModel model) {
    Objects.requireNonNull(view, "MassUnitsView can't be null");
    Objects.requireNonNull(model, "MassUnitsModel can't be null");
    this.view = view;
    this.model = model;
    bindEventsToImplementation();
  }

  public void convert(String sourceMass, Object sourceUnit) {
    BigDecimal conversionValue = toBigDecimal(sourceMass);
    model.convert(conversionValue, sourceUnit);
    view.setGrams(formatBigDecimal(model.getGrams()));
    view.setKilograms(formatBigDecimal(model.getKilograms()));
    view.setMetricTons(formatBigDecimal(model.getMetricTons()));
    view.setOunces(formatBigDecimal(model.getOunces()));
    view.setPounds(formatBigDecimal(model.getPounds()));
    view.setImperialTons(formatBigDecimal(model.getImperialTons()));
  }

  public DecimalFormat getDecimalFormat() {
    return decimalFormat;
  }

  private void bindEventsToImplementation() {
    view.setOnGramsActionEvent(grams -> convert(grams, GRAM));
    view.setOnKilogramsActionEvent(kilograms -> convert(kilograms, KILOGRAM));
    view.setOnMetricTonsActionEvent(tons -> convert(tons, METRIC_TON));
    view.setOnOuncesActionEvent(ounces -> convert(ounces, OUNCE));
    view.setOnPoundsActionEvent(pounds -> convert(pounds, POUND));
    view.setOnImperialTonsActionEvent(tons -> convert(tons, TON_UK));
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
