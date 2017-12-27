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

package com.ivanvinski.kunvertuh.presenter;

import com.google.common.eventbus.Subscribe;
import com.ivanvinski.kunvertuh.event.ConversionRequest;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.ConverterView;
import java.util.Objects;

public abstract class AbstractConverterPresenter<U extends Unit> extends
    AbstractPresenter<ConverterView<U>, UnitConverter<U>> {

  private DoubleStringConverter valueConverter;

  public AbstractConverterPresenter(ConverterView<U> view, UnitConverter<U> model,
      DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void onInitialization() {
    getView().initialize(getModel().getSupportedUnits());
  }

  @Override
  public void onLanguageChange(Language language) {
    super.onLanguageChange(language);
    for (U unit : getModel().getSupportedUnits()) {
      getView().setValue(unit, "");
    }
    valueConverter.setValueFormat(language.getNumberFormat());
  }

  @Subscribe
  public void onConversionRequested(ConversionRequest request) {
    if (getUnitConversionType() != request.getUnitType()) {
      return;
    }
    getModel().convert(valueConverter.parse(request.getValue()), (U) request.getUnit());
    for (U unit : getModel().getSupportedUnits()) {
      getView().setValue(unit, valueConverter.format(getModel().getValue(unit)));
    }
  }

  public abstract Class<U> getUnitConversionType();
}
