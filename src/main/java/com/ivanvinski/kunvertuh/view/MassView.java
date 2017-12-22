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

public interface MassView extends View {

  String getMilligramsPrompt();

  void setMilligramsPrompt(String prompt);

  String getMilligrams();

  void setMilligrams(String milligrams);

  String getGramsPrompt();

  void setGramsPrompt(String prompt);

  String getGrams();

  void setGrams(String grams);

  String getDekagramsPrompt();

  void setDekagramsPrompt(String prompt);

  String getDekagrams();

  void setDekagrams(String dekagrams);

  String getKilogramsPrompt();

  void setKilogramsPrompt(String prompt);

  String getKilograms();

  void setKilograms(String kilograms);

  String getMetricTonsPrompt();

  void setMetricTonsPrompt(String prompt);

  String getMetricTons();

  void setMetricTons(String metricTons);

  String getGrainsPrompt();

  void setGrainsPrompt(String prompt);

  String getGrains();

  void setGrains(String grains);

  String getDramsPrompt();

  void setDramsPrompt(String prompt);

  String getDrams();

  void setDrams(String drams);

  String getOuncesPrompt();

  void setOuncesPrompt(String prompt);

  String getOunces();

  void setOunces(String ounces);

  String getPoundsPrompt();

  void setPoundsPrompt(String prompt);

  String getPounds();

  void setPounds(String pounds);

  String getUkTonsPrompt();

  void setUkTonsPrompt(String prompt);

  String getUkTons();

  void setUkTons(String ukTons);

  String getUsTonsPrompt();

  void setUsTonsPrompt(String prompt);

  String getUsTons();

  void setUsTons(String usTons);
}
