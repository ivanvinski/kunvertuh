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
import static com.ivanvinski.kunvertuh.unit.LengthUnit.METER;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LengthUnitConverterTest {

  private final LengthUnitConverter unitConverter = new LengthUnitConverter();
  private final double sourceLength = 1d;

  @Test
  public void convertsMetersToMillimeters() {
    assertEquals(1000d, unitConverter.toMillimeter(sourceLength, METER), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToCentimeters() {
    assertEquals(100d, unitConverter.toCentimeter(sourceLength, METER), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToDecimeters() {
    assertEquals(10d, unitConverter.toDecimeter(sourceLength, METER), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToMeters() {
    assertEquals(sourceLength, unitConverter.toMeter(sourceLength, METER), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToKilometers() {
    assertEquals(.001d, unitConverter.toKilometer(sourceLength, METER), METRIC_DELTA);
  }

  @Test
  public void convertsMetersToInches() {
    assertEquals(39.370d, unitConverter.toInch(sourceLength, METER), IMPERIAL_DELTA);
  }

  @Test
  public void convertsMetersToFeet() {
    assertEquals(3.281d, unitConverter.toFoot(sourceLength, METER), IMPERIAL_DELTA);
  }

  @Test
  public void convertsMetersToYards() {
    assertEquals(1.094d, unitConverter.toYard(sourceLength, METER), IMPERIAL_DELTA);
  }

  @Test
  public void convertsMetersToMiles() {
    assertEquals(.0006d, unitConverter.toMile(sourceLength, METER), IMPERIAL_DELTA);
  }
}
