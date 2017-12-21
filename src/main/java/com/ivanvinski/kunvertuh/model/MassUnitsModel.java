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

import com.ivanvinski.kunvertuh.unit.MassUnit;
import com.ivanvinski.kunvertuh.unit.converter.MassUnitConverter;

public class MassUnitsModel implements UnitsModel<MassUnit> {

  private MassUnitConverter unitConverter = new MassUnitConverter();
  private Double milligrams, grams, dekagrams, kilograms;
  private Double grains, drams, ounces, pounds;

  @Override
  public void convert(Double sourceMass, MassUnit sourceUnit) {
    milligrams = getUnitConverter().toMilligram(sourceMass, sourceUnit);
    grams = getUnitConverter().toGram(sourceMass, sourceUnit);
    dekagrams = getUnitConverter().toDekagram(sourceMass, sourceUnit);
    kilograms = getUnitConverter().toKilogram(sourceMass, sourceUnit);
    grains = getUnitConverter().toGrain(sourceMass, sourceUnit);
    drams = getUnitConverter().toDram(sourceMass, sourceUnit);
    ounces = getUnitConverter().toOunce(sourceMass, sourceUnit);
    pounds = getUnitConverter().toPound(sourceMass, sourceUnit);
  }

  @Override
  public MassUnitConverter getUnitConverter() {
    return unitConverter;
  }

  public Double getMilligrams() {
    return milligrams;
  }

  public Double getGrams() {
    return grams;
  }

  public Double getDekagrams() {
    return dekagrams;
  }

  public Double getKilograms() {
    return kilograms;
  }

  public Double getGrains() {
    return grains;
  }

  public Double getDrams() {
    return drams;
  }

  public Double getOunces() {
    return ounces;
  }

  public Double getPounds() {
    return pounds;
  }
}
