package com.ivanvinski.kunvertuh.util.javafx;

import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

public class SimpleColumnFormatter<S> implements ColumnFormatter<S, String> {

  @Override
  public void updateItem(TableCell<S, String> cell, String item, boolean isEmpty) {
    cell.setGraphic(new Label(item));
  }
}
