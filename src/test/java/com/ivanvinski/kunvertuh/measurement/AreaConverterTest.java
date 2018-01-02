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

import static com.ivanvinski.kunvertuh.measurement.Area.ACRE;
import static com.ivanvinski.kunvertuh.measurement.Area.HECTARE;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_CENTIMETER;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_FOOT;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_INCH;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_KILOMETER;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_METER;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_MILE;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_MILLIMETER;
import static com.ivanvinski.kunvertuh.measurement.Area.SQUARE_YARD;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class AreaConverterTest {

  private UnitConverter<Area> converter = new UnitConverter<>(Area.values());

  @Before
  public void setUp() {
    converter.convert(1d, SQUARE_METER);
  }

  @Test
  public void convertsSquareMetersToSquareMillimeters() {
    assertEquals(1000000d, converter.getValue(SQUARE_MILLIMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsSquareMetersToSquareCentimeters() {
    assertEquals(10000d, converter.getValue(SQUARE_CENTIMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsSquareMetersToSquareMeters() {
    assertEquals(1d, converter.getValue(SQUARE_METER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsSquareMetersToHectares() {
    assertEquals(.0001d, converter.getValue(HECTARE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsSquareMetersToSquareKilometers() {
    assertEquals(.000001d, converter.getValue(SQUARE_KILOMETER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsSquareMetersToSquareInches() {
    assertEquals(1550.003d, converter.getValue(SQUARE_INCH), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsSquareMetersToSquareFeet() {
    assertEquals(10.7639d, converter.getValue(SQUARE_FOOT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsSquareMetersToSquareYards() {
    assertEquals(1.19599d, converter.getValue(SQUARE_YARD), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsSquareMetersToAcres() {
    assertEquals(.000247105d, converter.getValue(ACRE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsSquareMetersToSquareMiles() {
    assertEquals(.000000386102d, converter.getValue(SQUARE_MILE), DoublePrecision.TWO_DECIMAL);
  }
}
