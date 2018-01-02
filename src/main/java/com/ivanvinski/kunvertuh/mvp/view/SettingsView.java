package com.ivanvinski.kunvertuh.mvp.view;

import com.ivanvinski.kunvertuh.i18n.Language;
import java.util.function.Consumer;

public interface SettingsView extends View {

  void addLanguage(Language language);

  void selectLanguage(Language language);

  Consumer<Language> getOnLanguageChanged();

  void setOnLanguageChanged(Consumer<Language> languageChanged);

  String getLanguagePrompt();

  void setLanguagePrompt(String languagePrompt);
}
