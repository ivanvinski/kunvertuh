/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.mvp.loader;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.measurement.Area;
import com.ivanvinski.kunvertuh.measurement.Length;
import com.ivanvinski.kunvertuh.measurement.Mass;
import com.ivanvinski.kunvertuh.measurement.Speed;
import com.ivanvinski.kunvertuh.measurement.Temperature;
import com.ivanvinski.kunvertuh.measurement.TemperatureConverter;
import com.ivanvinski.kunvertuh.measurement.Time;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.measurement.Volume;
import com.ivanvinski.kunvertuh.mvp.model.AboutModel;
import com.ivanvinski.kunvertuh.mvp.model.MainModel;
import com.ivanvinski.kunvertuh.mvp.model.SettingsModel;
import com.ivanvinski.kunvertuh.mvp.presenter.AboutPresenter;
import com.ivanvinski.kunvertuh.mvp.presenter.ConverterPresenter;
import com.ivanvinski.kunvertuh.mvp.presenter.MainPresenter;
import com.ivanvinski.kunvertuh.mvp.presenter.Presenter;
import com.ivanvinski.kunvertuh.mvp.presenter.SettingsPresenter;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXAboutView;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXConverterView;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXMainView;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXSettingsView;
import com.ivanvinski.kunvertuh.storage.DefaultSettings;
import javafx.util.Callback;

final class JFXViewFactory implements Callback<Class<?>, Object> {

  private final EventStream eventStream;
  private Presenter presenter;

  public JFXViewFactory(EventStream eventStream) {
    this.eventStream = eventStream;
  }

  @Override
  public Object call(Class<?> presenterType) {
    presenter = createPresenter(presenterType);
    eventStream.subscribe(presenter);
    return presenter.getView();
  }

  public Presenter getPresenter() {
    return presenter;
  }

  private Presenter createPresenter(Class<?> presenterType) {
    if (presenterType == MainPresenter.class) {
      return new MainPresenter(new JFXMainView(),
          new MainModel(),
          eventStream);
    } else if (presenterType == SettingsPresenter.class) {
      return new SettingsPresenter(new JFXSettingsView(),
          new SettingsModel(new DefaultSettings()),
          eventStream);
    } else if (presenterType == AboutPresenter.class) {
      return new AboutPresenter(new JFXAboutView(),
          new AboutModel(),
          eventStream);
    } else if (presenterType == Length.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Length.values()),
          new UnitConverter<>(Length.values()),
          eventStream);
    } else if (presenterType == Mass.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Mass.values()),
          new UnitConverter<>(Mass.values()),
          eventStream);
    } else if (presenterType == Volume.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Volume.values()),
          new UnitConverter<>(Volume.values()),
          eventStream);
    } else if (presenterType == Area.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Area.values()),
          new UnitConverter<>(Area.values()),
          eventStream);
    } else if (presenterType == Temperature.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Temperature.values()),
          new TemperatureConverter(),
          eventStream);
    } else if (presenterType == Speed.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Speed.values()),
          new UnitConverter<>(Speed.values()),
          eventStream);
    } else if (presenterType == Time.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Time.values()),
          new UnitConverter<>(Time.values()),
          eventStream);
    }
    throw new IllegalArgumentException("Unsupported presenter type: " + presenterType);
  }
}
