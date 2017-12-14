package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.util.BigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.StringConverter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import com.ivanvinski.kunvertuh.view.VolumeUnitsViewImpl;

public class VolumeUnitsPresenterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(VolumeUnitsView.class).to(VolumeUnitsViewImpl.class);
    bind(VolumeUnitsModel.class).toInstance(new VolumeUnitsModel());
    bind(StringConverter.class).to(BigDecimalStringConverter.class);
  }
}
