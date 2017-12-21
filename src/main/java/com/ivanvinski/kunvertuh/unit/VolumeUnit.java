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

  public static final VolumeUnit MILLILITERS = new VolumeUnit("ml", .001d);
  public static final VolumeUnit LITERS = new VolumeUnit("l", 1d);
  public static final VolumeUnit CUBIC_METERS = new VolumeUnit("m3", 1000d);

  public static final VolumeUnit FLUID_OUNCES = new VolumeUnit("fl oz", .0284131d);
  public static final VolumeUnit PINTS = new VolumeUnit("pt", .5682612d);
  public static final VolumeUnit GALLONS = new VolumeUnit("gal", 4.54609d);

  private VolumeUnit(String abbreviation, double baseUnitFactor) {
    super(abbreviation, baseUnitFactor);
  }
}
