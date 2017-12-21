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

  public static final MassUnit MILLIGRAMS = new MassUnit("mg", .001d);
  public static final MassUnit GRAMS = new MassUnit("g", 1d);
  public static final MassUnit DEKAGRAMS = new MassUnit("dag", 10d);
  public static final MassUnit KILOGRAMS = new MassUnit("kg", 1000d);

  public static final MassUnit GRAINS = new MassUnit("gr", .06479891d);
  public static final MassUnit DRAMS = new MassUnit("dr", 1.771845d);
  public static final MassUnit OUNCES = new MassUnit("oz", 28.34952d);
  public static final MassUnit POUNDS = new MassUnit("lb", 453.5924d);

  private MassUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
