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

import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.BIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.BYTE_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.GIBIBIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.GIGABIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.GIGABYTE_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.KIBIBIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.KILOBIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.KILOBYTE_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.MEBIBIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.MEGABIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.MEGABYTE_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.TEBIBIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.TERABIT_PER_SECOND;
import static com.ivanvinski.kunvertuh.measurement.DataTransferRate.TERABYTE_PER_SECOND;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class DataTransferRateConverterTest {

  private UnitConverter<DataTransferRate> converter = new UnitConverter<>(
      DataTransferRate.values());

  @Before
  public void setUp() {
    converter.convert(1000d, BIT_PER_SECOND);
  }

  @Test
  public void convertsBitsPerSecondToBitsPerSecond() {
    assertEquals(1000d, converter.getValue(BIT_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToKilobitsPerSecond() {
    assertEquals(1d, converter.getValue(KILOBIT_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToMegabitsPerSecond() {
    assertEquals(.001d, converter.getValue(MEGABIT_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToGigabitsPerSecond() {
    assertEquals(.000001d, converter.getValue(GIGABIT_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToTerabitsPerSecond() {
    assertEquals(.000000001d, converter.getValue(TERABIT_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToBytesPerSecond() {
    assertEquals(125, converter.getValue(BYTE_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToKilobytesPerSecond() {
    assertEquals(.125d, converter.getValue(KILOBYTE_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToMegabytesPerSecond() {
    assertEquals(.000125d, converter.getValue(MEGABYTE_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToGigabytesPerSecond() {
    assertEquals(.000000125, converter.getValue(GIGABYTE_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToTerabytesPerSecond() {
    assertEquals(.000000000125, converter.getValue(TERABYTE_PER_SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsBitsPerSecondToKibibitsPerSecond() {
    assertEquals(.976563d, converter.getValue(KIBIBIT_PER_SECOND), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsPerSecondToMebibitsPerSecond() {
    assertEquals(.0009536748046875d, converter.getValue(MEBIBIT_PER_SECOND),
        DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsPerSecondToGibibitsPerSecond() {
    assertEquals(.0000009313230514526366795d, converter.getValue(GIBIBIT_PER_SECOND),
        DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsBitsPerSecondToTebibitsPerSecond() {
    assertEquals(.0000000009094951674342155073d, converter.getValue(TEBIBIT_PER_SECOND),
        DoublePrecision.TWO_DECIMAL);
  }
}
