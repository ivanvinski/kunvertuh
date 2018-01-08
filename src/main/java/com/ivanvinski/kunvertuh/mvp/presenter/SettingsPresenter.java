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

package com.ivanvinski.kunvertuh.mvp.presenter;

import com.google.common.eventbus.Subscribe;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.mvp.model.SettingsModel;
import com.ivanvinski.kunvertuh.mvp.view.SettingsView;
import java.text.NumberFormat;
import java.util.Arrays;

public class SettingsPresenter extends Presenter<SettingsView, SettingsModel> {

  public SettingsPresenter(SettingsView view, SettingsModel model, EventStream eventStream) {
    super(view, model, eventStream);
  }

  @Override
  public void onInitialized() {
    Arrays.stream(getModel().getLanguages()).forEach(getView()::addLanguage);
    getView().setOnLanguageChanged(getEventStream()::push);
    Arrays.stream(getModel().getNumberFormats()).forEach(getView()::addNumberFormat);
    getView().setOnNumberFormatChanged(getEventStream()::push);
  }

  @Override
  public void onLanguageChanged(Language language) {
    getView().selectLanguage(language);
    getView().setLanguagePrompt(language.getString("LANGUAGE"));
    getView().setNumberFormatPrompt(language.getString("NUMBER_FORMAT"));
  }

  @Subscribe
  public void onNumberFormatChanged(NumberFormat numberFormat) {
    getView().selectNumberFormat(numberFormat);
  }
}
