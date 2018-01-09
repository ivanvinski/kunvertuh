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

import static com.ivanvinski.kunvertuh.measurement.Time.CENTURY;
import static com.ivanvinski.kunvertuh.measurement.Time.DAY;
import static com.ivanvinski.kunvertuh.measurement.Time.DECADE;
import static com.ivanvinski.kunvertuh.measurement.Time.HOUR;
import static com.ivanvinski.kunvertuh.measurement.Time.MICROSECOND;
import static com.ivanvinski.kunvertuh.measurement.Time.MILLISECOND;
import static com.ivanvinski.kunvertuh.measurement.Time.MINUTE;
import static com.ivanvinski.kunvertuh.measurement.Time.MONTH;
import static com.ivanvinski.kunvertuh.measurement.Time.NANOSECOND;
import static com.ivanvinski.kunvertuh.measurement.Time.SECOND;
import static com.ivanvinski.kunvertuh.measurement.Time.WEEK;
import static com.ivanvinski.kunvertuh.measurement.Time.YEAR;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.DoublePrecision;
import org.junit.Before;
import org.junit.Test;

public class TimeConverterTest {

  private UnitConverter<Time> converter = new UnitConverter<>(Time.values());

  @Before
  public void setUp() {
    converter.convert(1d, DAY);
  }

  @Test
  public void convertsDaysToNanoseconds() {
    assertEquals(86400000000000d, converter.getValue(NANOSECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToMicroseconds() {
    assertEquals(86400000000d, converter.getValue(MICROSECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToMilliseconds() {
    assertEquals(86400000d, converter.getValue(MILLISECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToSeconds() {
    assertEquals(86400d, converter.getValue(SECOND), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToMinutes() {
    assertEquals(1440d, converter.getValue(MINUTE), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToHours() {
    assertEquals(24d, converter.getValue(HOUR), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToDays() {
    assertEquals(1d, converter.getValue(DAY), DoublePrecision.STRICT);
  }

  @Test
  public void convertsDaysToWeeks() {
    assertEquals(.142857d, converter.getValue(WEEK), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsDaysToMonths() {
    assertEquals(.0328767d, converter.getValue(MONTH), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsDaysToYears() {
    assertEquals(.00273973d, converter.getValue(YEAR), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsDaysToDecades() {
    assertEquals(.000273973d, converter.getValue(DECADE), DoublePrecision.TWO_DECIMAL);
  }

  @Test
  public void convertsDaysToCenturies() {
    assertEquals(.000027397d, converter.getValue(CENTURY), DoublePrecision.TWO_DECIMAL);
  }
}
