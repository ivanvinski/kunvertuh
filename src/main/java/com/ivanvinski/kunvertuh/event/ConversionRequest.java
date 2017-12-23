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

package com.ivanvinski.kunvertuh.event;

import com.ivanvinski.kunvertuh.measurement.Unit;

public final class ConversionRequest {

  private String value;
  private Unit unit;
  private Class<? extends Unit> unitType;

  public <U extends Unit> ConversionRequest(String value, U unit) {
    this.value = value;
    this.unit = unit;
    unitType = unit.getClass();
  }

  public String getValue() {
    return value;
  }

  public Unit getUnit() {
    return unit;
  }

  public Class<? extends Unit> getUnitType() {
    return unitType;
  }
}
