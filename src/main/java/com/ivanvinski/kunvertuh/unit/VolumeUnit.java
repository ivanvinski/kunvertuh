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
  public static final VolumeUnit LITER = new VolumeUnit("l", 1d);
  public static final VolumeUnit CUBIC_METER = new VolumeUnit("m3", 1000d);

  public static final VolumeUnit UK_FLUID_OUNCE = new VolumeUnit("fl oz", .0284131d);
  public static final VolumeUnit UK_GALLON = new VolumeUnit("gal", 4.54609d);

  public static final VolumeUnit PINT = new VolumeUnit("pt", .5682612d);

  private VolumeUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
