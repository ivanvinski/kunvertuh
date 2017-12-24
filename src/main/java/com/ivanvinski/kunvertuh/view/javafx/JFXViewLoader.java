/*
 * Kunvertuh
 * Copyright (C) 2017  Ivan Vinski
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.Injector;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Objects;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public final class JFXViewLoader {

  private Injector injector;
  private ViewCatalog loadedViews;

  public JFXViewLoader(Injector injector) {
    this.injector = Objects.requireNonNull(injector, "Injector can't be null");
    loadedViews = injector.getInstance(ViewCatalog.class);
  }

  public View load(String identifier, URL fxmlLocation) {
    ModelViewPresenter mvp = loadMVP(fxmlLocation);
    assembleView((AbstractJFXView) mvp.getView(), mvp.getRoot());
    mvp.getPresenter().onInitialization();
    loadedViews.addView(identifier, mvp.getView());
    return mvp.getView();
  }

  public ViewCatalog getLoadedViews() {
    return loadedViews;
  }

  private ModelViewPresenter loadMVP(URL fxmlLocation) {
    FXMLLoader loader = new FXMLLoader(fxmlLocation);
    ModelViewPresenterFactory factory = new ModelViewPresenterFactory(injector);
    loader.setControllerFactory(factory);
    try {
      Parent rootNode = loader.load();
      return new ModelViewPresenter(rootNode, factory.getModel(), factory.getView(),
          factory.getPresenter());
    } catch (IOException e) {
      throw new UncheckedIOException("Unable to load view: " + loader.getLocation(), e);
    }
  }

  private void assembleView(AbstractJFXView view, Parent root) {
    view.getChildren().setAll(root);
  }
}
