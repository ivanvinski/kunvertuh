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

package com.ivanvinski.kunvertuh.mvp.view.javafx;

import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.mvp.view.SettingsView;
import com.jfoenix.controls.JFXComboBox;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class JFXSettingsView extends StackPane implements SettingsView {

  @FXML
  private JFXComboBox<Language> languages;
  private Consumer<Language> languageChanged;

  @Override
  public void initialize() {
    languages.setOnAction(e ->
        languageChanged.accept(languages.getSelectionModel().getSelectedItem()));
  }

  @Override
  public void addLanguage(Language language) {
    languages.getItems().add(language);
  }

  @Override
  public void selectLanguage(Language supportedLanguage) {
    languages.getSelectionModel().select(supportedLanguage);
  }

  @Override
  public Consumer<Language> getOnLanguageChanged() {
    return languageChanged;
  }

  @Override
  public void setOnLanguageChanged(Consumer<Language> languageChanged) {
    this.languageChanged = languageChanged;
  }

  @Override
  public String getLanguagePrompt() {
    return languages.getPromptText();
  }

  @Override
  public void setLanguagePrompt(String languagePrompt) {
    languages.setPromptText(languagePrompt);
  }
}
