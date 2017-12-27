package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.view.SettingsView;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;

public class JFXSettingsView extends AbstractJFXView implements SettingsView {

  @FXML
  private JFXComboBox<Language> languageField;
  private boolean suppressLanguageChangeEvent;

  @Inject
  public JFXSettingsView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void initialize() {
    languageField.getItems().addAll(Language.ALL);
    languageField.setOnAction(e -> {
      if (!suppressLanguageChangeEvent) {
        pushEvent(languageField.getSelectionModel().getSelectedItem());
      }
    });
  }

  @Override
  public void setLanguage(Language language) {
    super.setLanguage(language);
    languageField.setPromptText(language.getString("LANGUAGE"));
    suppressLanguageChangeEvent = true;
    languageField.getSelectionModel().select(language);
    suppressLanguageChangeEvent = false;
  }
}
