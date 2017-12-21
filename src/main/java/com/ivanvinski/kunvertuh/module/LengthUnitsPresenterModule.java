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
