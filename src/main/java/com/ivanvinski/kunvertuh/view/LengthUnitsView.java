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

package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.LengthUnitsPresenter;

public interface LengthUnitsView extends View<LengthUnitsPresenter> {

  String getMillimeters();

  void setMillimeters(String millimeters);

  String getCentimeters();

  void setCentimeters(String centimeters);

  String getDecimeters();

  void setDecimeters(String decimeters);

  String getMeters();

  void setMeters(String meters);

  String getKilometers();

  void setKilometers(String kilometers);

  String getInches();

  void setInches(String inches);

  String getFeet();

  void setFeet(String feet);

  String getYards();

  void setYards(String yards);

  String getMiles();

  void setMiles(String miles);
}
