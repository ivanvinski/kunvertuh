/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class UnitConverter<U extends Unit> {

  private Map<U, Double> convertedValues = new LinkedHashMap<>();

  public UnitConverter(U... supportedUnits) {
    Arrays.stream(supportedUnits)
        .filter(Objects::nonNull)
        .forEach(this::registerUnit);
  }

  public void convert(double sourceValue, U sourceUnit) {
    throwExceptionIfNullOrUnsupportedUnit(sourceUnit);
    double baseValue = toBaseValue(sourceValue, sourceUnit);
    getSupportedUnits().forEach(unit -> convertBaseValueToTargetUnit(baseValue, unit));
  }

  public Collection<U> getSupportedUnits() {
    return convertedValues.keySet();
  }

  public double getValue(U unit) {
    return convertedValues.get(unit);
  }

  private void registerUnit(U unit) {
    convertedValues.put(unit, 0d);
  }

  private void throwExceptionIfNullOrUnsupportedUnit(U unit) {
    Objects.requireNonNull(unit, "Can't work with null unit");
    if (!convertedValues.containsKey(unit)) {
      throw new IllegalArgumentException("Unsupported unit: " + unit);
    }
  }

  private double toBaseValue(double sourceValue, U sourceUnit) {
    return sourceValue * sourceUnit.getBaseUnitFactor();
  }

  private void convertBaseValueToTargetUnit(double baseValue, U targetUnit) {
    convertedValues.put(targetUnit, baseValue / targetUnit.getBaseUnitFactor());
  }
}
