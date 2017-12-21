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

public final class LengthUnit extends MeasurementUnit {

  public static final LengthUnit MILLIMETER = new LengthUnit("mm", .001d);
  public static final LengthUnit CENTIMETER = new LengthUnit("cm", .01d);
  public static final LengthUnit DECIMETER = new LengthUnit("dm", .1d);
  public static final LengthUnit METER = new LengthUnit("m", 1d);
  public static final LengthUnit KILOMETER = new LengthUnit("km", 1000d);

  public static final LengthUnit INCH = new LengthUnit("in", .0254d);
  public static final LengthUnit FOOT = new LengthUnit("ft", .3048d);
  public static final LengthUnit YARD = new LengthUnit("yd", .9144d);
  public static final LengthUnit MILE = new LengthUnit("mi", 1609.344d);
  public static final LengthUnit UK_LEAGUE = new LengthUnit("", 4828d);
  public static final LengthUnit US_LEAGUE = new LengthUnit("", 4828.0417d);

  private LengthUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
