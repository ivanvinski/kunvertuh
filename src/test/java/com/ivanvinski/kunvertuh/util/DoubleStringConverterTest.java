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

package com.ivanvinski.kunvertuh.util;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.junit.Test;

public class DoubleStringConverterTest {

  private NumberFormat valueFormat = new DecimalFormat("#0.00");
  private DoubleStringConverter converter = new DoubleStringConverter(valueFormat);

  @Test(expected = NullPointerException.class)
  public void nullNumberFormatInstantiationThrowsException() {
    new DoubleStringConverter(null);
  }

  @Test
  public void formattingNullBigDecimalReturnsEmptyString() {
    assertEquals("", converter.format(null));
  }

  @Test
  public void formattingNonNullBigDecimalReturnsFormattedString() {
    assertEquals("150.12", converter.format(150.125d));
  }

  @Test
  public void parsingNullStringReturnsNull() {
    assertEquals(null, converter.parse(null));
  }

  @Test
  public void parsingInvalidNumberReturnsNull() {
    assertEquals(null, converter.parse("a123.d5"));
  }

  @Test
  public void parsingValidNumberReturnsBigDecimal() {
    assertEquals(150.125d, converter.parse("150.125"), 0d);
  }
}
