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
import com.ivanvinski.kunvertuh.i18n.NumberFormats;
import com.ivanvinski.kunvertuh.storage.Settings;
import java.text.NumberFormat;

public class SettingsModel {

  private Settings settings;
  private Language[] languages = Language.ALL;
  private NumberFormat[] numberFormats = NumberFormats.ALL;

  public SettingsModel(Settings settings) {
    this.settings = settings;
  }

  public Language[] getLanguages() {
    return languages;
  }

  public Language getActiveLanguage() {
    return settings.getLanguage().orElse(null);
  }

  public void setActiveLanguage(Language activeLanguage) {
    settings.setLanguage(activeLanguage);
  }

  public NumberFormat[] getNumberFormats() {
    return numberFormats;
  }

  public NumberFormat getActiveNumberFormat() {
    return settings.getNumberFormat().orElse(null);
  }

  public void setActiveNumberFormat(NumberFormat activeNumberFormat) {
    settings.setNumberFormat(activeNumberFormat);
  }
}
