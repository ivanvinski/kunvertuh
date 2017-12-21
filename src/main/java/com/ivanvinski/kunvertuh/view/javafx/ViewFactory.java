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

package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ivanvinski.kunvertuh.presenter.Presenter;
import java.util.Objects;
import javafx.util.Callback;

public class ViewFactory implements Callback<Class<?>, Object> {

  private final Injector presenterCreator;
  private Presenter presenter;

  public ViewFactory(AbstractModule presenterModule) {
    Objects.requireNonNull(presenterModule, "Can't assemble view with null module");
    presenterCreator = Guice.createInjector(presenterModule);
  }

  @Override
  public Object call(Class<?> presenterType) {
    throwExceptionIfNotImplementPresenter(presenterType);
    presenter = (Presenter) presenterCreator.getInstance(presenterType);
    return presenter.getView();
  }

  public Presenter getPresenter() {
    return presenter;
  }

  private void throwExceptionIfNotImplementPresenter(Class<?> presenterType) {
    if (!Presenter.class.isAssignableFrom(presenterType)) {
      throw new IllegalArgumentException("Does not implement Presenter: " + presenterType);
    }
  }
}
