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

package com.ivanvinski.kunvertuh.mvp.view;

import com.ivanvinski.kunvertuh.i18n.Language;
import java.text.NumberFormat;
import java.util.function.Consumer;

public interface SettingsView extends View {

  void addLanguage(Language language);

  void addNumberFormat(NumberFormat numberFormat);

  void selectLanguage(Language language);

  void selectNumberFormat(NumberFormat numberFormat);

  Consumer<Language> getOnLanguageChanged();

  void setOnLanguageChanged(Consumer<Language> languageChanged);

  String getLanguagePrompt();

  void setLanguagePrompt(String languagePrompt);

  Consumer<NumberFormat> getOnNumberFormatChanged();

  void setOnNumberFormatChanged(Consumer<NumberFormat> numberFormatChanged);

  String getNumberFormatPrompt();

  void setNumberFormatPrompt(String numberFormatPrompt);
}
