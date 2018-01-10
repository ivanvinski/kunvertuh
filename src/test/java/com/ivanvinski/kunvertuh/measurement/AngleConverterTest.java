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

import static com.ivanvinski.kunvertuh.measurement.Angle.DEGREE;
import static com.ivanvinski.kunvertuh.measurement.Angle.GRADIAN;
import static com.ivanvinski.kunvertuh.measurement.Angle.MILLIRADIAN;
import static com.ivanvinski.kunvertuh.measurement.Angle.MINUTE_OF_ARC;
import static com.ivanvinski.kunvertuh.measurement.Angle.RADIAN;
import static com.ivanvinski.kunvertuh.measurement.Angle.SECOND_OF_ARC;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class AngleConverterTest {

  private UnitConverter<Angle> converter = new UnitConverter<>(Angle.values());

  @Before
  public void setUp() {
    converter.convert(90d, DEGREE);
  }

  @Test
  public void convertsDegreesToDegrees() {
    assertEquals(90d, converter.getValue(DEGREE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDegreesToMinutes() {
    assertEquals(5400d, converter.getValue(MINUTE_OF_ARC), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDegreesToSeconds() {
    assertEquals(324000d, converter.getValue(SECOND_OF_ARC), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDegreesToRadians() {
    assertEquals(1.5708d, converter.getValue(RADIAN), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsDegreesToMilliradians() {
    assertEquals(1570.796d, converter.getValue(MILLIRADIAN), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsDegreesToGradians() {
    assertEquals(100d, converter.getValue(GRADIAN), DoublePrecision.STRICT);
  }
}
