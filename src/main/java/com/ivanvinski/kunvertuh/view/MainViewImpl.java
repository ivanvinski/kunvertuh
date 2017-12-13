package com.ivanvinski.kunvertuh.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainViewImpl extends StackPane implements MainView<Parent> {

  private static final String SELECTED_CLASS = "selected";

  @FXML
  private Parent root;
  private StackPane viewContainer = new StackPane();
  @FXML
  private JFXButton menu;
  @FXML
  private JFXDrawer navigation;
  private JFXButton length, mass, volume;

  private Map<Class<? extends Parent>, JFXButton> viewButtonMap = new LinkedHashMap<>();

  public void initialize() {
    getChildren().setAll(root);
    createAndRegisterNavigationButtons();
    menu.setOnAction(event -> toggleDrawer());
    VBox navigationContent = new VBox();
    navigationContent.getStyleClass().add("nav-content");
    navigationContent.getChildren().setAll(viewButtonMap.values());
    navigation.setSidePane(navigationContent);
    navigation.setContent(viewContainer);
  }

  @Override
  public void setActiveView(Parent view) {
    viewContainer.getChildren().setAll(view);
    setSelectedButtonByView(view);
  }

  @Override
  public void setOnLengthActionEvent(Runnable action) {
    length.setOnAction(event -> closeDrawerAndRunActionIsNotNull(action));
  }

  @Override
  public void setOnMassActionEvent(Runnable action) {
    mass.setOnAction(event -> closeDrawerAndRunActionIsNotNull(action));
  }

  @Override
  public void setOnVolumeActionEvent(Runnable action) {
    volume.setOnAction(event -> closeDrawerAndRunActionIsNotNull(action));
  }

  private void createAndRegisterNavigationButtons() {
    length = newNavigationButton("Length", MaterialDesignIcon.RULER);
    registerNavigationButton(length, LengthUnitsViewImpl.class);
    mass = newNavigationButton("Mass", MaterialDesignIcon.WEIGHT);
    registerNavigationButton(mass, MassUnitsViewImpl.class);
    volume = newNavigationButton("Volume", MaterialDesignIcon.CUBE_OUTLINE);
    registerNavigationButton(volume, VolumeUnitsViewImpl.class);
  }

  private JFXButton newNavigationButton(String text, MaterialDesignIcon icon) {
    JFXButton button = new JFXButton(text, new MaterialDesignIconView(icon));
    button.setMaxWidth(Double.MAX_VALUE);
    return button;
  }

  private void registerNavigationButton(JFXButton button, Class<? extends Parent> viewType) {
    viewButtonMap.put(viewType, button);
  }

  private void toggleDrawer() {
    if (navigation.isShown() || navigation.isShowing()) {
      navigation.close();
    } else if (navigation.isHidden() || navigation.isHiding()) {
      navigation.open();
    }
  }

  private void closeDrawerAndRunActionIsNotNull(Runnable action) {
    navigation.close();
    if (action != null) {
      action.run();
    }
  }

  private void setSelectedButtonByView(Parent view) {
    viewButtonMap.values().forEach(button -> button.getStyleClass().remove(SELECTED_CLASS));
    JFXButton button = view == null ? null : viewButtonMap.get(view.getClass());
    if (button != null) {
      button.getStyleClass().add(SELECTED_CLASS);
    }
  }
}
