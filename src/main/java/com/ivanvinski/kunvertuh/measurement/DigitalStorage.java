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

public enum DigitalStorage implements Unit {

  BIT(1d, "bit"),
  KILOBIT(1000d, "kbit"),
  KIBIBIT(1024, "Kibit"),
  MEGABIT(1000000d, "Mbit"),
  MEBIBIT(1049000d, "Mibit"),
  GIGABIT(1000000000d, "Gbit"),
  GIBIBIT(1074000000d, "Gibit"),
  TERABIT(10000000000000d, "Tbit"),
  TEBIBIT(1100000000000d, "Tibit"),
  PETABIT(10000000000000000d, "Pbit"),
  PEBIBIT(1126000000000000d, "Pibit"),

  BYTE(8d, "B"),
  KILOBYTE(8000d, "kB"),
  KIBIBYTE(8192d, "KiB"),
  MEGABYTE(8000000d, "MB"),
  MEBIBYTE(8389000d, "MiB"),
  GIGABYTE(8000000000d, "GB"),
  GIBIBYTE(8590000000d, "GiB"),
  TERABYTE(8000000000000d, "TB"),
  TEBIBYTE(8796000000000d, "TiB"),
  PETABYTE(8000000000000000d, "PB"),
  PEBIBYTE(9007000000000000d, "PiB");

  private double baseUnitFactor;
  private String symbol;

  DigitalStorage(double baseUnitFactor, String symbol) {
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
