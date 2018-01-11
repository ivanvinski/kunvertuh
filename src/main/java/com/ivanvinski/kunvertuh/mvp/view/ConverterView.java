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

package com.ivanvinski.kunvertuh.mvp.view;

import com.ivanvinski.kunvertuh.measurement.Unit;
import java.util.List;
import java.util.function.Consumer;

public interface ConverterView<U extends Unit> extends View {

  void appendUnitsCard(List<U> leftColumn, List<U> rightColumn);

  String getUnitPrompt(U unit);

  void setUnitPrompt(U unit, String prompt);

  String getUnitValue(U unit);

  void setUnitValue(U unit, String value);

  Consumer<String> getOnConversionAction(U unit);

  void setOnConversionAction(U unit, Consumer<String> conversionAction);
}
