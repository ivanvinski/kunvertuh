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

package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.module.ProductionModule;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.javafx.JFXMainView;
import com.ivanvinski.kunvertuh.view.javafx.JFXViewLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Kunvertuh extends Application {

  public static void main(String... args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    ViewCatalog catalog = loadAllViews();
    JFXMainView mainView = (JFXMainView) catalog.get(JFXMainView.class);
    Scene scene = new Scene(mainView, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/style/light.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  private ViewCatalog loadAllViews() {
    ViewCatalog views = new ViewCatalog();
    DoubleStringConverter converter = new DoubleStringConverter();
    ProductionModule module = new ProductionModule(views, converter, getHostServices());
    views.add(new JFXViewLoader(getClass().getResource("/view/length-units.fxml"), module)
        .load());
    views.add(new JFXViewLoader(getClass().getResource("/view/mass-units.fxml"), module)
        .load());
    views.add(new JFXViewLoader(getClass().getResource("/view/volume-units.fxml"), module)
        .load());
    views.add(new JFXViewLoader(getClass().getResource("/view/main.fxml"), module)
        .load());
    views.add(new JFXViewLoader(getClass().getResource("/view/about.fxml"), module)
        .load());
    return views;
  }
}
