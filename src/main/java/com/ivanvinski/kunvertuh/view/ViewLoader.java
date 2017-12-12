package com.ivanvinski.kunvertuh.view;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ViewLoader {

  private Map<Class<? extends Parent>, Parent> loadedViews = new HashMap<>();

  public void load(URL fxmlFile) {
    FXMLLoader loader = new FXMLLoader(fxmlFile);
    try {
      loader.load();
      // Controller is actually view because fx:controller points to view class
      registerView(fxmlFile, loader.getController());
    } catch (IOException e) {
      throw new UncheckedIOException("Can't load view: " + fxmlFile, e);
    }
  }

  public Map<Class<? extends Parent>, Parent> getLoadedViews() {
    return loadedViews;
  }

  private void registerView(URL fxmlFile, Parent view) {
    Objects.requireNonNull(view, "View class not set for: " + fxmlFile);
    final Class<? extends Parent> viewType = view.getClass();
    if (loadedViews.containsKey(viewType)) {
      throw new IllegalArgumentException("View already loaded: " + viewType);
    } else {
      loadedViews.put(viewType, view);
    }
  }
}
