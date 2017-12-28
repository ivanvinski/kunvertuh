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
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.module.MainModule;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.Views;
import com.ivanvinski.kunvertuh.view.javafx.JFXViewLoader;
import javafx.application.Application;
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
    eventStream.push(new ViewChangeRequest(Views.LENGTH));
    eventStream.push(Language.ENGLISH);
    primaryStage.setTitle("Kunvertuh");
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  private ViewCatalog loadAllViews(Injector injector) {
    JFXViewLoader loader = new JFXViewLoader(injector);
    loader.load(Views.LENGTH, getClass().getResource("/view/length-converter.fxml"));
    loader.load(Views.MASS, getClass().getResource("/view/mass-converter.fxml"));
    loader.load(Views.VOLUME, getClass().getResource("/view/volume-converter.fxml"));
    loader.load(Views.AREA, getClass().getResource("/view/area-converter.fxml"));
    loader.load(Views.MAIN, getClass().getResource("/view/main.fxml"));
    loader.load(Views.SETTINGS, getClass().getResource("/view/settings.fxml"));
    loader.load(Views.ABOUT, getClass().getResource("/view/about.fxml"));
    return loader.getLoadedViews();
  }

  private Scene createScene(ViewCatalog views) {
    Scene scene = new Scene(views.getView(Views.MAIN), 800, 600);
    scene.getStylesheets().add(getClass().getResource("/style/light.css").toExternalForm());
    return scene;
  }
}
