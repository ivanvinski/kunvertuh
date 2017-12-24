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

package com.ivanvinski.kunvertuh.measurement;

import static com.ivanvinski.kunvertuh.measurement.Mass.DEKAGRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.DRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.GRAIN;
import static com.ivanvinski.kunvertuh.measurement.Mass.GRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.KILOGRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.METRIC_TON;
import static com.ivanvinski.kunvertuh.measurement.Mass.MILLIGRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.OUNCE;
import static com.ivanvinski.kunvertuh.measurement.Mass.POUND;
import static com.ivanvinski.kunvertuh.measurement.Mass.UK_TON;
import static com.ivanvinski.kunvertuh.measurement.Mass.US_TON;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class MassConverterTest {

  private UnitConverter<Mass> converter = new UnitConverter<>(Mass.values());

  @Before
  public void setUp() {
    converter.convert(1d, KILOGRAM);
  }

  @Test
  public void convertsKilogramsToMilligrams() {
    assertEquals(1000000d, converter.getValue(MILLIGRAM), DoublePrecision.STRICT);
  }

  @Test
  public void convertsKilogramsToGrams() {
    assertEquals(1000d, converter.getValue(GRAM), DoublePrecision.STRICT);
  }

  @Test
  public void convertsKilogramsToDekagrams() {
    assertEquals(100d, converter.getValue(DEKAGRAM), DoublePrecision.STRICT);
  }

  @Test
  public void convertsKilogramsToKilograms() {
    assertEquals(1d, converter.getValue(KILOGRAM), DoublePrecision.STRICT);
  }

  @Test
  public void convertsKilogramsToTons() {
    assertEquals(.001d, converter.getValue(METRIC_TON), DoublePrecision.STRICT);
  }

  @Test
  public void convertsKilogramsToGrains() {
    assertEquals(15432.358d, converter.getValue(GRAIN), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsKilogramsToDrams() {
    assertEquals(564.383448d, converter.getValue(DRAM), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsKilogramsToOunces() {
    assertEquals(35.273965512d, converter.getValue(OUNCE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsKilogramsToPounds() {
    assertEquals(2.204622844494d, converter.getValue(POUND), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsKilogramsToUKTons() {
    assertEquals(.000984203632685596d, converter.getValue(UK_TON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsKilogramsToUSTons() {
    assertEquals(.0011023111063236273d, converter.getValue(US_TON), DoublePrecision.TWO_DECIMAL);
  }
}
