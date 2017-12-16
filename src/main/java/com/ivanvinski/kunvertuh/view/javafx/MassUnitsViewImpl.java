package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.view.MassUnitsView;
import com.jfoenix.controls.JFXTextField;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class MassUnitsViewImpl extends StackPane implements MassUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField milligrams, grams, dekagrams, kilograms;
  @FXML
  private JFXTextField grains, drams, ounces, pounds;

  public void initialize() {
    getChildren().setAll(root);
  }

  @Override
  public String getMilligrams() {
    return milligrams.getText();
  }

  @Override
  public void setMilligrams(String milligrams) {
    this.milligrams.setText(milligrams);
  }

  @Override
  public void setOnMilligramsActionEvent(Consumer<String> actionConsumer) {
    milligrams.setOnAction(event -> actionConsumer.accept(getMilligrams()));
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
  public String getDekagrams() {
    return dekagrams.getText();
  }

  @Override
  public void setDekagrams(String dekagrams) {
    this.dekagrams.setText(dekagrams);
  }

  @Override
  public void setOnDekagramsActionEvent(Consumer<String> actionConsumer) {
    dekagrams.setOnAction(event -> actionConsumer.accept(getDekagrams()));
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
  public String getGrains() {
    return grains.getText();
  }

  @Override
  public void setGrains(String grains) {
    this.grains.setText(grains);
  }

  @Override
  public void setOnGrainsActionEvent(Consumer<String> actionConsumer) {
    grains.setOnAction(event -> actionConsumer.accept(getGrains()));
  }

  @Override
  public String getDrams() {
    return drams.getText();
  }

  @Override
  public void setDrams(String drams) {
    this.drams.setText(drams);
  }

  @Override
  public void setOnDramsActionEvent(Consumer<String> actionConsumer) {
    drams.setOnAction(event -> actionConsumer.accept(getDrams()));
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
}
