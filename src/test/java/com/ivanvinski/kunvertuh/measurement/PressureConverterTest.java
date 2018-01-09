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

import static com.ivanvinski.kunvertuh.measurement.Pressure.ATMOSPHERE;
import static com.ivanvinski.kunvertuh.measurement.Pressure.BAR;
import static com.ivanvinski.kunvertuh.measurement.Pressure.MILLIMETER_OF_MERCURY;
import static com.ivanvinski.kunvertuh.measurement.Pressure.PASCAL;
import static com.ivanvinski.kunvertuh.measurement.Pressure.POUND_FORCE_PER_SQUARE_INCH;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class PressureConverterTest {

  private UnitConverter<Pressure> converter = new UnitConverter<>(Pressure.values());

  @Before
  public void setUp() {
    converter.convert(100d, PASCAL);
  }

  @Test
  public void convertsPascalsToAtmospheres() {
    assertEquals(.000986923d, converter.getValue(ATMOSPHERE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsPascalsToBars() {
    assertEquals(.001d, converter.getValue(BAR), DoublePrecision.STRICT);
  }

  @Test
  public void convertsPascalsToPascals() {
    assertEquals(100d, converter.getValue(PASCAL), DoublePrecision.STRICT);
  }

  @Test
  public void convertsPascalsToPoundForcesPerSquareInch() {
    assertEquals(.0145038d, converter.getValue(POUND_FORCE_PER_SQUARE_INCH),
        DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsPascalsToMillimetersOfMercury() {
    assertEquals(.750062d, converter.getValue(MILLIMETER_OF_MERCURY), DoublePrecision.TWO_DECIMAL);
  }
}
