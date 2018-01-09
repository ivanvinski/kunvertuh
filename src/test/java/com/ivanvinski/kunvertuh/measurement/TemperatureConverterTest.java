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

import static com.ivanvinski.kunvertuh.measurement.Temperature.CELSIUS;
import static com.ivanvinski.kunvertuh.measurement.Temperature.FAHRENHEIT;
import static com.ivanvinski.kunvertuh.measurement.Temperature.KELVIN;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class TemperatureConverterTest {

  private TemperatureConverter converter = new TemperatureConverter();

  @Before
  public void setUp() {
    converter.convert(1d, CELSIUS);
  }

  @Test
  public void convertsCelsiusToCelsius() {
    assertEquals(1d, converter.getValue(CELSIUS), DoublePrecision.STRICT);
  }

  @Test
  public void convertsCelsiusToFahrenheit() {
    assertEquals(33.8d, converter.getValue(FAHRENHEIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsCelisusToKelvin() {
    assertEquals(274.15d, converter.getValue(KELVIN), DoublePrecision.STRICT);
  }
}
