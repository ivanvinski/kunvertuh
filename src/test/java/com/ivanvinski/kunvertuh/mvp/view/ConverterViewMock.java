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
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConverterViewMock<U extends Unit> implements ConverterView<U> {

  private Map<U, String> unitPrompts = new HashMap<>();
  private Map<U, String> unitValues = new HashMap<>();
  private Map<U, Consumer<String>> unitConversionActions = new HashMap<>();

  @Override
  public void initialize() {
  }

  @Override
  public String getUnitPrompt(U unit) {
    return unitPrompts.get(unit);
  }

  @Override
  public void setUnitPrompt(U unit, String prompt) {
    unitPrompts.put(unit, prompt);
  }

  @Override
  public String getUnitValue(U unit) {
    return unitValues.get(unit);
  }

  @Override
  public void setUnitValue(U unit, String value) {
    unitValues.put(unit, value);
  }

  @Override
  public Consumer<String> getOnConversionAction(U unit) {
    return unitConversionActions.get(unit);
  }

  @Override
  public void setOnConversionAction(U unit, Consumer<String> conversionAction) {
    unitConversionActions.put(unit, conversionAction);
  }
}
