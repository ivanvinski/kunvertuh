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

import static com.ivanvinski.kunvertuh.unit.Volume.CUBIC_INCH;
import static com.ivanvinski.kunvertuh.unit.Volume.CUBIC_METER;
import static com.ivanvinski.kunvertuh.unit.Volume.DECILITER;
import static com.ivanvinski.kunvertuh.unit.Volume.HECTOLITER;
import static com.ivanvinski.kunvertuh.unit.Volume.LITER;
import static com.ivanvinski.kunvertuh.unit.Volume.MILLILITER;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_CUP;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_GALLON;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_PINT;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_TABLESPOON;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_TEASPOON;
import static com.ivanvinski.kunvertuh.unit.Volume.US_CUP;
import static com.ivanvinski.kunvertuh.unit.Volume.US_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.unit.Volume.US_GALLON;
import static com.ivanvinski.kunvertuh.unit.Volume.US_PINT;
import static com.ivanvinski.kunvertuh.unit.Volume.US_TABLESPOON;
import static com.ivanvinski.kunvertuh.unit.Volume.US_TEASPOON;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.conversion.VolumeConversionRequest;
import com.ivanvinski.kunvertuh.unit.UnitConverter;
import com.ivanvinski.kunvertuh.unit.Volume;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.VolumeView;
import java.util.Objects;

public final class VolumePresenter extends AbstractPresenter<VolumeView, UnitConverter<Volume>> {

  private DoubleStringConverter valueConverter;

  @Inject
  public VolumePresenter(VolumeView view, UnitConverter<Volume> model,
      DoubleStringConverter valueConverter) {
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
    getView().setCubicInches(valueConverter.format(getModel().getValue(CUBIC_INCH)));
  }

  private void updateMetricValues() {
    getView().setMilliliters(valueConverter.format(getModel().getValue(MILLILITER)));
    getView().setDeciliters(valueConverter.format(getModel().getValue(DECILITER)));
    getView().setLiters(valueConverter.format(getModel().getValue(LITER)));
    getView().setHectoliters(valueConverter.format(getModel().getValue(HECTOLITER)));
    getView().setCubicMeters(valueConverter.format(getModel().getValue(CUBIC_METER)));
  }

  private void updateImperialValues() {
    getView().setUkTeaspoons(valueConverter.format(getModel().getValue(UK_TEASPOON)));
    getView().setUkTablespoons(valueConverter.format(getModel().getValue(UK_TABLESPOON)));
    getView().setUkCups(valueConverter.format(getModel().getValue(UK_CUP)));
    getView().setUkFluidOunces(valueConverter.format(getModel().getValue(UK_FLUID_OUNCE)));
    getView().setUkPints(valueConverter.format(getModel().getValue(UK_PINT)));
    getView().setUkGallons(valueConverter.format(getModel().getValue(UK_GALLON)));
  }

  private void updateUsValues() {
    getView().setUsTeaspoons(valueConverter.format(getModel().getValue(US_TEASPOON)));
    getView().setUsTablespoons(valueConverter.format(getModel().getValue(US_TABLESPOON)));
    getView().setUsCups(valueConverter.format(getModel().getValue(US_CUP)));
    getView().setUsFluidOunces(valueConverter.format(getModel().getValue(US_FLUID_OUNCE)));
    getView().setUsPints(valueConverter.format(getModel().getValue(US_PINT)));
    getView().setUsGallons(valueConverter.format(getModel().getValue(US_GALLON)));
  }
}
