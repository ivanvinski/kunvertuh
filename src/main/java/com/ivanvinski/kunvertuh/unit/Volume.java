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

import static com.ivanvinski.kunvertuh.unit.MeasurementSystem.IMPERIAL;
import static com.ivanvinski.kunvertuh.unit.MeasurementSystem.IMPERIAL_AND_US_CUSTOMARY;
import static com.ivanvinski.kunvertuh.unit.MeasurementSystem.METRIC;
import static com.ivanvinski.kunvertuh.unit.MeasurementSystem.US_CUSTOMARY;

public enum Volume implements Unit {

  MILLILITER(.001d, "ml", METRIC),
  DECILITER(.1d, "dl", METRIC),
  LITER(1d, "l", METRIC),
  HECTOLITER(100d, "hl", METRIC),
  CUBIC_METER(1000d, "m3", METRIC),

  UK_TEASPOON(.00591939d, "tsp", IMPERIAL),
  UK_TABLESPOON(.0177582d, "Tbsp", IMPERIAL),
  UK_CUP(.284131d, "cp", IMPERIAL),
  UK_FLUID_OUNCE(.0284131d, "fl oz", IMPERIAL),
  UK_PINT(.5682612d, "pt", IMPERIAL),
  UK_GALLON(4.54609d, "gal", IMPERIAL),

  US_TEASPOON(.00492892d, "tsp", US_CUSTOMARY),
  US_TABLESPOON(0.0147868d, "Tbsp", US_CUSTOMARY),
  US_CUP(.24d, "cp", US_CUSTOMARY),
  US_FLUID_OUNCE(.02957344d, "fl oz", US_CUSTOMARY),
  US_PINT(.473176d, "pt", US_CUSTOMARY),
  US_GALLON(3.7854003218d, "gal", US_CUSTOMARY),

  CUBIC_INCH(.01638706d, "in3", IMPERIAL_AND_US_CUSTOMARY);

  private double baseUnitFactor;
  private String symbol;
  private MeasurementSystem measurementSystem;

  Volume(double baseUnitFactor, String symbol, MeasurementSystem measurementSystem) {
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
