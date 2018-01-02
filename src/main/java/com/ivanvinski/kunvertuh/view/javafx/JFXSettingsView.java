package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.view.SettingsView;
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
