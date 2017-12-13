package com.ivanvinski.kunvertuh.module;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.model.MainModelImpl;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.MainViewImpl;
import java.util.Map;
import javafx.scene.Parent;

public class MainPresenterModule extends AbstractModule {

  private MainModel<Parent> model;

  public MainPresenterModule(Map<Class<? extends Parent>, Parent> views) {
    model = new MainModelImpl(views);
  }

  @Override
  protected void configure() {
    bind(MainView.class).to(MainViewImpl.class);
    bind(MainModel.class).toInstance(model);
  }
}
