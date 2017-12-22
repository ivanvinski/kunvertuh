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

public interface LengthView extends View {

  String getMillimetersPrompt();

  void setMillimetersPrompt(String prompt);

  String getMillimeters();

  void setMillimeters(String millimeters);

  String getCentimetersPrompt();

  void setCentimetersPrompt(String prompt);

  String getCentimeters();

  void setCentimeters(String centimeters);

  String getDecimeterPrompt();

  void setDecimetersPrompt(String prompt);

  String getDecimeters();

  void setDecimeters(String decimeters);

  String getMetersPrompt();

  void setMetersPrompt(String prompt);

  String getMeters();

  void setMeters(String meters);

  String getKilometersPrompt();

  void setKilometersPrompt(String prompt);

  String getKilometers();

  void setKilometers(String kilometers);

  String getInchesPrompt();

  void setInchesPrompt(String prompt);

  String getInches();

  void setInches(String inches);

  String getFeetPrompt();

  void setFeetPrompt(String prompt);

  String getFeet();

  void setFeet(String feet);

  String getYardsPrompt();

  void setYardsPrompt(String prompt);

  String getYards();

  void setYards(String yards);

  String getMilesPrompt();

  void setMilesPrompt(String prompt);

  String getMiles();

  void setMiles(String miles);

  String getUkLeaguesPrompt();

  void setUkLeaguesPrompt(String prompt);

  String getUkLeagues();

  void setUkLeagues(String ukLeagues);

  String getUsLeaguesPrompt();

  void setUsLeaguesPrompt(String prompt);

  String getUsLeagues();

  void setUsLeagues(String usLeagues);
}
