package com.ivanvinski.kunvertuh.view;

import com.jfoenix.controls.JFXTextField;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class MassUnitsViewImpl extends StackPane implements MassUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField grams, kilograms, metricTons;
  @FXML
  private JFXTextField ounces, pounds, imperialTons;

  public void initialize() {
    getChildren().setAll(root);
  }

  @Override
  public String getGrams() {
    return grams.getText();
  }

  @Override
  public void setGrams(String grams) {
    this.grams.setText(grams);
  }

  @Override
  public void setOnGramsActionEvent(Consumer<String> actionConsumer) {
    grams.setOnAction(event -> actionConsumer.accept(getGrams()));
  }

  @Override
  public String getKilograms() {
    return kilograms.getText();
  }

  @Override
  public void setKilograms(String kilograms) {
    this.kilograms.setText(kilograms);
  }

  @Override
  public void setOnKilogramsActionEvent(Consumer<String> actionConsumer) {
    kilograms.setOnAction(event -> actionConsumer.accept(getKilograms()));
  }

  @Override
  public String getMetricTons() {
    return metricTons.getText();
  }

  @Override
  public void setMetricTons(String metricTons) {
    this.metricTons.setText(metricTons);
  }

  @Override
  public void setOnMetricTonsActionEvent(Consumer<String> actionConsumer) {
    metricTons.setOnAction(event -> actionConsumer.accept(getMetricTons()));
  }

  @Override
  public String getOunces() {
    return ounces.getText();
  }

  @Override
  public void setOunces(String ounces) {
    this.ounces.setText(ounces);
  }

  @Override
  public void setOnOuncesActionEvent(Consumer<String> actionConsumer) {
    ounces.setOnAction(event -> actionConsumer.accept(getOunces()));
  }

  @Override
  public String getPounds() {
    return pounds.getText();
  }

  @Override
  public void setPounds(String pounds) {
    this.pounds.setText(pounds);
  }

  @Override
  public void setOnPoundsActionEvent(Consumer<String> actionConsumer) {
    pounds.setOnAction(event -> actionConsumer.accept(getPounds()));
  }

  @Override
  public String getImperialTons() {
    return imperialTons.getText();
  }

  @Override
  public void setImperialTons(String imperialTons) {
    this.imperialTons.setText(imperialTons);
  }

  @Override
  public void setOnImperialTonsActionEvent(Consumer<String> actionConsumer) {
    imperialTons.setOnAction(event -> actionConsumer.accept(getImperialTons()));
  }
}
