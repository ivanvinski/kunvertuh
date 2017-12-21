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

public final class Length extends Unit {

  public static final Length MILLIMETER = new Length("mm", .001d);
  public static final Length CENTIMETER = new Length("cm", .01d);
  public static final Length DECIMETER = new Length("dm", .1d);
  public static final Length METER = new Length("m", 1d);
  public static final Length KILOMETER = new Length("km", 1000d);

  public static final Length INCH = new Length("in", .0254d);
  public static final Length FOOT = new Length("ft", .3048d);
  public static final Length YARD = new Length("yd", .9144d);
  public static final Length MILE = new Length("mi", 1609.344d);
  public static final Length UK_LEAGUE = new Length("", 4828d);
  public static final Length US_LEAGUE = new Length("", 4828.0417d);

  private Length(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
