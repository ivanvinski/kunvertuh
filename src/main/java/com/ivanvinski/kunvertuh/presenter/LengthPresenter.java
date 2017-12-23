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

import static com.ivanvinski.kunvertuh.unit.Length.CENTIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.DECIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.FOOT;
import static com.ivanvinski.kunvertuh.unit.Length.INCH;
import static com.ivanvinski.kunvertuh.unit.Length.KILOMETER;
import static com.ivanvinski.kunvertuh.unit.Length.METER;
import static com.ivanvinski.kunvertuh.unit.Length.MILE;
import static com.ivanvinski.kunvertuh.unit.Length.MILLIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.UK_LEAGUE;
import static com.ivanvinski.kunvertuh.unit.Length.US_LEAGUE;
import static com.ivanvinski.kunvertuh.unit.Length.YARD;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.conversion.LengthConversionRequest;
import com.ivanvinski.kunvertuh.unit.Length;
import com.ivanvinski.kunvertuh.unit.UnitConverter;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.LengthView;
import java.util.Objects;

public final class LengthPresenter extends AbstractPresenter<LengthView, UnitConverter<Length>> {

  private DoubleStringConverter valueConverter;

  @Inject
  public LengthPresenter(LengthView view, UnitConverter<Length> model,
      DoubleStringConverter valueConverter) {
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
    getView().setMillimeters(valueConverter.format(getModel().getValue(MILLIMETER)));
    getView().setCentimeters(valueConverter.format(getModel().getValue(CENTIMETER)));
    getView().setDecimeters(valueConverter.format(getModel().getValue(DECIMETER)));
    getView().setMeters(valueConverter.format(getModel().getValue(METER)));
    getView().setKilometers(valueConverter.format(getModel().getValue(KILOMETER)));
  }

  private void updateNonMetricValues() {
    getView().setInches(valueConverter.format(getModel().getValue(INCH)));
    getView().setFeet(valueConverter.format(getModel().getValue(FOOT)));
    getView().setYards(valueConverter.format(getModel().getValue(YARD)));
    getView().setMiles(valueConverter.format(getModel().getValue(MILE)));
    getView().setUkLeagues(valueConverter.format(getModel().getValue(UK_LEAGUE)));
    getView().setUsLeagues(valueConverter.format(getModel().getValue(US_LEAGUE)));
  }
}
