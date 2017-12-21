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

import com.ivanvinski.kunvertuh.unit.MeasurementUnit;
import java.util.Objects;

public class MeasurementUnitConverter<U extends MeasurementUnit> {

  public Double convert(Double sourceValue, U sourceUnit, U outputUnit) {
    Objects.requireNonNull(sourceUnit, "Source unit can't be null");
    Objects.requireNonNull(outputUnit, "Output unit can't be null");
    if (sourceValue == null) {
      return null;
    }
    double baseUnitValue = sourceValue * sourceUnit.getBaseUnitFactor();
    return baseUnitValue / outputUnit.getBaseUnitFactor();
  }
}
