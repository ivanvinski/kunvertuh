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

package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.unit.Mass.DEKAGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.DRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.GRAIN;
import static com.ivanvinski.kunvertuh.unit.Mass.GRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.KILOGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.METRIC_TON;
import static com.ivanvinski.kunvertuh.unit.Mass.MILLIGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.OUNCE;
import static com.ivanvinski.kunvertuh.unit.Mass.POUND;
import static com.ivanvinski.kunvertuh.unit.Mass.UK_TON;
import static com.ivanvinski.kunvertuh.unit.Mass.US_TON;

import com.ivanvinski.kunvertuh.unit.Mass;

public final class MassModel extends AbstractUnitModel<Mass> {

  private Double milligrams, grams, dekagrams, kilograms, metricTons;
  private Double grains, drams, ounces, pounds, ukTons, usTons;

  @Override
  public void convert(Double mass, Mass unit) {
    convertToMetric(mass, unit);
    convertToNonMetric(mass, unit);
  }

  public Double getMilligrams() {
    return milligrams;
  }

  public Double getGrams() {
    return grams;
  }

  public Double getDekagrams() {
    return dekagrams;
  }

  public Double getKilograms() {
    return kilograms;
  }

  public Double getMetricTons() {
    return metricTons;
  }

  public Double getGrains() {
    return grains;
  }

  public Double getDrams() {
    return drams;
  }

  public Double getOunces() {
    return ounces;
  }

  public Double getPounds() {
    return pounds;
  }

  public Double getUkTons() {
    return ukTons;
  }

  public Double getUsTons() {
    return usTons;
  }

  private void convertToMetric(Double mass, Mass unit) {
    milligrams = getUnitConverter().convert(mass, unit).to(MILLIGRAM);
    grams = getUnitConverter().convert(mass, unit).to(GRAM);
    dekagrams = getUnitConverter().convert(mass, unit).to(DEKAGRAM);
    kilograms = getUnitConverter().convert(mass, unit).to(KILOGRAM);
    metricTons = getUnitConverter().convert(mass, unit).to(METRIC_TON);
  }

  private void convertToNonMetric(Double mass, Mass unit) {
    grains = getUnitConverter().convert(mass, unit).to(GRAIN);
    drams = getUnitConverter().convert(mass, unit).to(DRAM);
    ounces = getUnitConverter().convert(mass, unit).to(OUNCE);
    pounds = getUnitConverter().convert(mass, unit).to(POUND);
    ukTons = getUnitConverter().convert(mass, unit).to(UK_TON);
    usTons = getUnitConverter().convert(mass, unit).to(US_TON);
  }
}
