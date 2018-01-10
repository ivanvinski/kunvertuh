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

public enum DataTransferRate implements Unit {

  BIT_PER_SECOND(1d, "bit/s"),
  KILOBIT_PER_SECOND(1000d, "Kbit/s"),
  MEGABIT_PER_SECOND(1000000d, "Mbit/s"),
  GIGABIT_PER_SECOND(1000000000d, "Gbit/s"),
  TERABIT_PER_SECOND(1000000000000d, "Tbit/s"),

  BYTE_PER_SECOND(8d, "B/s"),
  KILOBYTE_PER_SECOND(8000d, "KB/s"),
  MEGABYTE_PER_SECOND(8000000d, "MB/s"),
  GIGABYTE_PER_SECOND(8000000000d, "GB/s"),
  TERABYTE_PER_SECOND(8000000000000d, "TB/s"),

  KIBIBIT_PER_SECOND(1024d, "Kibit/s"),
  MEBIBIT_PER_SECOND(1049000d, "Mebit/s"),
  GIBIBIT_PER_SECOND(1074000000d, "Gibit/s"),
  TEBIBIT_PER_SECOND(1100000000000d, "Tebit/s");

  private double baseUnitFactor;
  private String symbol;

  DataTransferRate(double baseUnitFactor, String symbol) {
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
