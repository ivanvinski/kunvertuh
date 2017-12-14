package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.util.BigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import com.ivanvinski.kunvertuh.view.MassUnitsViewImpl;

public class MassUnitsPresenterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(MassUnitsView.class).to(MassUnitsViewImpl.class);
    bind(MassUnitsModel.class).toInstance(new MassUnitsModel());
    bind(StringConverter.class).to(BigDecimalStringConverter.class);
  }
}
