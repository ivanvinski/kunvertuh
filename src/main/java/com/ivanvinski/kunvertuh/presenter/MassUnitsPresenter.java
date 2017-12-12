package com.ivanvinski.kunvertuh.presenter;

import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.OUNCE;
import static javax.measure.unit.NonSI.POUND;
import static javax.measure.unit.NonSI.TON_UK;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;

import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.util.Converter;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import java.math.BigDecimal;
import java.util.Objects;
import javax.measure.quantity.Mass;
import javax.measure.unit.Unit;

public class MassUnitsPresenter implements UnitsPresenter<Unit<Mass>> {

  private MassUnitsView view;
  private MassUnitsModel<Unit<Mass>> model;
  private Converter<String, BigDecimal> valueConverter;

  public MassUnitsPresenter(MassUnitsView view, MassUnitsModel<Unit<Mass>> model,
      Converter<String, BigDecimal> valueConverter) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
    wireModelAndPresenter();
  }

  @Override
  public void convert(String sourceMass, Unit<Mass> sourceUnit) {
    BigDecimal conversionValue = valueConverter.parse(sourceMass);
    model.convert(conversionValue, sourceUnit);
    view.setGrams(valueConverter.format(model.getGrams()));
    view.setKilograms(valueConverter.format(model.getKilograms()));
    view.setMetricTons(valueConverter.format(model.getMetricTons()));
    view.setOunces(valueConverter.format(model.getOunces()));
    view.setPounds(valueConverter.format(model.getPounds()));
    view.setImperialTons(valueConverter.format(model.getImperialTons()));
  }

  private void wireModelAndPresenter() {
    view.setOnGramsActionEvent(grams -> convert(grams, GRAM));
    view.setOnKilogramsActionEvent(kilograms -> convert(kilograms, KILOGRAM));
    view.setOnMetricTonsActionEvent(tons -> convert(tons, METRIC_TON));
    view.setOnOuncesActionEvent(ounces -> convert(ounces, OUNCE));
    view.setOnPoundsActionEvent(pounds -> convert(pounds, POUND));
    view.setOnImperialTonsActionEvent(tons -> convert(tons, TON_UK));
  }
}
