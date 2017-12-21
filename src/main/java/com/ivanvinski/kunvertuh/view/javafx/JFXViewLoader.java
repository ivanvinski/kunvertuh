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
  private ViewCatalog loadedViews = new ViewCatalog();

  public JFXViewLoader(Injector injector) {
    this.injector = Objects.requireNonNull(injector, "Injector can't be null");
  }

  public View load(URL fxmlLocation) {
    FXMLLoader loader = new FXMLLoader(fxmlLocation);
    loader.setControllerFactory(new MVPAssembler(injector));
    try {
      Parent parent = loader.load();
      AbstractJFXView view = loader.getController();
      loadedViews.add(view);
      view.getChildren().setAll(parent);
      view.bindEvents();
      return view;
    } catch (IOException e) {
      throw new UncheckedIOException("", e);
    }
  }

  public ViewCatalog getLoadedViews() {
    return loadedViews;
  }
}
