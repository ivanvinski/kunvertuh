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

import static com.ivanvinski.kunvertuh.unit.Length.CENTIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.DECIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.FOOT;
import static com.ivanvinski.kunvertuh.unit.Length.INCH;
import static com.ivanvinski.kunvertuh.unit.Length.KILOMETER;
import static com.ivanvinski.kunvertuh.unit.Length.METER;
import static com.ivanvinski.kunvertuh.unit.Length.MILE;
import static com.ivanvinski.kunvertuh.unit.Length.MILLIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.UK_LEAGUE;
import static com.ivanvinski.kunvertuh.unit.Length.US_LEAGUE;
import static com.ivanvinski.kunvertuh.unit.Length.YARD;

import com.ivanvinski.kunvertuh.unit.Length;

public final class LengthModel extends AbstractUnitModel<Length> {

  private Double millimeters, centimeters, decimeters, meters, kilometers;
  private Double inches, feet, yards, miles, ukLeagues, usLeagues;

  @Override
  public void convert(Double length, Length unit) {
    convertToMetric(length, unit);
    convertToNonMetric(length, unit);
  }

  public Double getMillimeters() {
    return millimeters;
  }

  public Double getCentimeters() {
    return centimeters;
  }

  public Double getDecimeters() {
    return decimeters;
  }

  public Double getMeters() {
    return meters;
  }

  public Double getKilometers() {
    return kilometers;
  }

  public Double getInches() {
    return inches;
  }

  public Double getFeet() {
    return feet;
  }

  public Double getYards() {
    return yards;
  }

  public Double getMiles() {
    return miles;
  }

  public Double getUkLeagues() {
    return ukLeagues;
  }

  public Double getUsLeagues() {
    return usLeagues;
  }

  private void convertToMetric(Double length, Length unit) {
    millimeters = getUnitConverter().convert(length, unit).to(MILLIMETER);
    centimeters = getUnitConverter().convert(length, unit).to(CENTIMETER);
    decimeters = getUnitConverter().convert(length, unit).to(DECIMETER);
    meters = getUnitConverter().convert(length, unit).to(METER);
    kilometers = getUnitConverter().convert(length, unit).to(KILOMETER);
  }

  private void convertToNonMetric(Double length, Length unit) {
    inches = getUnitConverter().convert(length, unit).to(INCH);
    feet = getUnitConverter().convert(length, unit).to(FOOT);
    yards = getUnitConverter().convert(length, unit).to(YARD);
    miles = getUnitConverter().convert(length, unit).to(MILE);
    ukLeagues = getUnitConverter().convert(length, unit).to(UK_LEAGUE);
    usLeagues = getUnitConverter().convert(length, unit).to(US_LEAGUE);
  }
}
