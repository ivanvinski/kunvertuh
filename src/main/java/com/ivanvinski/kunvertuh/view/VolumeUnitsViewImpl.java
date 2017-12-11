package com.ivanvinski.kunvertuh.view;

import com.jfoenix.controls.JFXTextField;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class VolumeUnitsViewImpl extends StackPane implements VolumeUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField liters, cubicMeters;
  @FXML
  private JFXTextField gallons, cubicInches;

  public void initialize() {
    getChildren().setAll(root);
  }

  @Override
  public String getLiters() {
    return liters.getText();
  }

  @Override
  public void setLiters(String liters) {
    this.liters.setText(liters);
  }

  @Override
  public void setOnLitersActionEvent(Consumer<String> actionConsumer) {
    liters.setOnAction(event -> actionConsumer.accept(getLiters()));
  }

  @Override
  public String getCubicMeters() {
    return cubicMeters.getText();
  }

  @Override
  public void setCubicMeters(String cubicMeters) {
    this.cubicMeters.setText(cubicMeters);
  }

  @Override
  public void setOnCubicMetersActionEvent(Consumer<String> actionConsumer) {
    cubicMeters.setOnAction(event -> actionConsumer.accept(getCubicMeters()));
  }

  @Override
  public String getGallons() {
    return gallons.getText();
  }

  @Override
  public void setGallons(String gallons) {
    this.gallons.setText(gallons);
  }

  @Override
  public void setOnGallonsActionEvent(Consumer<String> actionConsumer) {
    gallons.setOnAction(event -> actionConsumer.accept(getGallons()));
  }

  @Override
  public String getCubicInches() {
    return cubicInches.getText();
  }

  @Override
  public void setCubicInches(String cubicInches) {
    this.cubicInches.setText(cubicInches);
  }

  @Override
  public void setOnCubicInchesActionEvent(Consumer<String> actionConsumer) {
    cubicInches.setOnAction(event -> actionConsumer.accept(getCubicInches()));
  }
}
