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

public enum Speed implements Unit {

  METER_PER_SECOND(1d, "m/s", UnitCategory.METRIC),
  KILOMETER_PER_HOUR(.277778d, "km/h", UnitCategory.METRIC),
  KNOT(.514444d, "kn", UnitCategory.METRIC),
  FOOT_PER_SECOND(0.3048d, "ft/s", UnitCategory.US_CUSTOMARY),
  MILE_PER_HOUR(0.44704d, "mph", UnitCategory.US_CUSTOMARY);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  Speed(double baseUnitFactor, String symbol, UnitCategory category) {
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
