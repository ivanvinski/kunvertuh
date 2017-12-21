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

import com.ivanvinski.kunvertuh.unit.LengthUnit;

public final class LengthUnitConverter extends MeasurementUnitConverter<LengthUnit> {

  public Double toMillimeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.MILLIMETERS);
  }

  public Double toCentimeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.CENTIMETERS);
  }

  public Double toDecimeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.DECIMETERS);
  }

  public Double toMeters(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.METERS);
  }

  public Double toKilometers(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.KILOMETERS);
  }

  public Double toInches(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.INCHES);
  }

  public Double toFeet(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.FEET);
  }

  public Double toYards(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.YARDS);
  }

  public Double toMiles(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.MILES);
  }
}
