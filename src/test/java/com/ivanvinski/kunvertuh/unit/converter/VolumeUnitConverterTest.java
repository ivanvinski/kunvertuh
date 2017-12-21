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
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.LITER;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VolumeUnitConverterTest {

  private final VolumeUnitConverter unitConverter = new VolumeUnitConverter();
  private final double sourceVolume = 1d;

  @Test
  public void convertsLitersToMilliliters() {
    assertEquals(1000d, unitConverter.toMilliliter(sourceVolume, LITER), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToLiters() {
    assertEquals(sourceVolume, unitConverter.toLiter(sourceVolume, LITER), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToCubicMeters() {
    assertEquals(0.001d, unitConverter.toCubicMeter(sourceVolume, LITER), METRIC_DELTA);
  }

  @Test
  public void convertsLitersToFluidOunces() {
    assertEquals(35.195d, unitConverter.toUKFluidOunce(sourceVolume, LITER), IMPERIAL_DELTA);
  }

  @Test
  public void convertsLitersToPints() {
    assertEquals(1.760d, unitConverter.toPint(sourceVolume, LITER), IMPERIAL_DELTA);
  }

  @Test
  public void convertsLitersToGallons() {
    assertEquals(0.220d, unitConverter.toUKGallon(sourceVolume, LITER), IMPERIAL_DELTA);
  }
}
