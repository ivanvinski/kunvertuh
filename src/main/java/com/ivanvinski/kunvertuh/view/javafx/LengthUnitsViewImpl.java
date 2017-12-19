package com.ivanvinski.kunvertuh.view.javafx;

import static com.ivanvinski.kunvertuh.unit.LengthUnit.CENTIMETERS;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.DECIMETERS;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.FEET;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.INCHES;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.KILOMETERS;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.METERS;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.MILES;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.MILLIMETERS;
import static com.ivanvinski.kunvertuh.unit.LengthUnit.YARDS;

import com.ivanvinski.kunvertuh.presenter.LengthUnitsPresenter;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class LengthUnitsViewImpl extends StackPane implements LengthUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField millimeters, centimeters, decimeters, meters, kilometers;
  @FXML
  private JFXTextField inches, feet, yards, miles;

  @Override
  public void attach(LengthUnitsPresenter presenter) {
    millimeters.setOnAction(e -> presenter.conversionRequested(getMillimeters(), MILLIMETERS));
    centimeters.setOnAction(e -> presenter.conversionRequested(getCentimeters(), CENTIMETERS));
    decimeters.setOnAction(e -> presenter.conversionRequested(getDecimeters(), DECIMETERS));
    meters.setOnAction(e -> presenter.conversionRequested(getMeters(), METERS));
    kilometers.setOnAction(e -> presenter.conversionRequested(getKilometers(), KILOMETERS));
    inches.setOnAction(e -> presenter.conversionRequested(getInches(), INCHES));
    feet.setOnAction(e -> presenter.conversionRequested(getFeet(), FEET));
    yards.setOnAction(e -> presenter.conversionRequested(getYards(), YARDS));
    miles.setOnAction(e -> presenter.conversionRequested(getMiles(), MILES));
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
  public String getCentimeters() {
    return centimeters.getText();
  }

  @Override
  public void setCentimeters(String centimeters) {
    this.centimeters.setText(centimeters);
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
  public String getMeters() {
    return meters.getText();
  }

  @Override
  public void setMeters(String meters) {
    this.meters.setText(meters);
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
  public String getInches() {
    return inches.getText();
  }

  @Override
  public void setInches(String inches) {
    this.inches.setText(inches);
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
  public String getYards() {
    return yards.getText();
  }

  @Override
  public void setYards(String yards) {
    this.yards.setText(yards);
  }

  @Override
  public String getMiles() {
    return miles.getText();
  }

  @Override
  public void setMiles(String miles) {
    this.miles.setText(miles);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }
}
