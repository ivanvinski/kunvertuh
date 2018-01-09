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

  NANOSECOND(.000000001d),
  MICROSECOND(.000001d),
  MILLISECOND(.001d),
  SECOND(1d),
  MINUTE(60d),
  HOUR(3600d),
  DAY(86400d),
  WEEK(604800d),
  MONTH(2628000d),
  YEAR(31540000d),
  DECADE(315400000d),
  CENTURY(3154000000d);

  private double baseUnitFactor;

  Time(double baseUnitFactor) {
    this.baseUnitFactor = baseUnitFactor;
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
  public MeasurementSystem getSystem() {
    return MeasurementSystem.METRIC;
  }
}
