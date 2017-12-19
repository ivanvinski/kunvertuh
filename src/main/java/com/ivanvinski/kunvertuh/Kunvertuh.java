package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.module.AboutPresenterModule;
import com.ivanvinski.kunvertuh.module.LengthUnitsPresenterModule;
import com.ivanvinski.kunvertuh.module.MainPresenterModule;
import com.ivanvinski.kunvertuh.module.MassUnitsPresenterModule;
import com.ivanvinski.kunvertuh.module.VolumeUnitsPresenterModule;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.javafx.JFXViewLoader;
import com.ivanvinski.kunvertuh.view.javafx.MainViewImpl;
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
    MainViewImpl mainView = (MainViewImpl) catalog.get(MainViewImpl.class);
    Scene scene = new Scene(mainView, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/style/light.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  private ViewCatalog loadAllViews() {
    ViewCatalog views = new ViewCatalog();
    views.add(new JFXViewLoader(getClass().getResource("/view/length-units.fxml"),
        new LengthUnitsPresenterModule()).load());
    views.add(new JFXViewLoader(getClass().getResource("/view/mass-units.fxml"),
        new MassUnitsPresenterModule()).load());
    views.add(new JFXViewLoader(getClass().getResource("/view/volume-units.fxml"),
        new VolumeUnitsPresenterModule()).load());
    views.add(new JFXViewLoader(getClass().getResource("/view/main.fxml"),
        new MainPresenterModule(views)).load());
    views.add(new JFXViewLoader(getClass().getResource("/view/about.fxml"),
        new AboutPresenterModule(getHostServices())).load());
    return views;
  }
}
