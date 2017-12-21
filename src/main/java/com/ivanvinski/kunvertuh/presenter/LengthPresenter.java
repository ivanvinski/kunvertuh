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
import com.ivanvinski.kunvertuh.model.LengthModel;
import com.ivanvinski.kunvertuh.unit.Length;
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

  @Override
  public void initialize() {
  }

  public void conversionRequested(String sourceLength, Length sourceUnit) {
    Double conversionValue = valueConverter.parse(sourceLength);
    getModel().convert(conversionValue, sourceUnit);
    updateMetricValues();
    updateNonMetricValues();
  }

  private void updateMetricValues() {
    getView().setMillimetersValue(valueConverter.format(getModel().getMillimeters()));
    getView().setCentimetersValue(valueConverter.format(getModel().getCentimeters()));
    getView().setDecimetersValue(valueConverter.format(getModel().getDecimeters()));
    getView().setMetersValue(valueConverter.format(getModel().getMeters()));
    getView().setKilometersValue(valueConverter.format(getModel().getKilometers()));
  }

  private void updateNonMetricValues() {
    getView().setInchesValue(valueConverter.format(getModel().getInches()));
    getView().setFeetValue(valueConverter.format(getModel().getFeet()));
    getView().setYardsValue(valueConverter.format(getModel().getYards()));
    getView().setMilesValue(valueConverter.format(getModel().getMiles()));
    getView().setUkLeaguesValue(valueConverter.format(getModel().getUkLeagues()));
    getView().setUsLeaguesValue(valueConverter.format(getModel().getUsLeagues()));
  }
}
