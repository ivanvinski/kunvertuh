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

import java.util.Objects;
import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public final class JFXViewChanger {

  private Pane viewContainer;

  public JFXViewChanger(Pane viewContainer) {
    this.viewContainer = Objects.requireNonNull(viewContainer, "View container can't be null");
  }

  public void changeView(Parent nextView) {
    if (viewContainer.getChildren().isEmpty()) {
      setView(nextView);
    } else if (nextView != viewContainer.getChildren().get(0)){
      transitionToView(nextView);
    }
  }

  private void setView(Parent nextView) {
    viewContainer.getChildren().setAll(nextView);
  }

  private void transitionToView(Parent nextView) {
    viewContainer.getChildren().add(0, nextView);
    Parent currentView = (Parent) viewContainer.getChildren().get(0);
    FadeTransition fadeOut = obtainFadeOutTransitionFor(currentView);
    fadeOut.setOnFinished(event -> {
      setView(nextView);
      currentView.setOpacity(1d);
    });
    fadeOut.play();
  }

  private FadeTransition obtainFadeOutTransitionFor(Parent view) {
    FadeTransition fadeOut = new FadeTransition(Duration.millis(200d), view);
    fadeOut.setFromValue(1d);
    fadeOut.setToValue(0d);
    return fadeOut;
  }
}
