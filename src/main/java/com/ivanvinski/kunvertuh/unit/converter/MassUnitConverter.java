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

import com.ivanvinski.kunvertuh.unit.MassUnit;

public final class MassUnitConverter extends MeasurementUnitConverter<MassUnit> {

  public Double toMilligrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.MILLIGRAMS);
  }

  public Double toGrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.GRAMS);
  }

  public Double toDekagrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.DEKAGRAMS);
  }

  public Double toKilograms(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.KILOGRAMS);
  }

  public Double toGrains(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.GRAINS);
  }

  public Double toDrams(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.DRAMS);
  }

  public Double toOunces(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.OUNCES);
  }

  public Double toPounds(Double sourceMass, MassUnit sourceUnit) {
    return convert(sourceMass, sourceUnit, MassUnit.POUNDS);
  }
}
