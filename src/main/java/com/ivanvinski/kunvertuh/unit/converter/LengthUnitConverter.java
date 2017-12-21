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

  public Double toMillimeter(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.MILLIMETER);
  }

  public Double toCentimeter(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.CENTIMETER);
  }

  public Double toDecimeter(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.DECIMETER);
  }

  public Double toMeter(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.METER);
  }

  public Double toKilometer(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.KILOMETER);
  }

  public Double toInch(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.INCH);
  }

  public Double toFoot(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.FOOT);
  }

  public Double toYard(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.YARD);
  }

  public Double toMile(Double sourceLength, LengthUnit sourceUnit) {
    return convert(sourceLength, sourceUnit, LengthUnit.MILE);
  }
}
