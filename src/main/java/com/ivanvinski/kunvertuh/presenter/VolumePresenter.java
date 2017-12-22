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
import com.ivanvinski.kunvertuh.event.conversion.VolumeConversionRequest;
import com.ivanvinski.kunvertuh.model.VolumeModel;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.VolumeView;
import java.util.Objects;

public final class VolumePresenter extends AbstractPresenter<VolumeView, VolumeModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public VolumePresenter(VolumeView view, VolumeModel model, DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Subscribe
  public void onConversionRequested(VolumeConversionRequest request) {
    Double conversionValue = valueConverter.parse(request.getValue());
    getModel().convert(conversionValue, request.getUnit());
    updateMetricValues();
    updateImperialValues();
    updateUsValues();
    getView().setCubicInches(valueConverter.format(getModel().getCubicInches()));
  }

  private void updateMetricValues() {
    getView().setMilliliters(valueConverter.format(getModel().getMilliliters()));
    getView().setDeciliters(valueConverter.format(getModel().getDeciliters()));
    getView().setLiters(valueConverter.format(getModel().getLiters()));
    getView().setHectoliters(valueConverter.format(getModel().getHectoliters()));
    getView().setCubicMeters(valueConverter.format(getModel().getCubicMeters()));
  }

  private void updateImperialValues() {
    getView().setUkTeaspoons(valueConverter.format(getModel().getUkTeaspoons()));
    getView().setUkTablespoons(valueConverter.format(getModel().getUkTablespoons()));
    getView().setUkCups(valueConverter.format(getModel().getUkCups()));
    getView().setUkFluidOunces(valueConverter.format(getModel().getUkFluidOunces()));
    getView().setUkPints(valueConverter.format(getModel().getUkPints()));
    getView().setUkGallons(valueConverter.format(getModel().getUkGallons()));
  }

  private void updateUsValues() {
    getView().setUsTeaspoons(valueConverter.format(getModel().getUsTeaspoons()));
    getView().setUsTablespoons(valueConverter.format(getModel().getUsTablespoons()));
    getView().setUsCups(valueConverter.format(getModel().getUsCups()));
    getView().setUsFluidOunces(valueConverter.format(getModel().getUsFluidOunces()));
    getView().setUsPints(valueConverter.format(getModel().getUsPints()));
    getView().setUsGallons(valueConverter.format(getModel().getUsGallons()));
  }
}
