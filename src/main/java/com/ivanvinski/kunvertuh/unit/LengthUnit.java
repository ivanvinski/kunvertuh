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

  public static final LengthUnit MILLIMETERS = new LengthUnit("mm", .001d);
  public static final LengthUnit CENTIMETERS = new LengthUnit("cm", .01d);
  public static final LengthUnit DECIMETERS = new LengthUnit("dm", .1d);
  public static final LengthUnit METERS = new LengthUnit("m", 1d);
  public static final LengthUnit KILOMETERS = new LengthUnit("km", 1000d);

  public static final LengthUnit INCHES = new LengthUnit("in", .0254d);
  public static final LengthUnit FEET = new LengthUnit("ft", .3048d);
  public static final LengthUnit YARDS = new LengthUnit("yd", .9144d);
  public static final LengthUnit MILES = new LengthUnit("mi", 1609.344d);

  private LengthUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
