package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.model.SettingsModel;
import com.ivanvinski.kunvertuh.view.SettingsView;

public class SettingsPresenter extends AbstractPresenter<SettingsView, SettingsModel> {

  @Inject
  public SettingsPresenter(SettingsView view, SettingsModel model) {
    super(view, model);
  }

  @Override
  public void onLanguageChange(Language language) {
    super.onLanguageChange(language);
    getModel().setLanguage(language);
  }
}
