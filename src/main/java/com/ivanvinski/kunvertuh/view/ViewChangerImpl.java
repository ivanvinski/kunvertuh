package com.ivanvinski.kunvertuh.view;

import java.util.Map;
import java.util.Objects;
import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public final class ViewChangerImpl extends ViewChanger<Parent> {

  private StackPane viewContainer;

  public ViewChangerImpl(StackPane viewContainer, Map<Class<? extends Parent>, Parent> views) {
    super(views);
    this.viewContainer = Objects.requireNonNull(viewContainer, "View container can't be null");
  }

  @Override
  protected void onViewChange(Parent activeView, Parent nextView) {
    FadeTransition fadeOut = new FadeTransition(Duration.millis(250d), activeView);
    fadeOut.setOnFinished(event -> {
      applyView(nextView);
      activeView.setOpacity(1d);
    });
    fadeOut.setFromValue(1d);
    fadeOut.setToValue(0d);
    fadeOut.play();
  }

  @Override
  protected void applyView(Parent view) {
    viewContainer.getChildren().setAll(view);
  }
}
