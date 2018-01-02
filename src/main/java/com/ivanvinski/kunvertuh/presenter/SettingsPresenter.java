package com.ivanvinski.kunvertuh.presenter;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.model.SettingsModel;
import com.ivanvinski.kunvertuh.view.SettingsView;
import java.util.Arrays;

public class SettingsPresenter extends Presenter<SettingsView, SettingsModel> {

  public SettingsPresenter(SettingsView view, SettingsModel model, EventStream eventStream) {
    super(view, model, eventStream);
  }

  @Override
  public void onInitialized() {
    Arrays.stream(getModel().getLanguages()).forEach(getView()::addLanguage);
    getView().setOnLanguageChanged(getEventStream()::push);
  }

  @Override
  public void onLanguageChanged(Language language) {
    getView().selectLanguage(language);
    getView().setLanguagePrompt(language.getString("LANGUAGE"));
  }
}
