package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.model.MainModelImpl;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.MainViewImpl;
import com.ivanvinski.kunvertuh.view.ViewCatalog;

public class MainPresenterModule extends AbstractModule {

  private MainModel model;

  public MainPresenterModule(ViewCatalog catalog) {
    model = new MainModelImpl(catalog);
  }

  @Override
  protected void configure() {
    bind(MainView.class).to(MainViewImpl.class);
    bind(MainModel.class).toInstance(model);
  }
}
