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

public interface VolumeView extends View {

  String getMillilitersPrompt();

  void setMillilitersPrompt(String prompt);

  String getMilliliters();

  void setMilliliters(String milliliters);

  String getDecilitersPrompt();

  void setDecilitersPrompt(String prompt);

  String getDeciliters();

  void setDeciliters(String deciliters);

  String getLitersPrompt();

  void setLitersPrompt(String prompt);

  String getLiters();

  void setLiters(String liters);

  String getHectolitersPrompt();

  void setHectolitersPrompt(String prompt);

  String getHectoliters();

  void setHectoliters(String hectoliters);

  String getCubicMetersPrompt();

  void setCubicMetersPrompt(String prompt);

  String getCubicMeters();

  void setCubicMeters(String cubicMeters);

  String getUkTeaspoonsPrompt();

  void setUkTeaspoonsPrompt(String prompt);

  String getUkTeaspoons();

  void setUkTeaspoons(String teaspoons);

  String getUkTablespoonsPrompt();

  void setUkTablespoonsPrompt(String prompt);

  String getUkTablespoons();

  void setUkTablespoons(String tablespoons);

  String getUkCupsPrompt();

  void setUkCupsPrompt(String prompt);

  String getUkCups();

  void setUkCups(String cups);

  String getUkFluidOuncesPrompt();

  void setUkFluidOuncesPrompt(String prompt);

  String getUkFluidOunces();

  void setUkFluidOunces(String fluidOunces);

  String getUkPintsPrompt();

  void setUkPintsPrompt(String prompt);

  String getUkPints();

  void setUkPints(String pints);

  String getUkGallonsPrompt();

  void setUkGallonsPrompt(String prompt);

  String getUkGallons();

  void setUkGallons(String gallons);

  String getUsTeaspoonsPrompt();

  void setUsTeaspoonsPrompt(String prompt);

  String getUsTeaspoons();

  void setUsTeaspoons(String teaspoons);

  String getUsTablespoonsPrompt();

  void setUsTablespoonsPrompt(String prompt);

  String getUsTablespoons();

  void setUsTablespoons(String tablespoons);

  String getUsCupsPrompt();

  void setUsCupsPrompt(String prompt);

  String getUsCups();

  void setUsCups(String cups);

  String getUsFluidOuncesPrompt();

  void setUsFluidOuncesPrompt(String prompt);

  String getUsFluidOunces();

  void setUsFluidOunces(String fluidOunces);

  String getUsPintsPrompt();

  void setUsPintsPrompt(String prompt);

  String getUsPints();

  void setUsPints(String pints);

  String getUsGallonsPrompt();

  void setUsGallonsPrompt(String prompt);

  String getUsGallons();

  void setUsGallons(String gallons);

  String getCubicInchesPrompt();

  void setCubicInchesPrompt(String prompt);

  String getCubicInches();

  void setCubicInches(String cubicInches);
}
