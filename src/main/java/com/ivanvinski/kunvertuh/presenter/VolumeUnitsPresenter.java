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
import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.util.Objects;

public final class VolumeUnitsPresenter extends
    AbstractPresenter<VolumeUnitsView, VolumeUnitsModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public VolumeUnitsPresenter(VolumeUnitsView view, VolumeUnitsModel model,
      DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
  }

  public void conversionRequested(String sourceMass, VolumeUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    getModel().convert(conversionValue, sourceUnit);
    getView().setMilliliters(valueConverter.format(getModel().getMilliliters()));
    getView().setLiters(valueConverter.format(getModel().getLiters()));
    getView().setCubicMeters(valueConverter.format(getModel().getCubicMeters()));
    getView().setFluidOunces(valueConverter.format(getModel().getFluidOunces()));
    getView().setPints(valueConverter.format(getModel().getPints()));
    getView().setGallons(valueConverter.format(getModel().getGallons()));
  }
}
