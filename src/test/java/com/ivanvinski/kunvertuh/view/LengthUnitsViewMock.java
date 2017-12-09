package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LengthUnitsViewMock implements LengthUnitsView {

  private StringProperty millimeters, centimeters, meters, kilometers;
  private Consumer<String> millimetersAction, centimetersAction, metersAction, kilometersAction;
  private StringProperty inches, feet, yards, miles;
  private Consumer<String> inchesAction, feetAction, yardsAction, milesAction;

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
    millimetersAction = actionConsumer;
  }

  public void fireMillimetersActionEvent() {
    millimetersAction.accept(getMillimeters());
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
    centimetersAction = actionConsumer;
  }

  public void fireCentimetersActionEvent() {
    centimetersAction.accept(getCentimeters());
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
    metersAction = actionConsumer;
  }

  public void fireMetersActionEvent() {
    metersAction.accept(getMeters());
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
    kilometersAction = actionConsumer;
  }

  public void fireKilometersActionEvent() {
    kilometersAction.accept(getKilometers());
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
    inchesAction = actionConsumer;
  }

  public void fireInchesActionEvent() {
    inchesAction.accept(getInches());
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
    feetAction = actionConsumer;
  }

  public void fireFeetActionEvent() {
    feetAction.accept(getFeet());
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
    yardsAction = actionConsumer;
  }

  public void fireYardsActionEvent() {
    yardsAction.accept(getYards());
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
    milesAction = actionConsumer;
  }

  public void fireMilesActionEvent() {
    milesAction.accept(getMiles());
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
