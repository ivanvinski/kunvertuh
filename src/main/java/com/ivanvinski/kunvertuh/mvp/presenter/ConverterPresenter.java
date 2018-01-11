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

package com.ivanvinski.kunvertuh.mvp.presenter;

import com.google.common.eventbus.Subscribe;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.mvp.model.ConverterModel;
import com.ivanvinski.kunvertuh.mvp.view.ConverterView;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterPresenter<U extends Unit> extends
    Presenter<ConverterView<U>, ConverterModel<U>> {

  private DoubleStringConverter valueConverter = new DoubleStringConverter();

  public ConverterPresenter(ConverterView<U> view, ConverterModel<U> model,
      EventStream eventStream) {
    super(view, model, eventStream);
  }

  @Override
  public void onInitialized() {
    getModel().getCategories()
        .stream()
        .map(getModel()::getUnits)
        .forEach(this::divideUnitsAndAppendUnitsCard);
    for (U unit : getModel().getAllUnits()) {
      getView().setOnConversionAction(unit, value -> onConversionRequested(unit, value));
    }
  }

  @Override
  public void onLanguageChanged(Language language) {
    for (U unit : getModel().getAllUnits()) {
      getView().setUnitPrompt(unit, language.getString(unit.toString()));
    }
  }

  @Subscribe
  public void onNumberFormatChanged(NumberFormat numberFormat) {
    Map<U, Double> tmpValues = new HashMap<>();
    for (U unit : getModel().getAllUnits()) {
      valueConverter.parse(getView().getUnitValue(unit));
      tmpValues.put(unit, valueConverter.parse(getView().getUnitValue(unit)));
    }
    valueConverter.setValueFormat(numberFormat);
    for (U unit : getModel().getAllUnits()) {
      getView().setUnitValue(unit, valueConverter.format(tmpValues.get(unit)));
    }
  }

  public void onConversionRequested(U unit, String value) {
    getModel().getConverter().convert(valueConverter.parse(value), unit);
    for (U otherUnit : getModel().getAllUnits()) {
      String formattedValue = valueConverter.format(getModel().getConverter().getValue(otherUnit));
      getView().setUnitValue(otherUnit, formattedValue);
    }
  }

  private void divideUnitsAndAppendUnitsCard(List<U> units) {
    int halfTheSize = (int) Math.ceil((float) units.size() / 2.0);
    List<U> leftColumn = units.subList(0, halfTheSize);
    List<U> rightColumn = units.subList(halfTheSize, units.size());
    getView().appendUnitsCard(leftColumn, rightColumn);
  }
}
