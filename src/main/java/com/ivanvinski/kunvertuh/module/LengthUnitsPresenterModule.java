package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.javafx.LengthUnitsViewImpl;

public final class LengthUnitsPresenterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(LengthUnitsView.class).to(LengthUnitsViewImpl.class);
    bind(LengthUnitsModel.class).toInstance(new LengthUnitsModel());
    bind(DoubleStringConverter.class).toInstance(new DoubleStringConverter());
  }
}
