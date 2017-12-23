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

import static com.ivanvinski.kunvertuh.unit.Mass.DEKAGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.DRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.GRAIN;
import static com.ivanvinski.kunvertuh.unit.Mass.GRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.KILOGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.METRIC_TON;
import static com.ivanvinski.kunvertuh.unit.Mass.MILLIGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.OUNCE;
import static com.ivanvinski.kunvertuh.unit.Mass.POUND;
import static com.ivanvinski.kunvertuh.unit.Mass.UK_TON;
import static com.ivanvinski.kunvertuh.unit.Mass.US_TON;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.conversion.MassConversionRequest;
import com.ivanvinski.kunvertuh.unit.Mass;
import com.ivanvinski.kunvertuh.unit.UnitConverter;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.MassView;
import java.util.Objects;

public final class MassPresenter extends AbstractPresenter<MassView, UnitConverter<Mass>> {

  private DoubleStringConverter valueConverter;

  @Inject
  public MassPresenter(MassView view, UnitConverter<Mass> model,
      DoubleStringConverter valueConverter) {
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
    getView().setMilligrams(valueConverter.format(getModel().getValue(MILLIGRAM)));
    getView().setGrams(valueConverter.format(getModel().getValue(GRAM)));
    getView().setDekagrams(valueConverter.format(getModel().getValue(DEKAGRAM)));
    getView().setKilograms(valueConverter.format(getModel().getValue(KILOGRAM)));
    getView().setMetricTons(valueConverter.format(getModel().getValue(METRIC_TON)));
  }

  private void updateNonMetricValues() {
    getView().setGrains(valueConverter.format(getModel().getValue(GRAIN)));
    getView().setDrams(valueConverter.format(getModel().getValue(DRAM)));
    getView().setOunces(valueConverter.format(getModel().getValue(OUNCE)));
    getView().setPounds(valueConverter.format(getModel().getValue(POUND)));
    getView().setUkTons(valueConverter.format(getModel().getValue(UK_TON)));
    getView().setUsTons(valueConverter.format(getModel().getValue(US_TON)));
  }
}
