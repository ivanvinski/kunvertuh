package com.ivanvinski.kunvertuh.model;

import java.util.Map;
import java.util.Objects;
import javafx.scene.Parent;

public class MainModelImpl implements MainModel<Parent> {

  private Map<Class<? extends Parent>, Parent> loadedViews;
  private Parent activeView;

  public MainModelImpl(Map<Class<? extends Parent>, Parent> loadedViews) {
    this.loadedViews = Objects.requireNonNull(loadedViews, "Loaded views can't be null");
  }

  @Override
  public Parent getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(Parent view) {
    activeView = view;
  }

  @Override
  public Parent getView(Class<? extends Parent> viewType) {
    return loadedViews.get(viewType);
  }
}
