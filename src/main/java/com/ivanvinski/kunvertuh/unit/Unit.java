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

public class Unit {

  private String abbreviation;
  private double baseUnitFactor;

  public Unit(String abbreviation, double baseUnitFactor) {
    this.abbreviation = abbreviation;
    this.baseUnitFactor = baseUnitFactor;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }
}
