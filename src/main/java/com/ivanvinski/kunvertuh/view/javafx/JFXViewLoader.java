package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.presenter.Presenter;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.ViewLoader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public final class JFXViewLoader implements ViewLoader {

  private final URL fxmlLocation;
  private final AbstractModule presenterModule;

  public JFXViewLoader(URL fxmlLocation, AbstractModule presenterModule) {
    this.fxmlLocation = Objects.requireNonNull(fxmlLocation, "View location can't be null");
    this.presenterModule = Objects.requireNonNull(
        presenterModule, "Presenter module can't be null");
  }

  @Override
  public View load() {
    FXMLLoader loader = new FXMLLoader(fxmlLocation);
    Presenter presenter = loadPresenter(loader);
    View view = loader.getController();
    throwExceptionIfNullOrNotParentSubclass(view);
    view.attach(presenter);
    presenter.initialize();
    return view;
  }

  private Presenter loadPresenter(FXMLLoader loader) {
    ViewFactory viewFactory = new ViewFactory(presenterModule);
    loader.setControllerFactory(viewFactory);
    try {
      loader.load();
      return viewFactory.getPresenter();
    } catch (IOException e) {
      throw new UncheckedIOException("Unable to load view: " + loader.getLocation(), e);
    }
  }

  private void throwExceptionIfNullOrNotParentSubclass(View view) {
    Objects.requireNonNull(view, "View class not set for: " + fxmlLocation);
    if (!Parent.class.isAssignableFrom(view.getClass())) {
      throw new IllegalArgumentException("Not a Parent subclass: " + fxmlLocation);
    }
  }
}
