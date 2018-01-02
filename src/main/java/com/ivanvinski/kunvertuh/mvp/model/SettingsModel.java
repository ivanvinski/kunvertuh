/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.mvp.model;

import com.ivanvinski.kunvertuh.i18n.Language;

public class SettingsModel {

  private Language[] languages;
  private Language activeLanguage;

  public SettingsModel(Language[] languages) {
    this.languages = languages;
  }

  public Language[] getLanguages() {
    return languages;
  }

  public Language getActiveLanguage() {
    return activeLanguage;
  }

  public void setActiveLanguage(Language activeLanguage) {
    this.activeLanguage = activeLanguage;
  }
}
