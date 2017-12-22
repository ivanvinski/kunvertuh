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
import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.conversion.MassConversionRequest;
import com.ivanvinski.kunvertuh.model.MassModel;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.MassView;
import java.util.Objects;

public final class MassPresenter extends AbstractPresenter<MassView, MassModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public MassPresenter(MassView view, MassModel model, DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Subscribe
  public void onConversionRequested(MassConversionRequest request) {
    Double conversionValue = valueConverter.parse(request.getValue());
    getModel().convert(conversionValue, request.getUnit());
    updateMetricValues();
    updateNonMetricValues();
  }

  private void updateMetricValues() {
    getView().setMilligrams(valueConverter.format(getModel().getMilligrams()));
    getView().setGrams(valueConverter.format(getModel().getGrams()));
    getView().setDekagrams(valueConverter.format(getModel().getDekagrams()));
    getView().setKilograms(valueConverter.format(getModel().getKilograms()));
    getView().setMetricTons(valueConverter.format(getModel().getMetricTons()));
  }

  private void updateNonMetricValues() {
    getView().setGrains(valueConverter.format(getModel().getGrains()));
    getView().setDrams(valueConverter.format(getModel().getDrams()));
    getView().setOunces(valueConverter.format(getModel().getOunces()));
    getView().setPounds(valueConverter.format(getModel().getPounds()));
    getView().setUkTons(valueConverter.format(getModel().getUkTons()));
    getView().setUsTons(valueConverter.format(getModel().getUsTons()));
  }
}
