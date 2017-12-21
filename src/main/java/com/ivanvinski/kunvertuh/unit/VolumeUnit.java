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

public final class VolumeUnit extends MeasurementUnit {

  public static final VolumeUnit MILLILITER = new VolumeUnit("ml", .001d);
  public static final VolumeUnit DECILITER = new VolumeUnit("dl", .1d);
  public static final VolumeUnit LITER = new VolumeUnit("l", 1d);
  public static final VolumeUnit HECTOLITER = new VolumeUnit("hl", 100d);
  public static final VolumeUnit CUBIC_METER = new VolumeUnit("m3", 1000d);

  public static final VolumeUnit UK_TEASPOON = new VolumeUnit("tsp", .00591939d);
  public static final VolumeUnit UK_TABLESPOON = new VolumeUnit("Tbsp", .0177582d);
  public static final VolumeUnit UK_CUP = new VolumeUnit("cp", .284131d);
  public static final VolumeUnit UK_FLUID_OUNCE = new VolumeUnit("fl oz", .0284131d);
  public static final VolumeUnit UK_GALLON = new VolumeUnit("gal", 4.54609d);

  public static final VolumeUnit US_TEASPOON = new VolumeUnit("tsp", .00492892d);
  public static final VolumeUnit US_TABLESPOON = new VolumeUnit("Tbsp", 0.0147868d);
  public static final VolumeUnit US_CUP = new VolumeUnit("cp", .24d);
  public static final VolumeUnit US_PINT = new VolumeUnit("pt", .5682612d);
  public static final VolumeUnit US_FLUID_OUNCE = new VolumeUnit("fl oz", .02957344d);
  public static final VolumeUnit US_GALLON = new VolumeUnit("gal", 3.7854003218d);

  public static final VolumeUnit CUBIC_INCH = new VolumeUnit("in3", .01638706d);

  private VolumeUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
