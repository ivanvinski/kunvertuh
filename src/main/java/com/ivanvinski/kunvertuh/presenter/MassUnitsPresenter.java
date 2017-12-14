package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.unit.MassUnit;
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import java.math.BigDecimal;
import java.util.Objects;

public class MassUnitsPresenter implements Presenter<MassUnitsView, MassUnitsModel> {

  private MassUnitsView view;
  private MassUnitsModel model;
  private StringConverter<BigDecimal> valueConverter;

  @Inject
  public MassUnitsPresenter(MassUnitsView view, MassUnitsModel model,
      StringConverter valueConverter) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
    view.setOnMilligramsActionEvent(milligrams -> convert(milligrams, MassUnit.MILLIGRAMS));
    view.setOnGramsActionEvent(grams -> convert(grams, MassUnit.GRAMS));
    view.setOnDekagramsActionEvent(dekagrams -> convert(dekagrams, MassUnit.DEKAGRAMS));
    view.setOnKilogramsActionEvent(kilograms -> convert(kilograms, MassUnit.KILOGRAMS));
    view.setOnGrainsActionEvent(grains -> convert(grains, MassUnit.GRAINS));
    view.setOnDramsActionEvent(drams -> convert(drams, MassUnit.DRAMS));
    view.setOnOuncesActionEvent(ounces -> convert(ounces, MassUnit.OUNCES));
    view.setOnPoundsActionEvent(pounds -> convert(pounds, MassUnit.POUNDS));
  }

  @Override
  public void convert(String sourceMass, MassUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    model.convert(conversionValue, sourceUnit);
    view.setMilligrams(valueConverter.format(model.getMilligrams()));
    view.setGrams(valueConverter.format(model.getGrams()));
    view.setDekagrams(valueConverter.format(model.getDekagrams()));
    view.setKilograms(valueConverter.format(model.getKilograms()));
    view.setGrains(valueConverter.format(model.getGrains()));
    view.setDrams(valueConverter.format(model.getDrams()));
    view.setOunces(valueConverter.format(model.getOunces()));
    view.setPounds(valueConverter.format(model.getPounds()));
  }

  @Override
  public MassUnitsView getView() {
    return view;
  }

  @Override
  public MassUnitsModel getModel() {
    return model;
  }
}
