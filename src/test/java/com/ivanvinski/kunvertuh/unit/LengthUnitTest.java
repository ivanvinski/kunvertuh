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

public class LengthUnitTest {

  @Test
  public void validateMillimetersAbbreviation() {
    assertEquals("mm", LengthUnit.MILLIMETERS.getAbbreviation());
  }

  @Test
  public void validateCentimetersAbbreviation() {
    assertEquals("cm", LengthUnit.CENTIMETERS.getAbbreviation());
  }

  @Test
  public void validateDecimetersAbbreviation() {
    assertEquals("dm", LengthUnit.DECIMETERS.getAbbreviation());
  }

  @Test
  public void validateMetersAbbreviation() {
    assertEquals("m", LengthUnit.METERS.getAbbreviation());
  }

  @Test
  public void validateKilometersAbbreviation() {
    assertEquals("km", LengthUnit.KILOMETERS.getAbbreviation());
  }

  @Test
  public void validateInchesAbbreviation() {
    assertEquals("in", LengthUnit.INCHES.getAbbreviation());
  }

  @Test
  public void validateFeetAbbreviation() {
    assertEquals("ft", LengthUnit.FEET.getAbbreviation());
  }

  @Test
  public void validateYardsAbbreviation() {
    assertEquals("yd", LengthUnit.YARDS.getAbbreviation());
  }

  @Test
  public void validateMilesAbbreviation() {
    assertEquals("mi", LengthUnit.MILES.getAbbreviation());
  }
}
