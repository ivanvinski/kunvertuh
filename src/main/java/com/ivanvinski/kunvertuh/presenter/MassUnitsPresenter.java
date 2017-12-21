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
import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.unit.MassUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import java.util.Objects;

public final class MassUnitsPresenter extends AbstractPresenter<MassUnitsView, MassUnitsModel> {

  private DoubleStringConverter valueConverter;

  @Inject
  public MassUnitsPresenter(MassUnitsView view, MassUnitsModel model,
      DoubleStringConverter valueConverter) {
    super(view, model);
    this.valueConverter = Objects.requireNonNull(valueConverter, "Value converter can't be null");
  }

  @Override
  public void initialize() {
  }

  public void conversionRequested(String sourceMass, MassUnit sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceMass);
    getModel().convert(conversionValue, sourceUnit);
    getView().setMilligrams(valueConverter.format(getModel().getMilligrams()));
    getView().setGrams(valueConverter.format(getModel().getGrams()));
    getView().setDekagrams(valueConverter.format(getModel().getDekagrams()));
    getView().setKilograms(valueConverter.format(getModel().getKilograms()));
    getView().setGrains(valueConverter.format(getModel().getGrains()));
    getView().setDrams(valueConverter.format(getModel().getDrams()));
    getView().setOunces(valueConverter.format(getModel().getOunces()));
    getView().setPounds(valueConverter.format(getModel().getPounds()));
  }
}
