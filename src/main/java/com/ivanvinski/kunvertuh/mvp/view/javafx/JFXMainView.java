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

package com.ivanvinski.kunvertuh.mvp.view.javafx;

import com.ivanvinski.kunvertuh.mvp.view.MainView;
import com.ivanvinski.kunvertuh.mvp.view.View;
import com.ivanvinski.kunvertuh.Views;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public final class JFXMainView extends StackPane implements MainView {

  private static final String SELECTED_CLASS = "selected";

  private StackPane viewContainer = new StackPane();
  private View activeView;
  @FXML
  private Label appBarTitle;
  @FXML
  private JFXButton menu;
  @FXML
  private JFXDrawer navigation;
  private VBox navigationItemsBox = new VBox();
  private Map<String, JFXButton> navigationItems = new HashMap<>();
  private Consumer<String> navigationItemClickAction = string -> {
  };

  @Override
  public void initialize() {
    navigation.setContent(viewContainer);
    menu.setOnAction(event -> toggleDrawer());
    navigationItemsBox.getStyleClass().add("nav-content");
    navigation.setSidePane(navigationItemsBox);
  }

  @Override
  public void addNavigationItem(String viewIdentifier) {
    Node icon = getIconByViewIdentifier(viewIdentifier);
    JFXButton button = new JFXButton(viewIdentifier);
    if (icon != null) {
      button.setGraphic(icon);
    }
    button.setMaxWidth(Double.MAX_VALUE);
    button.setOnAction(e -> {
      selectNavigationItem(viewIdentifier);
      navigation.close();
      navigationItemClickAction.accept(viewIdentifier);
    });
    navigationItemsBox.getChildren().add(button);
    navigationItems.put(viewIdentifier, button);
  }

  @Override
  public void addNavigationItemSeparator() {
    navigationItemsBox.getChildren().add(new Separator());
  }

  @Override
  public void selectNavigationItem(String viewIdentifier) {
    navigationItemsBox.getChildren().forEach(node -> node.getStyleClass().remove(SELECTED_CLASS));
    navigationItems.get(viewIdentifier).getStyleClass().add(SELECTED_CLASS);
  }

  @Override
  public String getAppBarTitle() {
    return appBarTitle.getText();
  }

  @Override
  public void setAppBarTitle(String appBarTitle) {
    this.appBarTitle.setText(appBarTitle);
  }

  @Override
  public String getNavigationButtonText(String viewIdentifier) {
    return navigationItems.get(viewIdentifier).getText();
  }

  @Override
  public void setNavigationButtonText(String viewIdentifier, String buttonText) {
    navigationItems.get(viewIdentifier).setText(buttonText);
  }

  @Override
  public boolean containsNavigationButton(String viewIdentifier) {
    return navigationItems.containsKey(viewIdentifier);
  }

  @Override
  public Consumer<String> getOnNavigationItemClicked() {
    return navigationItemClickAction;
  }

  @Override
  public void setOnNavigationItemClicked(Consumer<String> navigationItemClickAction) {
    this.navigationItemClickAction = navigationItemClickAction;
  }

  @Override
  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    viewContainer.getChildren().setAll((Parent) view);
    activeView = view;
  }

  private Node getIconByViewIdentifier(String viewIdentifier) {
    MaterialDesignIcon icon;
    if (viewIdentifier.equals(Views.LENGTH)) {
      icon = MaterialDesignIcon.RULER;
    } else if (viewIdentifier.equals(Views.MASS)) {
      icon = MaterialDesignIcon.WEIGHT;
    } else if (viewIdentifier.equals(Views.VOLUME)) {
      icon = MaterialDesignIcon.CUBE_OUTLINE;
    } else if (viewIdentifier.equals(Views.AREA)) {
      icon = MaterialDesignIcon.GRID;
    } else if (viewIdentifier.equals(Views.SETTINGS)) {
      icon = MaterialDesignIcon.SETTINGS;
    } else if (viewIdentifier.equals(Views.ABOUT)) {
      icon = MaterialDesignIcon.HELP_CIRCLE_OUTLINE;
    } else {
      return null;
    }
    return new MaterialDesignIconView(icon);
  }

  private void toggleDrawer() {
    if (navigation.isShown() || navigation.isShowing()) {
      navigation.close();
    } else if (navigation.isHidden() || navigation.isHiding()) {
      navigation.open();
    }
  }
}
