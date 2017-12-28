package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.measurement.Area;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public final class JFXAreaConverterView extends AbstractJFXConverterView<Area> {

  @FXML
  private Pane cardContainer;

  @Inject
  public JFXAreaConverterView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  protected ObservableList<Node> getCardContainerChildren() {
    return cardContainer.getChildren();
  }
}
