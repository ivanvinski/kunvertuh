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

package com.ivanvinski.kunvertuh.measurement;

import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.IMPERIAL;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.IMPERIAL_AND_US_CUSTOMARY;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.METRIC;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.US_CUSTOMARY;

public enum Length implements Unit {

  MILLIMETER(.001d, "mm", METRIC),
  CENTIMETER(.01d, "cm", METRIC),
  DECIMETER(.1d, "dm", METRIC),
  METER(1d, "m", METRIC),
  KILOMETER(1000d, "km", METRIC),

  INCH(.0254d, "in", IMPERIAL_AND_US_CUSTOMARY),
  FOOT(.3048d, "ft", IMPERIAL_AND_US_CUSTOMARY),
  YARD(.9144d, "yd", IMPERIAL_AND_US_CUSTOMARY),
  MILE(1609.344d, "mi", IMPERIAL_AND_US_CUSTOMARY),
  UK_LEAGUE(4828d, "st leag", IMPERIAL),
  US_LEAGUE(4828.0417d, "st leag", US_CUSTOMARY);

  private double baseUnitFactor;
  private String symbol;
  private MeasurementSystem measurementSystem;

  Length(double baseUnitFactor, String symbol, MeasurementSystem measurementSystem) {
    this.symbol = symbol;
    this.baseUnitFactor = baseUnitFactor;
    this.measurementSystem = measurementSystem;
  }

  @Override
  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  public MeasurementSystem getSystem() {
    return measurementSystem;
  }
}
