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

import static com.ivanvinski.kunvertuh.unit.VolumeUnit.CUBIC_INCH;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.CUBIC_METER;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.DECILITER;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.HECTOLITER;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.LITER;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.MILLILITER;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.UK_CUP;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.UK_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.UK_GALLON;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.UK_PINT;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.UK_TABLESPOON;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.UK_TEASPOON;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.US_CUP;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.US_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.US_GALLON;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.US_PINT;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.US_TABLESPOON;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.US_TEASPOON;

import com.ivanvinski.kunvertuh.unit.VolumeUnit;

public final class VolumeModel extends AbstractUnitModel<VolumeUnit> {

  private Double milliliters, deciliters, liters, hectoliters, cubicMeters;
  private Double ukTeaspoons, ukTablespoons, ukCups, ukFluidOunces, ukPints, ukGallons;
  private Double usTeaspoons, usTablespoons, usCups, usFluidOunces, usPints, usGallons;
  private Double cubicInches;

  @Override
  public void convert(Double volume, VolumeUnit unit) {
    convertToMetric(volume, unit);
    convertToImperial(volume, unit);
    convertToUS(volume, unit);
    cubicInches = getUnitConverter().convert(volume, unit).to(CUBIC_INCH);
  }

  public Double getMilliliters() {
    return milliliters;
  }

  public Double getDeciliters() {
    return deciliters;
  }

  public Double getLiters() {
    return liters;
  }

  public Double getHectoliters() {
    return hectoliters;
  }

  public Double getCubicMeters() {
    return cubicMeters;
  }

  public Double getUkTeaspoons() {
    return ukTeaspoons;
  }

  public Double getUkTablespoons() {
    return ukTablespoons;
  }

  public Double getUkCups() {
    return ukCups;
  }

  public Double getUkFluidOunces() {
    return ukFluidOunces;
  }

  public Double getUkPints() {
    return ukPints;
  }

  public Double getUkGallons() {
    return ukGallons;
  }

  public Double getUsTeaspoons() {
    return usTeaspoons;
  }

  public Double getUsTablespoons() {
    return usTablespoons;
  }

  public Double getUsCups() {
    return usCups;
  }

  public Double getUsFluidOunces() {
    return usFluidOunces;
  }

  public Double getUsPints() {
    return usPints;
  }

  public Double getUsGallons() {
    return usGallons;
  }

  public Double getCubicInches() {
    return cubicInches;
  }

  private void convertToMetric(Double volume, VolumeUnit unit) {
    milliliters = getUnitConverter().convert(volume, unit).to(MILLILITER);
    deciliters = getUnitConverter().convert(volume, unit).to(DECILITER);
    liters = getUnitConverter().convert(volume, unit).to(LITER);
    hectoliters = getUnitConverter().convert(volume, unit).to(HECTOLITER);
    cubicMeters = getUnitConverter().convert(volume, unit).to(CUBIC_METER);
  }

  private void convertToImperial(Double volume, VolumeUnit unit) {
    ukTeaspoons = getUnitConverter().convert(volume, unit).to(UK_TEASPOON);
    ukTablespoons = getUnitConverter().convert(volume, unit).to(UK_TABLESPOON);
    ukCups = getUnitConverter().convert(volume, unit).to(UK_CUP);
    ukFluidOunces = getUnitConverter().convert(volume, unit).to(UK_FLUID_OUNCE);
    ukPints = getUnitConverter().convert(volume, unit).to(UK_PINT);
    ukGallons = getUnitConverter().convert(volume, unit).to(UK_GALLON);
  }

  private void convertToUS(Double volume, VolumeUnit unit) {
    usTeaspoons = getUnitConverter().convert(volume, unit).to(US_TEASPOON);
    usTablespoons = getUnitConverter().convert(volume, unit).to(US_TABLESPOON);
    usCups = getUnitConverter().convert(volume, unit).to(US_CUP);
    usFluidOunces = getUnitConverter().convert(volume, unit).to(US_FLUID_OUNCE);
    usPints = getUnitConverter().convert(volume, unit).to(US_PINT);
    usGallons = getUnitConverter().convert(volume, unit).to(US_GALLON);
  }
}
