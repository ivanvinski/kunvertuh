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

import com.ivanvinski.kunvertuh.presenter.MassUnitsPresenter;

public interface MassUnitsView extends View<MassUnitsPresenter> {

  String getMilligrams();

  void setMilligrams(String milligrams);

  String getGrams();

  void setGrams(String grams);

  String getDekagrams();

  void setDekagrams(String dekagrams);

  String getKilograms();

  void setKilograms(String kilograms);

  String getGrains();

  void setGrains(String grains);

  String getDrams();

  void setDrams(String drams);

  String getOunces();

  void setOunces(String ounces);

  String getPounds();

  void setPounds(String pounds);
}
