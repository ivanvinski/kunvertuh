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

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static com.ivanvinski.kunvertuh.unit.MassUnit.GRAM;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MassUnitModelTest {

  private final MassUnitsModel model = new MassUnitsModel();
  private final Double sourceMass = 1998d;

  @Before
  public void setUp() {
    model.convert(sourceMass, GRAM);
  }

  @Test
  public void nullSourceMassConversionReturnsNull() {
    model.convert(null, GRAM);
    assertEquals(null, model.getGrams());
  }

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    model.convert(sourceMass, null);
  }

  @Test
  public void convertsToMilligrams() {
    assertEquals(1998000d, model.getMilligrams(), METRIC_DELTA);
  }

  @Test
  public void convertsToGrams() {
    assertEquals(1998d, model.getGrams(), METRIC_DELTA);
  }

  @Test
  public void convertsToDekagrams() {
    assertEquals(199.8d, model.getDekagrams(), METRIC_DELTA);
  }

  @Test
  public void convertsToKilograms() {
    assertEquals(1.998d, model.getKilograms(), METRIC_DELTA);
  }

  @Test
  public void convertsToGrains() {
    assertEquals(30833.852d, model.getGrains(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToDrams() {
    assertEquals(1127.638d, model.getDrams(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToOunces() {
    assertEquals(70.477d, model.getOunces(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToPounds() {
    assertEquals(4.405d, model.getPounds(), IMPERIAL_DELTA);
  }
}
