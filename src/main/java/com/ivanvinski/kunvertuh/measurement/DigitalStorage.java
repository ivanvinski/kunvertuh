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

  BIT(1d, "bit", UnitCategory.BIT),
  KILOBIT(1000d, "kbit", UnitCategory.BIT),
  MEGABIT(1000000d, "Mbit", UnitCategory.BIT),
  GIGABIT(1000000000d, "Gbit", UnitCategory.BIT),
  TERABIT(10000000000000d, "Tbit", UnitCategory.BIT),
  PETABIT(10000000000000000d, "Pbit", UnitCategory.BIT),

  BYTE(8d, "B", UnitCategory.BYTE),
  KILOBYTE(8000d, "kB", UnitCategory.BYTE),
  MEGABYTE(8000000d, "MB", UnitCategory.BYTE),
  GIGABYTE(8000000000d, "GB", UnitCategory.BYTE),
  TERABYTE(8000000000000d, "TB", UnitCategory.BYTE),
  PETABYTE(8000000000000000d, "PB", UnitCategory.BYTE),

  KIBIBIT(1024, "Kibit", UnitCategory.BI_BIT),
  MEBIBIT(1049000d, "Mibit", UnitCategory.BI_BIT),
  GIBIBIT(1074000000d, "Gibit", UnitCategory.BI_BIT),
  TEBIBIT(1100000000000d, "Tibit", UnitCategory.BI_BIT),
  PEBIBIT(1126000000000000d, "Pibit", UnitCategory.BI_BIT),

  KIBIBYTE(8192d, "KiB", UnitCategory.BI_BYTE),
  MEBIBYTE(8389000d, "MiB", UnitCategory.BI_BYTE),
  GIBIBYTE(8590000000d, "GiB", UnitCategory.BI_BYTE),
  TEBIBYTE(8796000000000d, "TiB", UnitCategory.BI_BYTE),
  PEBIBYTE(9007000000000000d, "PiB", UnitCategory.BI_BYTE);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  DigitalStorage(double baseUnitFactor, String symbol, UnitCategory category) {
    this.baseUnitFactor = baseUnitFactor;
    this.symbol = symbol;
    this.category = category;
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
  public UnitCategory getCategory() {
    return category;
  }
}
