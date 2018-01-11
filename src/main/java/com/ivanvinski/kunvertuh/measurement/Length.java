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

public enum Length implements Unit {

  MILLIMETER(.001d, "mm", UnitCategory.METRIC),
  CENTIMETER(.01d, "cm", UnitCategory.METRIC),
  DECIMETER(.1d, "dm", UnitCategory.METRIC),
  METER(1d, "m", UnitCategory.METRIC),
  KILOMETER(1000d, "km", UnitCategory.METRIC),

  INCH(.0254d, "in", UnitCategory.NON_METRIC),
  FOOT(.3048d, "ft", UnitCategory.NON_METRIC),
  YARD(.9144d, "yd", UnitCategory.NON_METRIC),
  MILE(1609.344d, "mi", UnitCategory.NON_METRIC),
  UK_LEAGUE(4828d, "st leag", UnitCategory.NON_METRIC),
  US_LEAGUE(4828.0417d, "st leag", UnitCategory.NON_METRIC);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  Length(double baseUnitFactor, String symbol, UnitCategory category) {
    this.symbol = symbol;
    this.baseUnitFactor = baseUnitFactor;
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
