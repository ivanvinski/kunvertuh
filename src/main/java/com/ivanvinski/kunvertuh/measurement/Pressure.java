/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.measurement;

import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.IMPERIAL_AND_US_CUSTOMARY;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.METRIC;

public enum Pressure implements Unit {

  ATMOSPHERE(101325d, "atm", null),
  BAR(100000d, "bar", METRIC),
  PASCAL(1d, "Pa", METRIC),
  POUND_FORCE_PER_SQUARE_INCH(6894.76d, "psi", IMPERIAL_AND_US_CUSTOMARY),
  MILLIMETER_OF_MERCURY(133.322d, "mmHg", null);

  private double baseUnitFactor;
  private String symbol;
  private MeasurementSystem system;

  Pressure(double baseUnitFactor, String symbol, MeasurementSystem system) {
    this.baseUnitFactor = baseUnitFactor;
    this.symbol = symbol;
    this.system = system;
  }

  @Override
  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  @Override
  public MeasurementSystem getSystem() {
    return system;
  }
}
