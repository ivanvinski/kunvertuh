/*
 * Kunvertuh
 * Copyright (C) 2017  Ivan Vinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.LengthModel;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.model.MassModel;
import com.ivanvinski.kunvertuh.model.VolumeModel;
import com.ivanvinski.kunvertuh.presenter.AboutPresenter;
import com.ivanvinski.kunvertuh.presenter.LengthPresenter;
import com.ivanvinski.kunvertuh.presenter.MainPresenter;
import com.ivanvinski.kunvertuh.presenter.MassPresenter;
import com.ivanvinski.kunvertuh.presenter.VolumePresenter;
import com.ivanvinski.kunvertuh.util.Browser;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.util.JFXBrowser;
import com.ivanvinski.kunvertuh.view.AboutView;
import com.ivanvinski.kunvertuh.view.LengthView;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.MassView;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.VolumeView;
import com.ivanvinski.kunvertuh.view.javafx.JFXAboutView;
import com.ivanvinski.kunvertuh.view.javafx.JFXLengthView;
import com.ivanvinski.kunvertuh.view.javafx.JFXMainView;
import com.ivanvinski.kunvertuh.view.javafx.JFXMassView;
import com.ivanvinski.kunvertuh.view.javafx.JFXVolumeView;
import javafx.application.HostServices;

public class ProductionModule extends AbstractModule {

  private ViewCatalog viewCatalog;
  private DoubleStringConverter valueConverter;
  private HostServices hostServices;

  public ProductionModule(ViewCatalog viewCatalog, DoubleStringConverter valueConverter,
      HostServices hostServices) {
    this.viewCatalog = viewCatalog;
    this.valueConverter = valueConverter;
    this.hostServices = hostServices;
  }

  @Override
  protected void configure() {
    bind(ViewCatalog.class).toInstance(viewCatalog);
    bind(DoubleStringConverter.class).toInstance(valueConverter);
    bind(HostServices.class).toInstance(hostServices);
    bind(MainView.class).to(JFXMainView.class);
    bind(MainModel.class);
    bind(MainPresenter.class);
    bind(LengthView.class).to(JFXLengthView.class);
    bind(LengthModel.class);
    bind(LengthPresenter.class);
    bind(MassView.class).to(JFXMassView.class);
    bind(MassModel.class);
    bind(MassPresenter.class);
    bind(VolumeView.class).to(JFXVolumeView.class);
    bind(VolumeModel.class);
    bind(VolumePresenter.class);
    bind(AboutView.class).to(JFXAboutView.class);
    bind(Browser.class).to(JFXBrowser.class);
    bind(AboutPresenter.class);
  }
}
