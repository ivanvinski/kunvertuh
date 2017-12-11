package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VolumeUnitsViewMock implements VolumeUnitsView {

  private StringProperty liters, cubicMeters;
  private Consumer<String> litersAction, cubicMetersAction;
  private StringProperty gallons, cubicInches;
  private Consumer<String> gallonsAction, cubicInchesAction;

  public VolumeUnitsViewMock() {
    liters = newStringProperty();
    cubicMeters = newStringProperty();
    gallons = newStringProperty();
    cubicInches = newStringProperty();
  }

  @Override
  public String getLiters() {
    return liters.getValue();
  }

  @Override
  public void setLiters(String liters) {
    this.liters.setValue(liters);
  }

  @Override
  public void setOnLitersActionEvent(Consumer<String> actionConsumer) {
    litersAction = actionConsumer;
  }

  public void fireLitersActionEvent() {
    litersAction.accept(getLiters());
  }

  @Override
  public String getCubicMeters() {
    return cubicMeters.getValue();
  }

  @Override
  public void setCubicMeters(String cubicMeters) {
    this.cubicMeters.setValue(cubicMeters);
  }

  @Override
  public void setOnCubicMetersActionEvent(Consumer<String> actionConsumer) {
    cubicMetersAction = actionConsumer;
  }

  public void fireCubicMetersActionEvent() {
    cubicMetersAction.accept(getCubicMeters());
  }

  @Override
  public String getGallons() {
    return gallons.getValue();
  }

  @Override
  public void setGallons(String gallons) {
    this.gallons.setValue(gallons);
  }

  @Override
  public void setOnGallonsActionEvent(Consumer<String> actionConsumer) {
    gallonsAction = actionConsumer;
  }

  public void fireGallonsActionEvent() {
    gallonsAction.accept(getGallons());
  }

  @Override
  public String getCubicInches() {
    return cubicInches.getValue();
  }

  @Override
  public void setCubicInches(String cubicInches) {
    this.cubicInches.setValue(cubicInches);
  }

  @Override
  public void setOnCubicInchesActionEvent(Consumer<String> actionConsumer) {
    cubicInchesAction = actionConsumer;
  }

  public void fireCubicInchesActionEvent() {
    cubicInchesAction.accept(getCubicInches());
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
