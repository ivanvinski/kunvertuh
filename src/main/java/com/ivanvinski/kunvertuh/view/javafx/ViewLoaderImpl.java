package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.ViewLoader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ViewLoaderImpl implements ViewLoader {

  private ViewCatalog loadedViews = new ViewCatalog();

  @Override
  public void load(URL location, AbstractModule presenterModule) {
    FXMLLoader loader = new FXMLLoader(location);
    ViewAssembler assembler = new ViewAssembler(presenterModule);
    loader.setControllerFactory(assembler);
    try {
      loader.load();
      registerView(location, loader.getController());
      assembler.getPresenter().initialize();
    } catch (IOException e) {
      throw new UncheckedIOException("Can't load view: " + location, e);
    }
  }

  public ViewCatalog getLoadedViews() {
    return loadedViews;
  }

  private void registerView(URL fxmlFile, View view) {
    Objects.requireNonNull(view, "View class not set for: " + fxmlFile);
    throwExceptionIfNotParentSubclass(fxmlFile, view.getClass());
    loadedViews.add(view);
  }

  private void throwExceptionIfNotParentSubclass(URL fxmlFile, Class<? extends View> view) {
    if (!Parent.class.isAssignableFrom(view)) {
      throw new IllegalArgumentException("Not a Parent subclass: " + fxmlFile);
    }
  }
}
