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
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.LITER;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VolumeUnitsModelTest {

  private final VolumeUnitsModel model = new VolumeUnitsModel();
  private final Double sourceVolume = 10430d;

  @Before
  public void setUp() {
    model.convert(sourceVolume, LITER);
  }

  @Test
  public void nullSourceVolumeConversionReturnsNull() {
    model.convert(null, LITER);
    assertEquals(null, model.getLiters());
  }

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    model.convert(sourceVolume, null);
  }

  @Test
  public void convertsToMilliliters() {
    assertEquals(10430000d, model.getMilliliters(), METRIC_DELTA);
  }

  @Test
  public void convertsToLiters() {
    assertEquals(10430d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void convertsToCubicMeters() {
    assertEquals(10.43d, model.getCubicMeters(), METRIC_DELTA);
  }

  @Test
  public void convertsToFluidOunces() {
    assertEquals(367084.197d, model.getFluidOunces(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToPints() {
    assertEquals(18354.236d, model.getPints(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsToGallons() {
    assertEquals(2294.279d, model.getGallons(), IMPERIAL_DELTA);
  }
}
