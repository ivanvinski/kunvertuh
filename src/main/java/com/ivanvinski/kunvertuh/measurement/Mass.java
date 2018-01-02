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

import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.IMPERIAL;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.IMPERIAL_AND_US_CUSTOMARY;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.METRIC;
import static com.ivanvinski.kunvertuh.measurement.MeasurementSystem.US_CUSTOMARY;

public enum Mass implements Unit {

  MILLIGRAM(.001d, "mg", METRIC),
  GRAM(1d, "g", METRIC),
  DEKAGRAM(10d, "dag", METRIC),
  KILOGRAM(1000d, "kg", METRIC),
  METRIC_TON(1000000d, "t", METRIC),

  GRAIN(.06479891d, "gr", IMPERIAL_AND_US_CUSTOMARY),
  DRAM(1.771845d, "dr", IMPERIAL_AND_US_CUSTOMARY),
  OUNCE(28.34952d, "oz", IMPERIAL_AND_US_CUSTOMARY),
  POUND(453.5924d, "lb", IMPERIAL_AND_US_CUSTOMARY),
  UK_TON(1016047.203454d, "t", IMPERIAL),
  US_TON(907185d, "t", US_CUSTOMARY);

  private double baseUnitFactor;
  private String symbol;
  private MeasurementSystem measurementSystem;

  Mass(double baseUnitFactor, String symbol, MeasurementSystem measurementSystem) {
    this.baseUnitFactor = baseUnitFactor;
    this.symbol = symbol;
    this.measurementSystem = measurementSystem;
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
    return measurementSystem;
  }
}
