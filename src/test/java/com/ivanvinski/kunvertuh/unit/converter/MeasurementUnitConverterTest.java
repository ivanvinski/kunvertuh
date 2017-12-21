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

package com.ivanvinski.kunvertuh.unit.converter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.unit.MeasurementUnit;
import org.junit.Test;

public class MeasurementUnitConverterTest {

  private final MeasurementUnitConverter unitConverter = new MeasurementUnitConverter();
  private final MeasurementUnit unit = new MeasurementUnit("", 0d);

  @Test
  public void nullSourceValueConversionReturnsNull() {
    assertEquals(null, unitConverter.convert(null, unit, unit));
  }

  @Test(expected = NullPointerException.class)
  public void nullSourceUnitConversionThrowsException() {
    unitConverter.convert(0d, null, unit);
  }

  @Test(expected = NullPointerException.class)
  public void nullOutputUnitConversionThrowsException() {
    unitConverter.convert(0d, unit, null);
  }
}
