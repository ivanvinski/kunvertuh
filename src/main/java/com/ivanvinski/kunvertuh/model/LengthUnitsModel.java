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

package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import com.ivanvinski.kunvertuh.unit.converter.LengthUnitConverter;

public class LengthUnitsModel implements UnitsModel<LengthUnit> {

  private LengthUnitConverter unitConverter = new LengthUnitConverter();
  private Double millimeters, centimeters, decimeters, meters, kilometers;
  private Double inches, feet, yards, miles;

  @Override
  public void convert(Double sourceLength, LengthUnit sourceUnit) {
    millimeters = getUnitConverter().toMillimeter(sourceLength, sourceUnit);
    centimeters = getUnitConverter().toCentimeter(sourceLength, sourceUnit);
    decimeters = getUnitConverter().toDecimeter(sourceLength, sourceUnit);
    meters = getUnitConverter().toMeter(sourceLength, sourceUnit);
    kilometers = getUnitConverter().toKilometer(sourceLength, sourceUnit);
    inches = getUnitConverter().toInch(sourceLength, sourceUnit);
    feet = getUnitConverter().toFoot(sourceLength, sourceUnit);
    yards = getUnitConverter().toYard(sourceLength, sourceUnit);
    miles = getUnitConverter().toMile(sourceLength, sourceUnit);
  }

  @Override
  public LengthUnitConverter getUnitConverter() {
    return unitConverter;
  }

  public Double getMillimeters() {
    return millimeters;
  }

  public Double getCentimeters() {
    return centimeters;
  }

  public Double getDecimeters() {
    return decimeters;
  }

  public Double getMeters() {
    return meters;
  }

  public Double getKilometers() {
    return kilometers;
  }

  public Double getInches() {
    return inches;
  }

  public Double getFeet() {
    return feet;
  }

  public Double getYards() {
    return yards;
  }

  public Double getMiles() {
    return miles;
  }
}
