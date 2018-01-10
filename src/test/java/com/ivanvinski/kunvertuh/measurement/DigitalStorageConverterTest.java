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

import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.BIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.BYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.GIBIBIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.GIBIBYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.GIGABIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.GIGABYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.KIBIBIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.KIBIBYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.KILOBIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.KILOBYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.MEBIBIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.MEBIBYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.MEGABIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.MEGABYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.PEBIBIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.PEBIBYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.PETABIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.PETABYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.TEBIBIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.TEBIBYTE;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.TERABIT;
import static com.ivanvinski.kunvertuh.measurement.DigitalStorage.TERABYTE;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class DigitalStorageConverterTest {

  private UnitConverter<DigitalStorage> converter = new UnitConverter<>(DigitalStorage.values());

  @Before
  public void setUp() {
    converter.convert(10430d, BIT);
  }

  @Test
  public void convertsBitsToBits() {
    assertEquals(10430d, converter.getValue(BIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToKilobits() {
    assertEquals(10.43d, converter.getValue(KILOBIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToKibibits() {
    assertEquals(10.185547d, converter.getValue(KIBIBIT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToMegabits() {
    assertEquals(.01043d, converter.getValue(MEGABIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToMebibits() {
    assertEquals(.0099468231d, converter.getValue(MEBIBIT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToGigabits() {
    assertEquals(.00001043d, converter.getValue(GIGABIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToGibibits() {
    assertEquals(.000009713694d, converter.getValue(GIBIBIT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToTerabits() {
    assertEquals(.000000001043d, converter.getValue(TERABIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToTebibits() {
    assertEquals(.00000000948603d, converter.getValue(TEBIBIT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToPetabits() {
    assertEquals(.000000000001043d, converter.getValue(PETABIT), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToPebibits() {
    assertEquals(.000000000009263701d, converter.getValue(PEBIBIT), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToBytes() {
    assertEquals(1303.75d, converter.getValue(BYTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToKilobytes() {
    assertEquals(1.30375d, converter.getValue(KILOBYTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToKibibytes() {
    assertEquals(1.2731934d, converter.getValue(KIBIBYTE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToMegabytes() {
    assertEquals(.00130375d, converter.getValue(MEGABYTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToMebibytes() {
    assertEquals(.0012433529d, converter.getValue(MEBIBYTE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToGigabytes() {
    assertEquals(.00000130375d, converter.getValue(GIGABYTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToGibibytes() {
    assertEquals(.000001214212d, converter.getValue(GIBIBYTE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToTerabytes() {
    assertEquals(.00000000130375d, converter.getValue(TERABYTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToTebibytes() {
    assertEquals(.000000001185754d, converter.getValue(TEBIBYTE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsToPetabytes() {
    assertEquals(.00000000000130375d, converter.getValue(PETABYTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsToPebibytes() {
    assertEquals(.000000000001157963d, converter.getValue(PEBIBYTE), DoublePrecision.TWO_DECIMAL);
  }
}
