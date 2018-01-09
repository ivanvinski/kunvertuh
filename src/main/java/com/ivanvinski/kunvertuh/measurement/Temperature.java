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

public enum Temperature implements Unit {

  CELSIUS("C", MeasurementSystem.METRIC),
  FAHRENHEIT("F", MeasurementSystem.IMPERIAL_AND_US_CUSTOMARY),
  KELVIN("K", null);

  private String symbol;
  private MeasurementSystem system;

  Temperature(String symbol, MeasurementSystem system) {
    this.symbol = symbol;
    this.system = system;
  }

  @Override
  public double getBaseUnitFactor() {
    return 0d;
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
