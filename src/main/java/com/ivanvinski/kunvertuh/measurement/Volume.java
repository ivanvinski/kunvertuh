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

public enum Volume implements Unit {

  MILLILITER(.001d, "ml", UnitCategory.METRIC),
  DECILITER(.1d, "dl", UnitCategory.METRIC),
  LITER(1d, "l", UnitCategory.METRIC),
  HECTOLITER(100d, "hl", UnitCategory.METRIC),
  CUBIC_METER(1000d, "m3", UnitCategory.METRIC),

  UK_TEASPOON(.00591939d, "tsp", UnitCategory.IMPERIAL),
  UK_TABLESPOON(.0177582d, "Tbsp", UnitCategory.IMPERIAL),
  UK_CUP(.284131d, "cp", UnitCategory.IMPERIAL),
  UK_FLUID_OUNCE(.0284131d, "fl oz", UnitCategory.IMPERIAL),
  UK_PINT(.5682612d, "pt", UnitCategory.IMPERIAL),
  UK_GALLON(4.54609d, "gal", UnitCategory.IMPERIAL),

  US_TEASPOON(.00492892d, "tsp", UnitCategory.US_CUSTOMARY),
  US_TABLESPOON(0.0147868d, "Tbsp", UnitCategory.US_CUSTOMARY),
  US_CUP(.24d, "cp", UnitCategory.US_CUSTOMARY),
  US_FLUID_OUNCE(.02957344d, "fl oz", UnitCategory.US_CUSTOMARY),
  US_PINT(.473176d, "pt", UnitCategory.US_CUSTOMARY),
  US_GALLON(3.7854003218d, "gal", UnitCategory.US_CUSTOMARY),

  CUBIC_INCH(.01638706d, "in3", UnitCategory.NON_METRIC);

  private double baseUnitFactor;
  private String symbol;
  private UnitCategory category;

  Volume(double baseUnitFactor, String symbol, UnitCategory category) {
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
