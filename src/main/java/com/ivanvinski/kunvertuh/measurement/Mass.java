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

public enum Mass implements Unit {

  MILLIGRAM(.001d, "mg", UnitCategory.METRIC),
  GRAM(1d, "g", UnitCategory.METRIC),
  DEKAGRAM(10d, "dag", UnitCategory.METRIC),
  KILOGRAM(1000d, "kg", UnitCategory.METRIC),
  METRIC_TON(1000000d, "t", UnitCategory.METRIC),

  GRAIN(.06479891d, "gr", UnitCategory.NON_METRIC),
  DRAM(1.771845d, "dr", UnitCategory.NON_METRIC),
  OUNCE(28.34952d, "oz", UnitCategory.NON_METRIC),
  POUND(453.5924d, "lb", UnitCategory.NON_METRIC),
  UK_TON(1016047.203454d, "t", UnitCategory.NON_METRIC),
  US_TON(907185d, "t", UnitCategory.NON_METRIC);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  Mass(double baseUnitFactor, String symbol, UnitCategory category) {
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
