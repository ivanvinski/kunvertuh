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

package com.ivanvinski.kunvertuh.unit;

public final class Mass extends Unit {

  public static final Mass MILLIGRAM = new Mass("mg", .001d);
  public static final Mass GRAM = new Mass("g", 1d);
  public static final Mass DEKAGRAM = new Mass("dag", 10d);
  public static final Mass KILOGRAM = new Mass("kg", 1000d);
  public static final Mass METRIC_TON = new Mass("t", 1000000d);

  public static final Mass GRAIN = new Mass("gr", .06479891d);
  public static final Mass DRAM = new Mass("dr", 1.771845d);
  public static final Mass OUNCE = new Mass("oz", 28.34952d);
  public static final Mass POUND = new Mass("lb", 453.5924d);
  public static final Mass UK_TON = new Mass("t", 1016047.203454d);
  public static final Mass US_TON = new Mass("t", 907185d);

  private Mass(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
