package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.measurement.Area;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.ConverterView;

public final class AreaPresenter extends AbstractConverterPresenter<Area> {

  @Inject
  public AreaPresenter(ConverterView<Area> view, UnitConverter<Area> model,
      DoubleStringConverter valueConverter) {
    super(view, model, valueConverter);
  }

  @Override
  public Class<Area> getUnitConversionType() {
    return Area.class;
  }
}
