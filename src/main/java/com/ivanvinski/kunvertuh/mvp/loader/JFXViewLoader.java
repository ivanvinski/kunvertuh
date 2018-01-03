/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.mvp.loader;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.mvp.presenter.Presenter;
import com.ivanvinski.kunvertuh.mvp.view.View;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class JFXViewLoader implements ViewLoader<URL> {

  private EventStream eventStream;
  private HostServices hostServices;
  private Map<String, View> loadedViews = new LinkedHashMap<>();

  public JFXViewLoader(EventStream eventStream) {
    this.eventStream = eventStream;
  }

  @Override
  public void loadView(String identifier, URL fxmlLocation) {
    FXMLLoader loader = new FXMLLoader(fxmlLocation);
    JFXViewFactory viewFactory = new JFXViewFactory(eventStream);
    loader.setControllerFactory(viewFactory);
    loadAndAssemble(identifier, loader, viewFactory);
  }

  @Override
  public void loadViewTemplate(String identifier, URL fxmlLocation, Class<?> presenterType) {
    FXMLLoader loader = new FXMLLoader(fxmlLocation);
    JFXViewFactory viewFactory = new JFXViewFactory(eventStream);
    loader.setController(viewFactory.call(presenterType));
    loadAndAssemble(identifier, loader, viewFactory);
  }

  protected void loadAndAssemble(String identifier, FXMLLoader loader, JFXViewFactory viewFactory) {
    MVPMetadata metadata = loadMVPMetadata(loader, viewFactory);
    Pane view = (Pane) metadata.view;
    view.getChildren().setAll(metadata.root);
    loadedViews.put(identifier, metadata.view);
    metadata.presenter.onInitialized();
  }

  @Override
  public Map<String, View> getLoadedViews() {
    return loadedViews;
  }

  private MVPMetadata loadMVPMetadata(FXMLLoader loader, JFXViewFactory viewFactory) {
    try {
      return new MVPMetadata(loader.load(),
          viewFactory.getPresenter().getModel(),
          loader.getController() /* getController() returns View because of JFXViewFactory */,
          viewFactory.getPresenter());
    } catch (IOException e) {
      throw new UncheckedIOException("Can't load FXML file: " + loader.getLocation(), e);
    }
  }

  private static final class MVPMetadata {

    private Parent root;
    private Object model;
    private View view;
    private Presenter presenter;

    private MVPMetadata(Parent root, Object model, View view, Presenter presenter) {
      this.root = root;
      this.model = model;
      this.view = view;
      this.presenter = presenter;
    }
  }
}
