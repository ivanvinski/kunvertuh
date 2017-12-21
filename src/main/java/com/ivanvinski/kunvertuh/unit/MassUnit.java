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

public final class MassUnit extends MeasurementUnit {

  public static final MassUnit MILLIGRAM = new MassUnit("mg", .001d);
  public static final MassUnit GRAM = new MassUnit("g", 1d);
  public static final MassUnit DEKAGRAM = new MassUnit("dag", 10d);
  public static final MassUnit KILOGRAM = new MassUnit("kg", 1000d);

  public static final MassUnit GRAIN = new MassUnit("gr", .06479891d);
  public static final MassUnit DRAM = new MassUnit("dr", 1.771845d);
  public static final MassUnit OUNCE = new MassUnit("oz", 28.34952d);
  public static final MassUnit POUND = new MassUnit("lb", 453.5924d);

  private MassUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
