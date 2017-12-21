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

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MassModel;
import com.ivanvinski.kunvertuh.unit.Mass;
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

  @Override
  public void initialize() {
  }

  public void conversionRequested(String sourceMass, Mass sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    getModel().convert(conversionValue, sourceUnit);
    updateMetricValues();
    updateNonMetricValues();
  }

  private void updateMetricValues() {
    getView().setMilligramsValue(valueConverter.format(getModel().getMilligrams()));
    getView().setGramsValue(valueConverter.format(getModel().getGrams()));
    getView().setDekagramsValue(valueConverter.format(getModel().getDekagrams()));
    getView().setKilogramsValue(valueConverter.format(getModel().getKilograms()));
    getView().setMetricTonsValue(valueConverter.format(getModel().getMetricTons()));
  }

  private void updateNonMetricValues() {
    getView().setGrainsValue(valueConverter.format(getModel().getGrains()));
    getView().setDramsValue(valueConverter.format(getModel().getDrams()));
    getView().setOuncesValue(valueConverter.format(getModel().getOunces()));
    getView().setPoundsValue(valueConverter.format(getModel().getPounds()));
    getView().setUkTonsValue(valueConverter.format(getModel().getUkTons()));
    getView().setUsTonsValue(valueConverter.format(getModel().getUsTons()));
  }
}