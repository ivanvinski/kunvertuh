package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.jfoenix.controls.JFXTextField;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class LengthUnitsViewImpl extends StackPane implements LengthUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField millimeters, decimeters, centimeters, meters, kilometers;
  @FXML
  private JFXTextField inches, feet, yards, miles;

  public void initialize() {
    getChildren().setAll(root);
  }

  @Override
  public String getMillimeters() {
    return millimeters.getText();
  }

  @Override
  public void setMillimeters(String millimeters) {
    this.millimeters.setText(millimeters);
  }

  @Override
  public void setOnMillimetersActionEvent(Consumer<String> actionConsumer) {
    millimeters.setOnAction(event -> actionConsumer.accept(getMillimeters()));
  }

  @Override
  public String getDecimeters() {
    return decimeters.getText();
  }

  @Override
  public void setDecimeters(String decimeters) {
    this.decimeters.setText(decimeters);
  }

  @Override
  public void setOnDecimetersActionEvent(Consumer<String> actionConsumer) {
    decimeters.setOnAction(event -> actionConsumer.accept(getDecimeters()));
  }

  @Override
  public String getCentimeters() {
    return centimeters.getText();
  }

  @Override
  public void setCentimeters(String centimeters) {
    this.centimeters.setText(centimeters);
  }

  @Override
  public void setOnCentimetersActionEvent(Consumer<String> actionConsumer) {
    centimeters.setOnAction(event -> actionConsumer.accept(getCentimeters()));
  }

  @Override
  public String getMeters() {
    return meters.getText();
  }

  @Override
  public void setMeters(String meters) {
    this.meters.setText(meters);
  }

  @Override
  public void setOnMetersActionEvent(Consumer<String> actionConsumer) {
    meters.setOnAction(event -> actionConsumer.accept(getMeters()));
  }

  @Override
  public String getKilometers() {
    return kilometers.getText();
  }

  @Override
  public void setKilometers(String kilometers) {
    this.kilometers.setText(kilometers);
  }

  @Override
  public void setOnKilometersActionEvent(Consumer<String> actionConsumer) {
    kilometers.setOnAction(event -> actionConsumer.accept(getKilometers()));
  }

  @Override
  public String getInches() {
    return inches.getText();
  }

  @Override
  public void setInches(String inches) {
    this.inches.setText(inches);
  }

  @Override
  public void setOnInchesActionEvent(Consumer<String> actionConsumer) {
    inches.setOnAction(event -> actionConsumer.accept(getInches()));
  }

  @Override
  public String getFeet() {
    return feet.getText();
  }

  @Override
  public void setFeet(String feet) {
    this.feet.setText(feet);
  }

  @Override
  public void setOnFeetChanged(Consumer<String> actionConsumer) {
    feet.setOnAction(event -> actionConsumer.accept(getFeet()));
  }

  @Override
  public String getYards() {
    return yards.getText();
  }

  @Override
  public void setYards(String yards) {
    this.yards.setText(yards);
  }

  @Override
  public void setOnYardsChanged(Consumer<String> actionConsumer) {
    yards.setOnAction(event -> actionConsumer.accept(getYards()));
  }

  @Override
  public String getMiles() {
    return miles.getText();
  }

  @Override
  public void setMiles(String miles) {
    this.miles.setText(miles);
  }

  @Override
  public void setOnMilesChanged(Consumer<String> actionConsumer) {
    miles.setOnAction(event -> actionConsumer.accept(getMiles()));
  }
}
