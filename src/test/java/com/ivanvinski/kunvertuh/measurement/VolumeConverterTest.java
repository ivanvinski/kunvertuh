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

import static com.ivanvinski.kunvertuh.measurement.Volume.CUBIC_INCH;
import static com.ivanvinski.kunvertuh.measurement.Volume.CUBIC_METER;
import static com.ivanvinski.kunvertuh.measurement.Volume.DECILITER;
import static com.ivanvinski.kunvertuh.measurement.Volume.HECTOLITER;
import static com.ivanvinski.kunvertuh.measurement.Volume.LITER;
import static com.ivanvinski.kunvertuh.measurement.Volume.MILLILITER;
import static com.ivanvinski.kunvertuh.measurement.Volume.UK_CUP;
import static com.ivanvinski.kunvertuh.measurement.Volume.UK_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.measurement.Volume.UK_GALLON;
import static com.ivanvinski.kunvertuh.measurement.Volume.UK_PINT;
import static com.ivanvinski.kunvertuh.measurement.Volume.UK_TABLESPOON;
import static com.ivanvinski.kunvertuh.measurement.Volume.UK_TEASPOON;
import static com.ivanvinski.kunvertuh.measurement.Volume.US_CUP;
import static com.ivanvinski.kunvertuh.measurement.Volume.US_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.measurement.Volume.US_GALLON;
import static com.ivanvinski.kunvertuh.measurement.Volume.US_PINT;
import static com.ivanvinski.kunvertuh.measurement.Volume.US_TABLESPOON;
import static com.ivanvinski.kunvertuh.measurement.Volume.US_TEASPOON;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class VolumeConverterTest {

  private UnitConverter<Volume> converter = new UnitConverter<>(Volume.values());

  @Before
  public void setUp() {
    converter.convert(1d, LITER);
  }

  @Test
  public void convertsLitersToMilliliters() {
    assertEquals(1000d, converter.getValue(MILLILITER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsLitersToDeciliters() {
    assertEquals(10d, converter.getValue(DECILITER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsLitersToLiters() {
    assertEquals(1d, converter.getValue(LITER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsLitersToHectoliters() {
    assertEquals(.01d, converter.getValue(HECTOLITER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsLitersToCubicMeters() {
    assertEquals(.001d, converter.getValue(CUBIC_METER), DoublePrecision.STRICT);
  }

  @Test
  public void convertsLitersToUKTeaspoons() {
    assertEquals(168.936d, converter.getValue(UK_TEASPOON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUKTablespoons() {
    assertEquals(56.3121d, converter.getValue(UK_TABLESPOON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUKCups() {
    assertEquals(3.52d, converter.getValue(UK_CUP), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUKFluidOunces() {
    assertEquals(35.1951d, converter.getValue(UK_FLUID_OUNCE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUKPints() {
    assertEquals(1.75975d, converter.getValue(UK_PINT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUKGallons() {
    assertEquals(0.219969d, converter.getValue(UK_GALLON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUSTeaspoons() {
    assertEquals(202.884d, converter.getValue(US_TEASPOON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUSTablespoons() {
    assertEquals(67.628d, converter.getValue(US_TABLESPOON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUSCups() {
    assertEquals(4.166667, converter.getValue(US_CUP), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUSFluidOunces() {
    assertEquals(33.814d, converter.getValue(US_FLUID_OUNCE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUSPints() {
    assertEquals(2.11338, converter.getValue(US_PINT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToUSGallons() {
    assertEquals(0.264172d, converter.getValue(US_GALLON), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsLitersToCubicInches() {
    assertEquals(61.0237d, converter.getValue(CUBIC_INCH), DoublePrecision.TWO_DECIMAL);
  }
}
