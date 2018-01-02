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

import static com.ivanvinski.kunvertuh.measurement.Length.CENTIMETER;
import static com.ivanvinski.kunvertuh.measurement.Length.DECIMETER;
import static com.ivanvinski.kunvertuh.measurement.Length.FOOT;
import static com.ivanvinski.kunvertuh.measurement.Length.INCH;
import static com.ivanvinski.kunvertuh.measurement.Length.KILOMETER;
import static com.ivanvinski.kunvertuh.measurement.Length.METER;
import static com.ivanvinski.kunvertuh.measurement.Length.MILE;
import static com.ivanvinski.kunvertuh.measurement.Length.MILLIMETER;
import static com.ivanvinski.kunvertuh.measurement.Length.UK_LEAGUE;
import static com.ivanvinski.kunvertuh.measurement.Length.US_LEAGUE;
import static com.ivanvinski.kunvertuh.measurement.Length.YARD;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class LengthConverterTest {

  private UnitConverter<Length> converter = new UnitConverter<>(Length.values());

  @Before
  public void setUp() {
    converter.convert(1d, METER);
  }

  @Test
  public void convertsMetersToMillimeters() {
    assertEquals(1000d, converter.getValue(MILLIMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsMetersToCentimeters() {
    assertEquals(100d, converter.getValue(CENTIMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsMetersToDecimeters() {
    assertEquals(10d, converter.getValue(DECIMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsMetersToMeters() {
    assertEquals(1d, converter.getValue(METER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsMetersToKilometers() {
    assertEquals(.001d, converter.getValue(KILOMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsMetersToInches() {
    assertEquals(39.37008d, converter.getValue(INCH), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersToFeet() {
    assertEquals(3.28084d, converter.getValue(FOOT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersToYards() {
    assertEquals(1.093613d, converter.getValue(YARD), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersToMiles() {
    assertEquals(.0006213710245d, converter.getValue(MILE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersToUKLeagues() {
    assertEquals(.000207d, converter.getValue(UK_LEAGUE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsMetersToUSLeagues() {
    assertEquals(.0002071233d, converter.getValue(US_LEAGUE), DoublePrecision.TWO_DECIMAL);
  }
}
