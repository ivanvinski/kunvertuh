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

import com.ivanvinski.kunvertuh.presenter.LengthPresenter;

public interface LengthView extends View<LengthPresenter> {

  @Override
  void attach(LengthPresenter presenter);

  void setMillimetersPrompt(String prompt);

  void setMillimetersValue(String value);

  void setCentimetersPrompt(String prompt);

  void setCentimetersValue(String value);

  void setDecimetersPrompt(String prompt);

  void setDecimetersValue(String value);

  void setMetersPrompt(String prompt);

  void setMetersValue(String value);

  void setKilometersPrompt(String prompt);

  void setKilometersValue(String value);

  void setInchesPrompt(String prompt);

  void setInchesValue(String value);

  void setFeetPrompt(String prompt);

  void setFeetValue(String value);

  void setYardsPrompt(String prompt);

  void setYardsValue(String value);

  void setMilesPrompt(String prompt);

  void setMilesValue(String value);

  void setUkLeaguesPrompt(String prompt);

  void setUkLeaguesValue(String value);

  void setUsLeaguesPrompt(String prompt);

  void setUsLeaguesValue(String value);
}
