package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.module.LengthUnitsPresenterModule;
import com.ivanvinski.kunvertuh.module.MainPresenterModule;
import com.ivanvinski.kunvertuh.module.MassUnitsPresenterModule;
import com.ivanvinski.kunvertuh.module.VolumeUnitsPresenterModule;
import com.ivanvinski.kunvertuh.view.MainViewImpl;
import com.ivanvinski.kunvertuh.view.ViewLoader;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Kunvertuh extends Application {

  public static void main(String... args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Map<Class<? extends Parent>, Parent> views = loadAllViews();
    MainViewImpl mainView = (MainViewImpl) views.get(MainViewImpl.class);
    Scene scene = new Scene(mainView, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/style/light.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.centerOnScreen();
    primaryStage.show();
  }

  private Map<Class<? extends Parent>, Parent> loadAllViews() {
    ViewLoader viewLoader = new ViewLoader();
    viewLoader.load(getClass().getResource("/view/length-units.fxml"),
        new LengthUnitsPresenterModule());
    viewLoader.load(getClass().getResource("/view/mass-units.fxml"),
        new MassUnitsPresenterModule());
    viewLoader.load(getClass().getResource("/view/volume-units.fxml"),
        new VolumeUnitsPresenterModule());
    viewLoader.load(getClass().getResource("/view/main.fxml"),
        new MainPresenterModule(viewLoader.getLoadedViews()));
    return viewLoader.getLoadedViews();
  }
}
