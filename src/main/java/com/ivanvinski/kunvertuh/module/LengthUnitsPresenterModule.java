package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.util.BigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.LengthUnitsViewImpl;

public final class LengthUnitsPresenterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(LengthUnitsView.class).to(LengthUnitsViewImpl.class);
    bind(LengthUnitsModel.class).toInstance(new LengthUnitsModel());
    bind(StringConverter.class).to(BigDecimalStringConverter.class);
  }
}
