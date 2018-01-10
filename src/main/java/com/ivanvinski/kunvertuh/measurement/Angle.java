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

public enum Angle implements Unit {

  DEGREE(1d, "°"),
  MINUTE_OF_ARC(1d / 60d, "'"),
  SECOND_OF_ARC(1d / 3600d, "''"),
  RADIAN(57.2958d, "rad"),
  MILLIRADIAN(.05729578d, "mil"),
  GRADIAN(.9d, "gon");

  private double baseUnitFactor;
  private String symbol;

  Angle(double baseUnitFactor, String symbol) {
    this.baseUnitFactor = baseUnitFactor;
    this.symbol = symbol;
  }

  @Override
  public double getBaseUnitFactor() {
    return baseUnitFactor;
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  @Override
  public MeasurementSystem getSystem() {
    return null;
  }
}