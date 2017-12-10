package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MassUnitsViewMock implements MassUnitsView {

  private StringProperty grams, kilograms, metricTons;
  private Consumer<String> gramsAction, kilogramsAction, metricTonsAction;
  private StringProperty ounces, pounds, imperialTons;
  private Consumer<String> ouncesAction, poundsAction, imperialTonsAction;

  public MassUnitsViewMock() {
    grams = newStringProperty();
    kilograms = newStringProperty();
    metricTons = newStringProperty();
    ounces = newStringProperty();
    pounds = newStringProperty();
    imperialTons = newStringProperty();
  }

  @Override
  public String getGrams() {
    return grams.getValue();
  }

  @Override
  public void setGrams(String grams) {
    this.grams.setValue(grams);
  }

  @Override
  public void setOnGramsActionEvent(Consumer<String> actionConsumer) {
    gramsAction = actionConsumer;
  }

  public void fireGramsActionEvent() {
    gramsAction.accept(getGrams());
  }

  @Override
  public String getKilograms() {
    return kilograms.getValue();
  }

  @Override
  public void setKilograms(String kilograms) {
    this.kilograms.setValue(kilograms);
  }

  @Override
  public void setOnKilogramsActionEvent(Consumer<String> actionConsumer) {
    kilogramsAction = actionConsumer;
  }

  public void fireKilogramsActionEvent() {
    kilogramsAction.accept(getKilograms());
  }

  @Override
  public String getMetricTons() {
    return metricTons.getValue();
  }

  @Override
  public void setMetricTons(String metricTons) {
    this.metricTons.setValue(metricTons);
  }

  @Override
  public void setOnMetricTonsActionEvent(Consumer<String> actionConsumer) {
    metricTonsAction = actionConsumer;
  }

  public void fireMetricTonsActionEvent() {
    metricTonsAction.accept(getMetricTons());
  }

  @Override
  public String getOunces() {
    return ounces.getValue();
  }

  @Override
  public void setOunces(String ounces) {
    this.ounces.setValue(ounces);
  }

  @Override
  public void setOnOuncesActionEvent(Consumer<String> actionConsumer) {
    ouncesAction = actionConsumer;
  }

  public void fireOuncesActionEvent() {
    ouncesAction.accept(getOunces());
  }

  @Override
  public String getPounds() {
    return pounds.getValue();
  }

  @Override
  public void setPounds(String pounds) {
    this.pounds.setValue(pounds);
  }

  @Override
  public void setOnPoundsActionEvent(Consumer<String> actionConsumer) {
    poundsAction = actionConsumer;
  }

  public void firePoundsActionEvent() {
    poundsAction.accept(getPounds());
  }

  @Override
  public String getImperialTons() {
    return imperialTons.getValue();
  }

  @Override
  public void setImperialTons(String imperialTons) {
    this.imperialTons.setValue(imperialTons);
  }

  @Override
  public void setOnImperialTonsActionEvent(Consumer<String> actionConsumer) {
    imperialTonsAction = actionConsumer;
  }

  public void fireImperialTonsActionEvent() {
    imperialTonsAction.accept(getImperialTons());
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
