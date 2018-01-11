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

public enum Pressure implements Unit {

  PASCAL(1d, "Pa", UnitCategory.METRIC),
  BAR(100000d, "bar", UnitCategory.METRIC),
  MILLIMETER_OF_MERCURY(133.322d, "mmHg", UnitCategory.METRIC),
  ATMOSPHERE(101325d, "atm", UnitCategory.US_CUSTOMARY),
  POUND_FORCE_PER_SQUARE_INCH(6894.76d, "psi", UnitCategory.US_CUSTOMARY);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  Pressure(double baseUnitFactor, String symbol, UnitCategory category) {
    this.baseUnitFactor = baseUnitFactor;
    this.symbol = symbol;
    this.category = category;
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
  public UnitCategory getCategory() {
    return category;
  }
}
