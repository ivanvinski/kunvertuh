package com.ivanvinski.kunvertuh.util.javafx;

import com.ivanvinski.kunvertuh.util.Software;
import java.net.URI;
import java.util.function.Consumer;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;

public class LinkableSoftwareColumnFormatter<S> implements ColumnFormatter<S, Software> {

  private Consumer<String> actionConsumer;

  public LinkableSoftwareColumnFormatter(Consumer<String> actionConsumer) {
    this.actionConsumer = actionConsumer;
  }

  @Override
  public void updateItem(TableCell<S, Software> cell, Software item, boolean isEmpty) {
    URI website = item.getWebsite();
    if (website == null) {
      cell.setGraphic(new Label(item.getName()));
    } else {
      Hyperlink hyperlink = new Hyperlink(item.getName());
      hyperlink.setUserData(item.getWebsite().toString());
      hyperlink.setOnAction(event -> actionConsumer.accept((String) hyperlink.getUserData()));
      cell.setGraphic(hyperlink);
    }
  }
}
