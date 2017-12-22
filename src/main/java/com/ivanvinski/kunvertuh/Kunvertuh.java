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

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.ViewChangeRequest;
import com.ivanvinski.kunvertuh.module.MainModule;
import com.ivanvinski.kunvertuh.view.LengthView;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.javafx.JFXViewLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class Kunvertuh extends Application {

  public static void main(String... args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Injector injector = Guice.createInjector(new MainModule(getHostServices()));
    EventStream eventStream = injector.getInstance(EventStream.class);
    ViewCatalog loadedViews = loadAllViews(injector);
    primaryStage.setScene(createScene(loadedViews));
    eventStream.push(new ViewChangeRequest(LengthView.class));
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  private ViewCatalog loadAllViews(Injector injector) {
    JFXViewLoader loader = new JFXViewLoader(injector);
    loader.load(getClass().getResource("/view/length-units.fxml"));
    loader.load(getClass().getResource("/view/mass-units.fxml"));
    loader.load(getClass().getResource("/view/volume-units.fxml"));
    loader.load(getClass().getResource("/view/main.fxml"));
    loader.load(getClass().getResource("/view/about.fxml"));
    return loader.getLoadedViews();
  }

  private Scene createScene(ViewCatalog views) {
    MainView mainView = (MainView) views.get(MainView.class);
    Scene scene = new Scene((Parent) mainView, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/style/light.css").toExternalForm());
    return scene;
  }
}
