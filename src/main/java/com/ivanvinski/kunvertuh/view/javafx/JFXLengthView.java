/*
 * Kunvertuh
 * Copyright (C) 2017  Ivan Vinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ivanvinski.kunvertuh.view.javafx;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.conversion.LengthConversionRequest;
import com.ivanvinski.kunvertuh.unit.Length;
import com.ivanvinski.kunvertuh.view.LengthView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public final class JFXLengthView extends AbstractJFXView implements LengthView {

  @FXML
  private JFXTextField millimeters, centimeters, decimeters, meters, kilometers;
  @FXML
  private JFXTextField inches, feet, yards, miles, ukLeagues, usLeagues;

  @Inject
  public JFXLengthView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void bindEvents() {
    bindMetricTextFieldActionEvents();
    bindNonMetricTextFieldActionEvents();
  }

  @Override
  public String getMillimetersPrompt() {
    return millimeters.getPromptText();
  }

  @Override
  public void setMillimetersPrompt(String prompt) {
    millimeters.setPromptText(prompt);
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
  public String getCentimetersPrompt() {
    return centimeters.getPromptText();
  }

  @Override
  public void setCentimetersPrompt(String prompt) {
    centimeters.setPromptText(prompt);
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
  public String getDecimeterPrompt() {
    return decimeters.getPromptText();
  }

  @Override
  public void setDecimetersPrompt(String prompt) {
    decimeters.setPromptText(prompt);
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
  public String getMetersPrompt() {
    return meters.getPromptText();
  }

  @Override
  public void setMetersPrompt(String prompt) {
    meters.setPromptText(prompt);
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
  public String getKilometersPrompt() {
    return kilometers.getPromptText();
  }

  @Override
  public void setKilometersPrompt(String prompt) {
    kilometers.setPromptText(prompt);
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
  public String getInchesPrompt() {
    return inches.getPromptText();
  }

  @Override
  public void setInchesPrompt(String prompt) {
    inches.setPromptText(prompt);
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
  public String getFeetPrompt() {
    return feet.getPromptText();
  }

  @Override
  public void setFeetPrompt(String prompt) {
    feet.setPromptText(prompt);
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
  public String getYardsPrompt() {
    return yards.getPromptText();
  }

  @Override
  public void setYardsPrompt(String prompt) {
    yards.setPromptText(prompt);
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
  public String getMilesPrompt() {
    return miles.getPromptText();
  }

  @Override
  public void setMilesPrompt(String prompt) {
    miles.setPromptText(prompt);
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
  public String getUkLeaguesPrompt() {
    return ukLeagues.getPromptText();
  }

  @Override
  public void setUkLeaguesPrompt(String prompt) {
    ukLeagues.setPromptText(prompt);
  }

  @Override
  public String getUkLeagues() {
    return ukLeagues.getText();
  }

  @Override
  public void setUkLeagues(String ukLeagues) {
    this.ukLeagues.setText(ukLeagues);
  }

  @Override
  public String getUsLeaguesPrompt() {
    return usLeagues.getPromptText();
  }

  @Override
  public void setUsLeaguesPrompt(String prompt) {
    usLeagues.setPromptText(prompt);
  }

  @Override
  public String getUsLeagues() {
    return usLeagues.getText();
  }

  @Override
  public void setUsLeagues(String usLeagues) {
    this.usLeagues.setText(usLeagues);
  }

  private void bindMetricTextFieldActionEvents() {
    bindTextFieldActionEvent(millimeters, Length.MILLIMETER);
    bindTextFieldActionEvent(centimeters, Length.CENTIMETER);
    bindTextFieldActionEvent(decimeters, Length.DECIMETER);
    bindTextFieldActionEvent(meters, Length.METER);
    bindTextFieldActionEvent(kilometers, Length.KILOMETER);
  }

  private void bindNonMetricTextFieldActionEvents() {
    bindTextFieldActionEvent(inches, Length.INCH);
    bindTextFieldActionEvent(feet, Length.FOOT);
    bindTextFieldActionEvent(yards, Length.YARD);
    bindTextFieldActionEvent(miles, Length.MILE);
    bindTextFieldActionEvent(ukLeagues, Length.UK_LEAGUE);
    bindTextFieldActionEvent(usLeagues, Length.US_LEAGUE);
  }

  private void bindTextFieldActionEvent(TextField textField, Length unit) {
    textField.setOnAction(e -> pushEvent(new LengthConversionRequest(textField.getText(), unit)));
  }
}
