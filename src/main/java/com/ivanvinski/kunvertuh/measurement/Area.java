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

public enum Area implements Unit {

  SQUARE_MILLIMETER(.000001d, "mm2", UnitCategory.METRIC),
  SQUARE_CENTIMETER(.0001d, "cm2", UnitCategory.METRIC),
  SQUARE_METER(1d, "m2", UnitCategory.METRIC),
  HECTARE(10000d, "ha", UnitCategory.METRIC),
  SQUARE_KILOMETER(1000000d, "km2", UnitCategory.METRIC),

  SQUARE_INCH(.00064516d, "in2", UnitCategory.NON_METRIC),
  SQUARE_FOOT(.092903d, "ft2", UnitCategory.NON_METRIC),
  SQUARE_YARD(.836127d, "yd2", UnitCategory.NON_METRIC),
  ACRE(4046.86d, "ac2", UnitCategory.NON_METRIC),
  SQUARE_MILE(2590000d, "mi2", UnitCategory.NON_METRIC);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  Area(double baseUnitFactor, String symbol, UnitCategory category) {
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
