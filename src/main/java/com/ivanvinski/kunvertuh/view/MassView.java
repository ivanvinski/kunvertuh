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

public interface MassView extends View<MassUnitsPresenter> {

  @Override
  void attach(MassUnitsPresenter presenter);

  void setMilligramsPrompt(String prompt);

  void setMilligramsValue(String value);

  void setGramsPrompt(String prompt);

  void setGramsValue(String value);

  void setDekagramsPrompt(String prompt);

  void setDekagramsValue(String value);

  void setKilogramsPrompt(String prompt);

  void setKilogramsValue(String value);

  void setMetricTonsPrompt(String prompt);

  void setMetricTonsValue(String value);

  void setGrainsPrompt(String prompt);

  void setGrainsValue(String value);

  void setDramsPrompt(String prompt);

  void setDramsValue(String value);

  void setOuncesPrompt(String prompt);

  void setOuncesValue(String value);

  void setPoundsPrompt(String prompt);

  void setPoundsValue(String value);

  void setUkTonsPrompt(String prompt);

  void setUkTonsValue(String value);

  void setUsTonsPrompt(String prompt);

  void setUsTonsValue(String value);
}
