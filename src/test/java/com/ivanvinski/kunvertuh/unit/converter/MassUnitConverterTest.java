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

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static com.ivanvinski.kunvertuh.unit.MassUnit.GRAMS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MassUnitConverterTest {

  private final MassUnitConverter unitConverter = new MassUnitConverter();
  private final double sourceMass = 1d;

  @Test
  public void convertsGramsToMilligrams() {
    assertEquals(1000d, unitConverter.toMilligrams(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToGrams() {
    assertEquals(sourceMass, unitConverter.toGrams(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToDekagrams() {
    assertEquals(.1d, unitConverter.toDekagrams(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToKilograms() {
    assertEquals(.001d, unitConverter.toKilograms(sourceMass, GRAMS), METRIC_DELTA);
  }

  @Test
  public void convertsGramsToGrains() {
    assertEquals(15.432d, unitConverter.toGrains(sourceMass, GRAMS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToDrams() {
    assertEquals(.564d, unitConverter.toDrams(sourceMass, GRAMS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToOunces() {
    assertEquals(0.035d, unitConverter.toOunces(sourceMass, GRAMS), IMPERIAL_DELTA);
  }

  @Test
  public void convertsGramsToPounds() {
    assertEquals(0.002d, unitConverter.toPounds(sourceMass, GRAMS), IMPERIAL_DELTA);
  }
}
