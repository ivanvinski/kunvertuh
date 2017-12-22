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
import com.ivanvinski.kunvertuh.event.conversion.LengthConversionRequest;
import com.ivanvinski.kunvertuh.model.LengthModel;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.LengthView;
import java.util.Objects;

public final class LengthPresenter extends AbstractPresenter<LengthView, LengthModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public LengthPresenter(LengthView view, LengthModel model, DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Subscribe
  public void onConversionRequested(LengthConversionRequest request) {
    Double length = valueConverter.parse(request.getValue());
    getModel().convert(length, request.getUnit());
    updateMetricValues();
    updateNonMetricValues();
  }

  private void updateMetricValues() {
    getView().setMillimeters(valueConverter.format(getModel().getMillimeters()));
    getView().setCentimeters(valueConverter.format(getModel().getCentimeters()));
    getView().setDecimeters(valueConverter.format(getModel().getDecimeters()));
    getView().setMeters(valueConverter.format(getModel().getMeters()));
    getView().setKilometers(valueConverter.format(getModel().getKilometers()));
  }

  private void updateNonMetricValues() {
    getView().setInches(valueConverter.format(getModel().getInches()));
    getView().setFeet(valueConverter.format(getModel().getFeet()));
    getView().setYards(valueConverter.format(getModel().getYards()));
    getView().setMiles(valueConverter.format(getModel().getMiles()));
    getView().setUkLeagues(valueConverter.format(getModel().getUkLeagues()));
    getView().setUsLeagues(valueConverter.format(getModel().getUsLeagues()));
  }
}
