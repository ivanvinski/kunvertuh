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

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.ViewChangeRequest;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.Views;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public final class JFXMainView extends AbstractJFXView implements MainView {

  private static final String SELECTED_CLASS = "selected";

  private StackPane viewContainer = new StackPane();
  private JFXViewChanger viewChanger = new JFXViewChanger(viewContainer);
  private View activeView;
  @FXML
  private JFXButton menu;
  @FXML
  private JFXDrawer navigation;
  private VBox navigationContent = new VBox();

  @Inject
  public JFXMainView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void initialize() {
    navigation.setContent(viewContainer);
    menu.setOnAction(event -> toggleDrawer());
    navigationContent.getStyleClass().add("nav-content");
    navigation.setSidePane(navigationContent);
    addNavigationButton(Views.LENGTH, MaterialDesignIcon.RULER);
    addNavigationButton(Views.MASS, MaterialDesignIcon.WEIGHT);
    addNavigationButton(Views.VOLUME, MaterialDesignIcon.CUBE_OUTLINE);
    addNavigationButtonSeparator();
    addNavigationButton(Views.ABOUT, MaterialDesignIcon.HELP_CIRCLE_OUTLINE);
    navigationContent.getChildren().get(0).getStyleClass().add(SELECTED_CLASS);
  }

  @Override
  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    viewChanger.changeView((Parent) view);
    activeView = view;
  }

  private void addNavigationButton(String viewIdentifier, MaterialDesignIcon icon) {
    JFXButton button = new JFXButton(viewIdentifier, new MaterialDesignIconView(icon));
    button.setMaxWidth(Double.MAX_VALUE);
    button.setUserData(viewIdentifier);
    button.setOnAction(e -> {
      setSelectedButton(button);
      pushEvent(new ViewChangeRequest(viewIdentifier));
      navigation.close();
    });
    navigationContent.getChildren().add(button);
  }

  private void addNavigationButtonSeparator() {
    navigationContent.getChildren().add(new Separator());
  }

  private void setSelectedButton(JFXButton button) {
    navigationContent.getChildren().forEach(node -> node.getStyleClass().remove(SELECTED_CLASS));
    button.getStyleClass().add(SELECTED_CLASS);
  }

  private void toggleDrawer() {
    if (navigation.isShown() || navigation.isShowing()) {
      navigation.close();
    } else if (navigation.isHidden() || navigation.isHiding()) {
      navigation.open();
    }
  }
}
