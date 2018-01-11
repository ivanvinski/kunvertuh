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

public enum Time implements Unit {

  NANOSECOND(.000000001d, UnitCategory.GLOBAL),
  MICROSECOND(.000001d, UnitCategory.GLOBAL),
  MILLISECOND(.001d, UnitCategory.GLOBAL),
  SECOND(1d, UnitCategory.GLOBAL),
  MINUTE(60d, UnitCategory.GLOBAL),
  HOUR(3600d, UnitCategory.GLOBAL),
  DAY(86400d, UnitCategory.GLOBAL),
  WEEK(604800d, UnitCategory.GLOBAL),
  MONTH(2628000d, UnitCategory.GLOBAL),
  YEAR(31540000d, UnitCategory.GLOBAL),
  DECADE(315400000d, UnitCategory.GLOBAL),
  CENTURY(3154000000d, UnitCategory.GLOBAL);

  private double baseUnitFactor;
  private UnitCategory category;

  Time(double baseUnitFactor, UnitCategory category) {
    this.baseUnitFactor = baseUnitFactor;
    this.category = category;
  }

  @Override
  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }

  @Override
  public String getSymbol() {
    return null;
  }

  @Override
  public UnitCategory getCategory() {
    return category;
  }
}
