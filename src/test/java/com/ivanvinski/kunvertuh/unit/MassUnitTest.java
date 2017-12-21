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

package com.ivanvinski.kunvertuh.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MassUnitTest {

  @Test
  public void validateMilligramsAbbreviation() {
    assertEquals("mg", MassUnit.MILLIGRAM.getAbbreviation());
  }

  @Test
  public void validateGramsAbbreviation() {
    assertEquals("g", MassUnit.GRAM.getAbbreviation());
  }

  @Test
  public void validateDekagramsAbbreviation() {
    assertEquals("dag", MassUnit.DEKAGRAM.getAbbreviation());
  }

  @Test
  public void validateKilogramsAbbreviation() {
    assertEquals("kg", MassUnit.KILOGRAM.getAbbreviation());
  }

  @Test
  public void validateGrainsAbbreviation() {
    assertEquals("gr", MassUnit.GRAIN.getAbbreviation());
  }

  @Test
  public void validateDramsAbbreviation() {
    assertEquals("dr", MassUnit.DRAM.getAbbreviation());
  }

  @Test
  public void validateOuncesAbbreviation() {
    assertEquals("oz", MassUnit.OUNCE.getAbbreviation());
  }

  @Test
  public void validatePoundsAbbreviation() {
    assertEquals("lb", MassUnit.POUND.getAbbreviation());
  }
}
