package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.unit.MassUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import java.util.Objects;

public final class MassUnitsPresenter extends AbstractPresenter<MassUnitsView, MassUnitsModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public MassUnitsPresenter(MassUnitsView view, MassUnitsModel model,
      DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
    getView().setOnMilligramsActionEvent(milligrams -> convert(milligrams, MassUnit.MILLIGRAMS));
    getView().setOnGramsActionEvent(grams -> convert(grams, MassUnit.GRAMS));
    getView().setOnDekagramsActionEvent(dekagrams -> convert(dekagrams, MassUnit.DEKAGRAMS));
    getView().setOnKilogramsActionEvent(kilograms -> convert(kilograms, MassUnit.KILOGRAMS));
    getView().setOnGrainsActionEvent(grains -> convert(grains, MassUnit.GRAINS));
    getView().setOnDramsActionEvent(drams -> convert(drams, MassUnit.DRAMS));
    getView().setOnOuncesActionEvent(ounces -> convert(ounces, MassUnit.OUNCES));
    getView().setOnPoundsActionEvent(pounds -> convert(pounds, MassUnit.POUNDS));
  }

  public void convert(String sourceMass, MassUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    getModel().convert(conversionValue, sourceUnit);
    getView().setMilligrams(valueConverter.format(getModel().getMilligrams()));
    getView().setGrams(valueConverter.format(getModel().getGrams()));
    getView().setDekagrams(valueConverter.format(getModel().getDekagrams()));
    getView().setKilograms(valueConverter.format(getModel().getKilograms()));
    getView().setGrains(valueConverter.format(getModel().getGrains()));
    getView().setDrams(valueConverter.format(getModel().getDrams()));
    getView().setOunces(valueConverter.format(getModel().getOunces()));
    getView().setPounds(valueConverter.format(getModel().getPounds()));
  }
}
