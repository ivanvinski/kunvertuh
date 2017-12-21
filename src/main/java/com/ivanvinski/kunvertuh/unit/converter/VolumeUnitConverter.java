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

package com.ivanvinski.kunvertuh.unit.converter;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;

public final class VolumeUnitConverter extends MeasurementUnitConverter<VolumeUnit> {

  public Double toMilliliters(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.MILLILITERS);
  }

  public Double toLiters(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.LITERS);
  }

  public Double toCubicMeters(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.CUBIC_METERS);
  }

  public Double toFluidOunces(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.FLUID_OUNCES);
  }

  public Double toPints(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.PINTS);
  }

  public Double toGallons(Double sourceVolume, VolumeUnit sourceUnit) {
    return convert(sourceVolume, sourceUnit, VolumeUnit.GALLONS);
  }
}
