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
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.GuavaEventStream;
import com.ivanvinski.kunvertuh.measurement.Length;
import com.ivanvinski.kunvertuh.measurement.Mass;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.measurement.Volume;
import com.ivanvinski.kunvertuh.util.Browser;
import com.ivanvinski.kunvertuh.util.JFXBrowser;
import com.ivanvinski.kunvertuh.view.AboutView;
import com.ivanvinski.kunvertuh.view.ConverterView;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.SettingsView;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.javafx.JFXAboutView;
import com.ivanvinski.kunvertuh.view.javafx.JFXLengthConverterView;
import com.ivanvinski.kunvertuh.view.javafx.JFXMainView;
import com.ivanvinski.kunvertuh.view.javafx.JFXMassConverterView;
import com.ivanvinski.kunvertuh.view.javafx.JFXSettingsView;
import com.ivanvinski.kunvertuh.view.javafx.JFXVolumeConverterView;
import java.util.Objects;
import javafx.application.HostServices;

public final class MainModule extends AbstractModule {

  private HostServices hostServices;

  public MainModule(HostServices hostServices) {
    this.hostServices = Objects.requireNonNull(hostServices, "Host services can't be null");
  }

  @Override
  protected void configure() {
    configureModels();
    configureViews();
    bind(EventStream.class).to(GuavaEventStream.class).in(Singleton.class);
    bind(ViewCatalog.class).in(Singleton.class);
    bind(HostServices.class).toInstance(hostServices);
  }

  private void configureModels() {
    bind(new TypeLiteral<UnitConverter<Length>>() {
    }).toInstance(new UnitConverter<>(Length.values()));
    bind(new TypeLiteral<UnitConverter<Mass>>() {
    }).toInstance(new UnitConverter<>(Mass.values()));
    bind(new TypeLiteral<UnitConverter<Volume>>() {
    }).toInstance(new UnitConverter<>(Volume.values()));
    bind(Browser.class).to(JFXBrowser.class);
  }

  private void configureViews() {
    bind(MainView.class).to(JFXMainView.class);
    bind(new TypeLiteral<ConverterView<Length>>() {
    }).to(JFXLengthConverterView.class);
    bind(new TypeLiteral<ConverterView<Mass>>() {
    }).to(JFXMassConverterView.class);
    bind(new TypeLiteral<ConverterView<Volume>>() {
    }).to(JFXVolumeConverterView.class);
    bind(SettingsView.class).to(JFXSettingsView.class);
    bind(AboutView.class).to(JFXAboutView.class);
  }
}
