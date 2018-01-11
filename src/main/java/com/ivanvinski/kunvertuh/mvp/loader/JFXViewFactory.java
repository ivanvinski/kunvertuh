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
import com.ivanvinski.kunvertuh.measurement.Angle;
import com.ivanvinski.kunvertuh.measurement.Area;
import com.ivanvinski.kunvertuh.measurement.DataTransferRate;
import com.ivanvinski.kunvertuh.measurement.DigitalStorage;
import com.ivanvinski.kunvertuh.measurement.Length;
import com.ivanvinski.kunvertuh.measurement.Mass;
import com.ivanvinski.kunvertuh.measurement.Pressure;
import com.ivanvinski.kunvertuh.measurement.Speed;
import com.ivanvinski.kunvertuh.measurement.Temperature;
import com.ivanvinski.kunvertuh.measurement.TemperatureConverter;
import com.ivanvinski.kunvertuh.measurement.Time;
import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.measurement.Volume;
import com.ivanvinski.kunvertuh.mvp.model.AboutModel;
import com.ivanvinski.kunvertuh.mvp.model.ConverterModel;
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
      return createConverterMVP(Length.values(), eventStream);
    } else if (presenterType == Mass.class) {
      return createConverterMVP(Mass.values(), eventStream);
    } else if (presenterType == Volume.class) {
      return createConverterMVP(Volume.values(), eventStream);
    } else if (presenterType == Area.class) {
      return createConverterMVP(Area.values(), eventStream);
    } else if (presenterType == Temperature.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(),
          new ConverterModel<>(new TemperatureConverter()),
          eventStream);
    } else if (presenterType == Speed.class) {
      return createConverterMVP(Speed.values(), eventStream);
    } else if (presenterType == Time.class) {
      return createConverterMVP(Time.values(), eventStream);
    } else if (presenterType == Pressure.class) {
      return createConverterMVP(Pressure.values(), eventStream);
    } else if (presenterType == Angle.class) {
      return createConverterMVP(Angle.values(), eventStream);
    } else if (presenterType == DataTransferRate.class) {
      return createConverterMVP(DataTransferRate.values(), eventStream);
    } else if (presenterType == DigitalStorage.class) {
      return createConverterMVP(DigitalStorage.values(), eventStream);
    }
    throw new IllegalArgumentException("Unsupported presenter type: " + presenterType);
  }

  private <U extends Unit> ConverterPresenter<U> createConverterMVP(U[] units,
      EventStream eventStream) {
    return new ConverterPresenter<>(new JFXConverterView<>(),
        new ConverterModel<>(units),
        eventStream);
  }
}
