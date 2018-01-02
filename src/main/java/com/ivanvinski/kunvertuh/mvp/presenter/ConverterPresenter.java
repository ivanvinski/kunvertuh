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

package com.ivanvinski.kunvertuh.mvp.presenter;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.mvp.view.ConverterView;

public final class ConverterPresenter<U extends Unit> extends
    Presenter<ConverterView<U>, UnitConverter<U>> {

  private DoubleStringConverter valueConverter = new DoubleStringConverter();

  public ConverterPresenter(ConverterView<U> view, UnitConverter<U> model,
      EventStream eventStream) {
    super(view, model, eventStream);
  }

  @Override
  public void onInitialized() {
    for (U unit : getModel().getSupportedUnits()) {
      getView().setOnConversionAction(unit, value -> onConversionRequested(unit, value));
    }
  }

  @Override
  public void onLanguageChanged(Language language) {
    for (U unit : getModel().getSupportedUnits()) {
      getView().setUnitPrompt(unit, language.getString(unit.toString()));
      getView().setUnitValue(unit, "");
    }
    valueConverter.setValueFormat(language.getNumberFormat());
  }

  public void onConversionRequested(U unit, String value) {
    getModel().convert(valueConverter.parse(value), unit);
    for (U otherUnit : getModel().getSupportedUnits()) {
      getView().setUnitValue(otherUnit, valueConverter.format(getModel().getValue(otherUnit)));
    }
  }
}
