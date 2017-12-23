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

package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.measurement.MeasurementSystem;
import com.ivanvinski.kunvertuh.measurement.Unit;
import java.util.Collection;

public interface ConverterView<U extends Unit> extends View {

  @Override
  default void initialize() {
  }

  void initialize(Collection<U> supportedUnits);

  String getTitle(MeasurementSystem system);

  void setTitle(MeasurementSystem system, String title);

  String getPrompt(U unit);

  void setPrompt(U unit, String prompt);

  String getValue(U unit);

  void setValue(U unit, String value);
}
