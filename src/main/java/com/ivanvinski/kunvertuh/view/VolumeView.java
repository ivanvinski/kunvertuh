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

import com.ivanvinski.kunvertuh.presenter.VolumeUnitsPresenter;

public interface VolumeView extends View<VolumeUnitsPresenter> {

  @Override
  void attach(VolumeUnitsPresenter presenter);

  void setMillimetersPrompt(String prompt);

  void setMillimetersValue(String value);

  void setDecilitersPrompt(String prompt);

  void setDecilitersValue(String value);

  void setLitersPrompt(String prompt);

  void setLitersValue(String value);

  void setHectolitersPrompt(String prompt);

  void setHectolitersValue(String value);

  void setCubicMetersPrompt(String prompt);

  void setCubicMetersValue(String value);

  void setUkTeaspoonsPrompt(String prompt);

  void setUkTeaspoonsValue(String value);

  void setUkTablespoonsPrompt(String prompt);

  void setUkTablespoonsValue(String value);

  void setUkCupsPrompt(String prompt);

  void setUkCupsValue(String value);

  void setUkFluidOuncesPrompt(String prompt);

  void setUkFluidOuncesValue(String value);

  void setUkPintsPrompt(String prompt);

  void setUkPintsValue(String value);

  void setUkGallonsPrompt(String prompt);

  void setUkGallonsValue(String value);

  void setUsTeaspoonsPrompt(String prompt);

  void setUsTeaspoonsValue(String value);

  void setUsTablespoonsPrompt(String prompt);

  void setUsTablespoonsValue(String value);

  void setUsCupsPrompt(String prompt);

  void setUsCupsValue(String value);

  void setUsFluidOuncesPrompt(String prompt);

  void setUsFluidOuncesValue(String value);

  void setUsPintsPrompt(String prompt);

  void setUsPintsValue(String value);

  void setUsGallonsPrompt(String prompt);

  void setUsGallonsValue(String value);

  void setCubicInchesPrompt(String prompt);

  void setCubicInchesValue(String value);
}
