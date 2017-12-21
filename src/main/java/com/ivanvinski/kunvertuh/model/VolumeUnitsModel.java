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

import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.unit.converter.VolumeUnitConverter;

public class VolumeUnitsModel implements UnitsModel<VolumeUnit> {

  private VolumeUnitConverter unitConverter = new VolumeUnitConverter();
  private Double milliliters, liters, cubicMeters;
  private Double fluidOunces, pints, gallons;

  @Override
  public void convert(Double sourceVolume, VolumeUnit sourceUnit) {
    milliliters = getUnitConverter().toMilliliter(sourceVolume, sourceUnit);
    liters = getUnitConverter().toLiter(sourceVolume, sourceUnit);
    cubicMeters = getUnitConverter().toCubicMeter(sourceVolume, sourceUnit);
    fluidOunces = getUnitConverter().toUKFluidOunce(sourceVolume, sourceUnit);
    pints = getUnitConverter().toPint(sourceVolume, sourceUnit);
    gallons = getUnitConverter().toUKGallon(sourceVolume, sourceUnit);
  }

  @Override
  public VolumeUnitConverter getUnitConverter() {
    return unitConverter;
  }

  public Double getMilliliters() {
    return milliliters;
  }

  public Double getLiters() {
    return liters;
  }

  public Double getCubicMeters() {
    return cubicMeters;
  }

  public Double getFluidOunces() {
    return fluidOunces;
  }

  public Double getPints() {
    return pints;
  }

  public Double getGallons() {
    return gallons;
  }
}
