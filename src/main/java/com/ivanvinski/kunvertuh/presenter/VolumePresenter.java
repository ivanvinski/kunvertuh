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
import com.ivanvinski.kunvertuh.model.VolumeModel;
import com.ivanvinski.kunvertuh.unit.Volume;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.VolumeView;
import java.util.Objects;

public final class VolumePresenter extends
    AbstractPresenter<VolumeView, VolumeModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public VolumePresenter(VolumeView view, VolumeModel model, DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
  }

  public void conversionRequested(String sourceMass, Volume sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    getModel().convert(conversionValue, sourceUnit);
    updateMetricValues();
    updateImperialValues();
    updateUsValues();
    getView().setCubicInchesValue(valueConverter.format(getModel().getCubicInches()));
  }

  private void updateMetricValues() {
    getView().setMillilitersValue(valueConverter.format(getModel().getMilliliters()));
    getView().setDecilitersValue(valueConverter.format(getModel().getDeciliters()));
    getView().setLitersValue(valueConverter.format(getModel().getLiters()));
    getView().setHectolitersValue(valueConverter.format(getModel().getHectoliters()));
    getView().setCubicMetersValue(valueConverter.format(getModel().getCubicMeters()));
  }

  private void updateImperialValues() {
    getView().setUkTeaspoonsValue(valueConverter.format(getModel().getUkTeaspoons()));
    getView().setUkTablespoonsValue(valueConverter.format(getModel().getUkTablespoons()));
    getView().setUkCupsValue(valueConverter.format(getModel().getUkCups()));
    getView().setUkFluidOuncesValue(valueConverter.format(getModel().getUkFluidOunces()));
    getView().setUkPintsValue(valueConverter.format(getModel().getUkPints()));
    getView().setUkGallonsValue(valueConverter.format(getModel().getUkGallons()));
  }

  private void updateUsValues() {
    getView().setUsTeaspoonsValue(valueConverter.format(getModel().getUsTeaspoons()));
    getView().setUsTablespoonsValue(valueConverter.format(getModel().getUsTablespoons()));
    getView().setUsCupsValue(valueConverter.format(getModel().getUsCups()));
    getView().setUsFluidOuncesValue(valueConverter.format(getModel().getUsFluidOunces()));
    getView().setUsPintsValue(valueConverter.format(getModel().getUsPints()));
    getView().setUsGallonsValue(valueConverter.format(getModel().getUsGallons()));
  }
}
