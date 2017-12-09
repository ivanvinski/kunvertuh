package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LengthUnitsViewMock implements LengthUnitsView {

  private StringProperty millimeters, centimeters, meters, kilometers;
  private StringProperty inches, feet, yards, miles;

  public LengthUnitsViewMock() {
    millimeters = newStringProperty();
    centimeters = newStringProperty();
    meters = newStringProperty();
    kilometers = newStringProperty();
    inches = newStringProperty();
    feet = newStringProperty();
    yards = newStringProperty();
    miles = newStringProperty();
  }

  @Override
  public String getMillimeters() {
    return millimeters.getValue();
  }

  @Override
  public void setMillimeters(String millimeters) {
    this.millimeters.setValue(millimeters);
  }

  @Override
  public void setOnMillimetersActionEvent(Consumer<String> actionConsumer) {
    millimeters.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getCentimeters() {
    return centimeters.getValue();
  }

  @Override
  public void setCentimeters(String centimeters) {
    this.centimeters.setValue(centimeters);
  }

  @Override
  public void setOnCentimetersActionEvent(Consumer<String> actionConsumer) {
    centimeters.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getMeters() {
    return meters.getValue();
  }

  @Override
  public void setMeters(String meters) {
    this.meters.setValue(meters);
  }

  @Override
  public void setOnMetersActionEvent(Consumer<String> actionConsumer) {
    meters.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getKilometers() {
    return kilometers.getValue();
  }

  @Override
  public void setKilometers(String kilometers) {
    this.kilometers.setValue(kilometers);
  }

  @Override
  public void setOnKilometersActionEvent(Consumer<String> actionConsumer) {
    kilometers.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getInches() {
    return inches.getValue();
  }

  @Override
  public void setInches(String inches) {
    this.inches.setValue(inches);
  }

  @Override
  public void setOnInchesActionEvent(Consumer<String> actionConsumer) {
    inches.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getFeet() {
    return feet.getValue();
  }

  @Override
  public void setFeet(String feet) {
    this.feet.setValue(feet);
  }

  @Override
  public void setOnFeetChanged(Consumer<String> actionConsumer) {
    feet.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getYards() {
    return yards.getValue();
  }

  @Override
  public void setYards(String yards) {
    this.yards.setValue(yards);
  }

  @Override
  public void setOnYardsChanged(Consumer<String> actionConsumer) {
    yards.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  @Override
  public String getMiles() {
    return miles.getValue();
  }

  @Override
  public void setMiles(String miles) {
    this.miles.setValue(miles);
  }

  @Override
  public void setOnMilesChanged(Consumer<String> actionConsumer) {
    miles.addListener((observable, oldValue, newValue) -> actionConsumer.accept(newValue));
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
