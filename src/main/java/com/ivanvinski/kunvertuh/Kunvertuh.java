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

package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.GuavaEventStream;
import com.ivanvinski.kunvertuh.event.OpenInBrowserEventHandler;
import com.ivanvinski.kunvertuh.event.ViewChangeRequest;
import com.ivanvinski.kunvertuh.event.ViewsLoadedEvent;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.i18n.NumberFormats;
import com.ivanvinski.kunvertuh.measurement.Area;
import com.ivanvinski.kunvertuh.measurement.Length;
import com.ivanvinski.kunvertuh.measurement.Mass;
import com.ivanvinski.kunvertuh.measurement.Speed;
import com.ivanvinski.kunvertuh.measurement.Temperature;
import com.ivanvinski.kunvertuh.measurement.Time;
import com.ivanvinski.kunvertuh.measurement.Volume;
import com.ivanvinski.kunvertuh.mvp.loader.JFXViewLoader;
import com.ivanvinski.kunvertuh.mvp.loader.ViewLoader;
import com.ivanvinski.kunvertuh.mvp.view.View;
import com.ivanvinski.kunvertuh.storage.DefaultSettings;
import com.ivanvinski.kunvertuh.storage.Settings;
import com.ivanvinski.kunvertuh.util.JFXBrowser;
import java.net.URL;
import java.util.Map;
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
    EventStream eventStream = new GuavaEventStream();
    registerEventHandlers(eventStream);
    Map<String, View> loadedViews = loadAllViews(eventStream);
    eventStream.push(new ViewsLoadedEvent(loadedViews));
    primaryStage.setScene(createScene(loadedViews.get(Views.MAIN)));
    eventStream.push(new ViewChangeRequest(Views.LENGTH));
    Settings settings = new DefaultSettings();
    eventStream.push(settings.getLanguage().orElse(Language.ENGLISH));
    eventStream.push(settings.getNumberFormat().orElse(NumberFormats.DOT_AS_DECIMAL_SEPARATOR));
    primaryStage.setTitle("Kunvertuh");
    primaryStage.setMinWidth(650d);
    primaryStage.setMinHeight(500d);
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  private void registerEventHandlers(EventStream eventStream) {
    eventStream.subscribe(new OpenInBrowserEventHandler(new JFXBrowser(getHostServices())));
  }

  private Map<String, View> loadAllViews(EventStream eventStream) {
    ViewLoader<URL> loader = new JFXViewLoader(eventStream);
    loader.loadViewTemplate(Views.LENGTH,
        getClass().getResource("/view/converter-template.fxml"),
        Length.class);
    loader.loadViewTemplate(Views.MASS,
        getClass().getResource("/view/converter-template.fxml"),
        Mass.class);
    loader.loadViewTemplate(Views.VOLUME,
        getClass().getResource("/view/converter-template.fxml"),
        Volume.class);
    loader.loadViewTemplate(Views.AREA,
        getClass().getResource("/view/converter-template.fxml"),
        Area.class);
    loader.loadViewTemplate(Views.TEMPERATURE,
        getClass().getResource("/view/converter-template.fxml"),
        Temperature.class);
    loader.loadViewTemplate(Views.SPEED,
        getClass().getResource("/view/converter-template.fxml"),
        Speed.class);
    loader.loadViewTemplate(Views.TIME,
        getClass().getResource("/view/converter-template.fxml"),
        Time.class);
    loader.loadView(Views.MAIN, getClass().getResource("/view/main.fxml"));
    loader.loadView(Views.SETTINGS, getClass().getResource("/view/settings.fxml"));
    loader.loadView(Views.ABOUT, getClass().getResource("/view/about.fxml"));
    return loader.getLoadedViews();
  }

  private Scene createScene(View initialView) {
    Scene scene = new Scene((Parent) initialView, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/style/light.css").toExternalForm());
    return scene;
  }
}
