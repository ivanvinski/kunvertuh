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

public final class Volume extends Unit {

  public static final Volume MILLILITER = new Volume("ml", .001d);
  public static final Volume DECILITER = new Volume("dl", .1d);
  public static final Volume LITER = new Volume("l", 1d);
  public static final Volume HECTOLITER = new Volume("hl", 100d);
  public static final Volume CUBIC_METER = new Volume("m3", 1000d);

  public static final Volume UK_TEASPOON = new Volume("tsp", .00591939d);
  public static final Volume UK_TABLESPOON = new Volume("Tbsp", .0177582d);
  public static final Volume UK_CUP = new Volume("cp", .284131d);
  public static final Volume UK_FLUID_OUNCE = new Volume("fl oz", .0284131d);
  public static final Volume UK_PINT = new Volume("pt", .5682612d);
  public static final Volume UK_GALLON = new Volume("gal", 4.54609d);

  public static final Volume US_TEASPOON = new Volume("tsp", .00492892d);
  public static final Volume US_TABLESPOON = new Volume("Tbsp", 0.0147868d);
  public static final Volume US_CUP = new Volume("cp", .24d);
  public static final Volume US_FLUID_OUNCE = new Volume("fl oz", .02957344d);
  public static final Volume US_PINT = new Volume("pt", .473176d);
  public static final Volume US_GALLON = new Volume("gal", 3.7854003218d);

  public static final Volume CUBIC_INCH = new Volume("in3", .01638706d);

  private Volume(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
