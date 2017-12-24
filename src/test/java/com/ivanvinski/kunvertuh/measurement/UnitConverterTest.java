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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UnitConverterTest {

  private Unit baseImaginaryUnit, imaginaryUnit;
  private UnitConverter<Unit> imaginaryConverter;

  @Before
  public void setUp() {
    baseImaginaryUnit = Mockito.mock(Unit.class);
    Mockito.when(baseImaginaryUnit.getBaseUnitFactor()).thenReturn(1d);
    imaginaryUnit = Mockito.mock(Unit.class);
    Mockito.when(imaginaryUnit.getBaseUnitFactor()).thenReturn(100d);
    imaginaryConverter = new UnitConverter<>(baseImaginaryUnit, imaginaryUnit);
  }

  @Test
  public void supportedUnitsIgnoresNullUnits() {
    Unit[] expectedSupportedUnits = new Unit[]{baseImaginaryUnit, imaginaryUnit};
    UnitConverter<Unit> converter = new UnitConverter<>(baseImaginaryUnit, imaginaryUnit, null);

    Collection<Unit> supportedUnits = converter.getSupportedUnits();
    Unit[] actualSupportedUnits = supportedUnits.toArray(new Unit[supportedUnits.size()]);

    assertArrayEquals(expectedSupportedUnits, actualSupportedUnits);
  }

  @Test(expected = NullPointerException.class)
  public void conversionWithNullUnitThrowsException() {
    imaginaryConverter.convert(0d, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void conversionWithUnsupportedUnitThrowsException() {
    imaginaryConverter.convert(0d, Mockito.mock(Unit.class));
  }

  @Test
  public void conversionFromBaseUnitToAnotherUnitCalculatesCorrectResult() {
    imaginaryConverter.convert(1d, baseImaginaryUnit);
    assertEquals(.01d, imaginaryConverter.getValue(imaginaryUnit), 0d);
  }

  @Test
  public void conversionFromAnotherUnitToBaseUnitCalculatesCorrectResult() {
    imaginaryConverter.convert(1d, imaginaryUnit);
    assertEquals(100d, imaginaryConverter.getValue(baseImaginaryUnit), 0d);
  }

  @Test
  public void conversionCalculatesAllSupportedUnits() {
    imaginaryConverter.convert(500d, baseImaginaryUnit);
    assertEquals(500d, imaginaryConverter.getValue(baseImaginaryUnit), 0d);
    assertEquals(5d, imaginaryConverter.getValue(imaginaryUnit), 0d);
  }
}
