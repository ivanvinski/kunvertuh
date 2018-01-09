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

import static com.ivanvinski.kunvertuh.measurement.Speed.FOOT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.Speed.KILOMETER_PER_HOUR;
import static com.ivanvinski.kunvertuh.measurement.Speed.KNOT;
import static com.ivanvinski.kunvertuh.measurement.Speed.METER_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.Speed.MILE_PER_HOUR;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class SpeedConverterTest {

  private UnitConverter<Speed> converter = new UnitConverter<>(Speed.values());

  @Before
  public void setUp() {
    converter.convert(1d, METER_PER_SECOND);
  }

  @Test
  public void convertsMetersPerSecondToMetersPerSecond() {
    assertEquals(1d, converter.getValue(METER_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsMetersPerSecondToKilometersPerHour() {
    assertEquals(3.6d, converter.getValue(KILOMETER_PER_HOUR), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersPerSecondToFeetPerSecond() {
    assertEquals(3.28084d, converter.getValue(FOOT_PER_SECOND), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersPerSecondToMilesPerHour() {
    assertEquals(2.23694d, converter.getValue(MILE_PER_HOUR), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersPerSecondToKnots() {
    assertEquals(1.94384d, converter.getValue(KNOT), DoublePrecision.TWO_DECIMAL);
  }
}
