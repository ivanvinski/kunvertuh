package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import com.jfoenix.controls.JFXTextField;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class VolumeUnitsViewImpl extends StackPane implements VolumeUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField milliliters, liters, cubicMeters;
  @FXML
  private JFXTextField fluidOunces, pints, gallons;

  public void initialize() {
    getChildren().setAll(root);
  }

  @Override
  public String getMilliliters() {
    return milliliters.getText();
  }

  @Override
  public void setMilliliters(String milliliters) {
    this.milliliters.setText(milliliters);
  }

  @Override
  public void setOnMillilitersActionEvent(Consumer<String> actionConsumer) {
    milliliters.setOnAction(event -> actionConsumer.accept(getMilliliters()));
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
  public String getFluidOunces() {
    return fluidOunces.getText();
  }

  @Override
  public void setFluidOunces(String fluidOunces) {
    this.fluidOunces.setText(fluidOunces);
  }

  @Override
  public void setOnFluidOuncesActionEvent(Consumer<String> actionConsumer) {
    fluidOunces.setOnAction(event -> actionConsumer.accept(getFluidOunces()));
  }

  @Override
  public String getPints() {
    return pints.getText();
  }

  @Override
  public void setPints(String pints) {
    this.pints.setText(pints);
  }

  @Override
  public void setOnPintsActionEvent(Consumer<String> actionConsumer) {
    pints.setOnAction(event -> actionConsumer.accept(getPints()));
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
}
