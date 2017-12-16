package com.ivanvinski.kunvertuh.util.javafx;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public interface ColumnFormatter<S, T> extends Callback<TableColumn<S, T>, TableCell<S, T>> {

  @Override
  default TableCell<S, T> call(TableColumn<S, T> param) {
    return new TableCell<S, T>() {
      @Override
      protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null) {
          setGraphic(null);
        } else {
          ColumnFormatter.this.updateItem(this, item, empty);
        }
      }
    };
  }

  void updateItem(TableCell<S, T> cell, T item, boolean isEmpty);
}
