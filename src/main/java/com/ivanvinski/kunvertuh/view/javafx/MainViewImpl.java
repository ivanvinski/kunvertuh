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

import com.ivanvinski.kunvertuh.presenter.MainPresenter;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.View;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MainViewImpl extends StackPane implements MainView {

  private static final String SELECTED_CLASS = "selected";

  @FXML
  private Parent root;
  private StackPane viewContainer = new StackPane();
  @FXML
  private JFXButton menu;
  @FXML
  private JFXDrawer navigation;
  private JFXButton length, mass, volume, about;

  private Map<Class<? extends View>, JFXButton> viewButtonMap = new LinkedHashMap<>();
  private View activeView;

  @Override
  public void attach(MainPresenter presenter) {
    getChildren().setAll(root);
    prepareMenuButtonAndNavigationDrawer();
    length.setOnAction(e -> changeViewAndCloseDrawer(presenter, LengthUnitsViewImpl.class));
    mass.setOnAction(e -> changeViewAndCloseDrawer(presenter, MassUnitsViewImpl.class));
    volume.setOnAction(e -> changeViewAndCloseDrawer(presenter, VolumeUnitsViewImpl.class));
    about.setOnAction(e -> changeViewAndCloseDrawer(presenter, AboutViewImpl.class));
  }

  @Override
  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    setSelectedButtonByView((Parent) view);
    if (activeView == null) {
      viewContainer.getChildren().setAll((Parent) view);
    } else {
      changeViewWithFading((Parent) view);
    }
    activeView = view;
  }

  private void prepareMenuButtonAndNavigationDrawer() {
    getChildren().setAll(root);
    createAndRegisterNavigationButtons();
    menu.setOnAction(event -> toggleDrawer());
    VBox navigationContent = new VBox();
    navigationContent.getStyleClass().add("nav-content");
    navigationContent.getChildren().setAll(viewButtonMap.values());
    navigationContent.getChildren().add(3, new Separator());
    navigation.setSidePane(navigationContent);
    navigation.setContent(viewContainer);
  }

  private void createAndRegisterNavigationButtons() {
    length = newNavigationButton("Length", MaterialDesignIcon.RULER);
    registerNavigationButton(length, LengthUnitsViewImpl.class);
    mass = newNavigationButton("Mass", MaterialDesignIcon.WEIGHT);
    registerNavigationButton(mass, MassUnitsViewImpl.class);
    volume = newNavigationButton("Volume", MaterialDesignIcon.CUBE_OUTLINE);
    registerNavigationButton(volume, VolumeUnitsViewImpl.class);
    about = newNavigationButton("About", MaterialDesignIcon.HELP_CIRCLE);
    registerNavigationButton(about, AboutViewImpl.class);
  }

  private JFXButton newNavigationButton(String text, MaterialDesignIcon icon) {
    JFXButton button = new JFXButton(text, new MaterialDesignIconView(icon));
    button.setMaxWidth(Double.MAX_VALUE);
    return button;
  }

  private void registerNavigationButton(JFXButton button, Class<? extends View> viewType) {
    viewButtonMap.put(viewType, button);
  }

  private void toggleDrawer() {
    if (navigation.isShown() || navigation.isShowing()) {
      navigation.close();
    } else if (navigation.isHidden() || navigation.isHiding()) {
      navigation.open();
    }
  }

  private void changeViewAndCloseDrawer(MainPresenter presenter, Class<? extends View> viewType) {
    presenter.viewChangeRequested(viewType);
    navigation.close();
  }

  private void setSelectedButtonByView(Parent view) {
    viewButtonMap.values().forEach(button -> button.getStyleClass().remove(SELECTED_CLASS));
    JFXButton button = view == null ? null : viewButtonMap.get(view.getClass());
    if (button != null) {
      button.getStyleClass().add(SELECTED_CLASS);
    }
  }

  private void changeViewWithFading(Parent nextView) {
    viewContainer.getChildren().add(0, nextView);
    FadeTransition fadeOut = new FadeTransition(Duration.millis(200d), (Parent) activeView);
    fadeOut.setOnFinished(event -> {
      viewContainer.getChildren().setAll(nextView);
      fadeOut.getNode().setOpacity(1d);
    });
    fadeOut.setFromValue(1d);
    fadeOut.setToValue(0d);
    fadeOut.play();
  }
}
