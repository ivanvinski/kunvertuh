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

public class TemperatureConverter extends UnitConverter<Temperature> {

  public TemperatureConverter() {
    super(Temperature.values());
  }

  @Override
  public void convert(double sourceValue, Temperature sourceUnit) {
    throwExceptionIfNullOrUnsupportedUnit(sourceUnit);
    double celsius = toCelsius(sourceValue, sourceUnit);
    setValue(Temperature.CELSIUS, celsius);
    setValue(Temperature.FAHRENHEIT, (celsius * 9d / 5d) + 32d);
    setValue(Temperature.KELVIN, celsius + 273.15d);
  }

  private double toCelsius(double sourceValue, Temperature sourceUnit) {
    if (sourceUnit == Temperature.CELSIUS) {
      return sourceValue;
    } else if (sourceUnit == Temperature.FAHRENHEIT) {
      return (sourceValue - 32d) * 5d / 9d;
    } else if (sourceUnit == Temperature.KELVIN) {
      return sourceValue - 273.15d;
    } else {
      throw new UnsupportedOperationException("Unsupported temperature unit: " + sourceUnit);
    }
  }
}
