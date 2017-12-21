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
import static com.ivanvinski.kunvertuh.unit.LengthUnit.METER;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LengthUnitsModelTest {

  private final LengthUnitsModel model = new LengthUnitsModel();
  private final double sourceLength = 2017d;

  @Before
  public void setUp() {
    model.convert(sourceLength, METER);
  }

  @Test
  public void nullSourceLengthConversionReturnsNull() {
    model.convert(null, METER);
    assertEquals(null, model.getMeters());
  }

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    model.convert(sourceLength, null);
  }

  @Test
  public void convertsToMillimeters() {
    assertEquals(2017000d, model.getMillimeters(), METRIC_DELTA);
  }

  @Test
  public void convertsToCentimeters() {
    assertEquals(201700d, model.getCentimeters(), METRIC_DELTA);
  }

  @Test
  public void convertsToDecimeters() {
    assertEquals(20170d, model.getDecimeters(), METRIC_DELTA);
  }

  @Test
  public void convertsToMeters() {
    assertEquals(2017d, model.getMeters(), METRIC_DELTA);
  }

  @Test
  public void convertsToKilometers() {
    assertEquals(2.017d, model.getKilometers(), METRIC_DELTA);
  }

  @Test
  public void convertsToInches() {
    assertEquals(79409.449d, model.getInches(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToFeet() {
    assertEquals(6617.454d, model.getFeet(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToYards() {
    assertEquals(2205.818d, model.getYards(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToMiles() {
    assertEquals(1.253d, model.getMiles(), IMPERIAL_DELTA);
  }
}
