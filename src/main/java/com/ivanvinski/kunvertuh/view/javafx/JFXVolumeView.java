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

import static com.ivanvinski.kunvertuh.unit.Volume.CUBIC_INCH;
import static com.ivanvinski.kunvertuh.unit.Volume.CUBIC_METER;
import static com.ivanvinski.kunvertuh.unit.Volume.DECILITER;
import static com.ivanvinski.kunvertuh.unit.Volume.HECTOLITER;
import static com.ivanvinski.kunvertuh.unit.Volume.LITER;
import static com.ivanvinski.kunvertuh.unit.Volume.MILLILITER;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_CUP;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_GALLON;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_PINT;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_TABLESPOON;
import static com.ivanvinski.kunvertuh.unit.Volume.UK_TEASPOON;
import static com.ivanvinski.kunvertuh.unit.Volume.US_CUP;
import static com.ivanvinski.kunvertuh.unit.Volume.US_FLUID_OUNCE;
import static com.ivanvinski.kunvertuh.unit.Volume.US_GALLON;
import static com.ivanvinski.kunvertuh.unit.Volume.US_PINT;
import static com.ivanvinski.kunvertuh.unit.Volume.US_TABLESPOON;
import static com.ivanvinski.kunvertuh.unit.Volume.US_TEASPOON;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.conversion.VolumeConversionRequest;
import com.ivanvinski.kunvertuh.unit.Volume;
import com.ivanvinski.kunvertuh.view.VolumeView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public final class JFXVolumeView extends AbstractJFXView implements VolumeView {

  @FXML
  private JFXTextField milliliters, deciliters, liters, hectoliters, cubicMeters;
  @FXML
  private JFXTextField ukTeaspoons, ukTablespoons, ukCups, ukFluidOunces, ukPints, ukGallons;
  @FXML
  private JFXTextField usTeaspoons, usTablespoons, usCups, usFluidOunces, usPints, usGallons;
  @FXML
  private JFXTextField cubicInches;

  @Inject
  public JFXVolumeView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void bindEvents() {
    bindMetricTextFieldActionEvents();
    bindImperialTextFieldActionEvents();
    bindUsTextFieldActionEvents();
    bindTextFieldActionEvent(cubicInches, CUBIC_INCH);
  }

  @Override
  public String getMillilitersPrompt() {
    return milliliters.getPromptText();
  }

  @Override
  public void setMillilitersPrompt(String prompt) {
    milliliters.setPromptText(prompt);
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
  public String getDecilitersPrompt() {
    return deciliters.getPromptText();
  }

  @Override
  public void setDecilitersPrompt(String prompt) {
    deciliters.setPromptText(prompt);
  }

  @Override
  public String getDeciliters() {
    return deciliters.getText();
  }

  @Override
  public void setDeciliters(String deciliters) {
    this.deciliters.setText(deciliters);
  }

  @Override
  public String getLitersPrompt() {
    return liters.getPromptText();
  }

  @Override
  public void setLitersPrompt(String prompt) {
    liters.setPromptText(prompt);
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
  public String getHectolitersPrompt() {
    return hectoliters.getPromptText();
  }

  @Override
  public void setHectolitersPrompt(String prompt) {
    hectoliters.setPromptText(prompt);
  }

  @Override
  public String getHectoliters() {
    return hectoliters.getText();
  }

  @Override
  public void setHectoliters(String hectoliters) {
    this.hectoliters.setText(hectoliters);
  }

  @Override
  public String getCubicMetersPrompt() {
    return cubicMeters.getPromptText();
  }

  @Override
  public void setCubicMetersPrompt(String prompt) {
    cubicMeters.setPromptText(prompt);
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
  public String getUkTeaspoonsPrompt() {
    return ukTeaspoons.getPromptText();
  }

  @Override
  public void setUkTeaspoonsPrompt(String prompt) {
    ukTeaspoons.setPromptText(prompt);
  }

  @Override
  public String getUkTeaspoons() {
    return ukTeaspoons.getText();
  }

  @Override
  public void setUkTeaspoons(String teaspoons) {
    this.ukTeaspoons.setText(teaspoons);
  }

  @Override
  public String getUkTablespoonsPrompt() {
    return ukTablespoons.getPromptText();
  }

  @Override
  public void setUkTablespoonsPrompt(String prompt) {
    ukTablespoons.setPromptText(prompt);
  }

  @Override
  public String getUkTablespoons() {
    return ukTablespoons.getText();
  }

  @Override
  public void setUkTablespoons(String tablespoons) {
    this.ukTablespoons.setText(tablespoons);
  }

  @Override
  public String getUkCupsPrompt() {
    return ukCups.getPromptText();
  }

  @Override
  public void setUkCupsPrompt(String prompt) {
    ukCups.setPromptText(prompt);
  }

  @Override
  public String getUkCups() {
    return ukCups.getText();
  }

  @Override
  public void setUkCups(String cups) {
    ukCups.setText(cups);
  }

  @Override
  public String getUkFluidOuncesPrompt() {
    return ukFluidOunces.getPromptText();
  }

  @Override
  public void setUkFluidOuncesPrompt(String prompt) {
    ukFluidOunces.setPromptText(prompt);
  }

  @Override
  public String getUkFluidOunces() {
    return ukFluidOunces.getText();
  }

  @Override
  public void setUkFluidOunces(String fluidOunces) {
    ukFluidOunces.setText(fluidOunces);
  }

  @Override
  public String getUkPintsPrompt() {
    return ukPints.getPromptText();
  }

  @Override
  public void setUkPintsPrompt(String prompt) {
    ukPints.setPromptText(prompt);
  }

  @Override
  public String getUkPints() {
    return ukPints.getText();
  }

  @Override
  public void setUkPints(String pints) {
    ukPints.setText(pints);
  }

  @Override
  public String getUkGallonsPrompt() {
    return ukGallons.getPromptText();
  }

  @Override
  public void setUkGallonsPrompt(String prompt) {
    ukGallons.setPromptText(prompt);
  }

  @Override
  public String getUkGallons() {
    return ukGallons.getText();
  }

  @Override
  public void setUkGallons(String gallons) {
    ukGallons.setText(gallons);
  }

  @Override
  public String getUsTeaspoonsPrompt() {
    return usTeaspoons.getPromptText();
  }

  @Override
  public void setUsTeaspoonsPrompt(String prompt) {
    usTeaspoons.setPromptText(prompt);
  }

  @Override
  public String getUsTeaspoons() {
    return usTeaspoons.getText();
  }

  @Override
  public void setUsTeaspoons(String teaspoons) {
    this.usTeaspoons.setText(teaspoons);
  }

  @Override
  public String getUsTablespoonsPrompt() {
    return usTablespoons.getPromptText();
  }

  @Override
  public void setUsTablespoonsPrompt(String prompt) {
    usTablespoons.setPromptText(prompt);
  }

  @Override
  public String getUsTablespoons() {
    return usTablespoons.getText();
  }

  @Override
  public void setUsTablespoons(String tablespoons) {
    this.usTablespoons.setText(tablespoons);
  }

  @Override
  public String getUsCupsPrompt() {
    return usCups.getPromptText();
  }

  @Override
  public void setUsCupsPrompt(String prompt) {
    usCups.setPromptText(prompt);
  }

  @Override
  public String getUsCups() {
    return usCups.getText();
  }

  @Override
  public void setUsCups(String cups) {
    usCups.setText(cups);
  }

  @Override
  public String getUsFluidOuncesPrompt() {
    return usFluidOunces.getPromptText();
  }

  @Override
  public void setUsFluidOuncesPrompt(String prompt) {
    usFluidOunces.setPromptText(prompt);
  }

  @Override
  public String getUsFluidOunces() {
    return usFluidOunces.getText();
  }

  @Override
  public void setUsFluidOunces(String fluidOunces) {
    usFluidOunces.setText(fluidOunces);
  }

  @Override
  public String getUsPintsPrompt() {
    return usPints.getPromptText();
  }

  @Override
  public void setUsPintsPrompt(String prompt) {
    usPints.setPromptText(prompt);
  }

  @Override
  public String getUsPints() {
    return usPints.getText();
  }

  @Override
  public void setUsPints(String pints) {
    usPints.setText(pints);
  }

  @Override
  public String getUsGallonsPrompt() {
    return usGallons.getPromptText();
  }

  @Override
  public void setUsGallonsPrompt(String prompt) {
    usGallons.setPromptText(prompt);
  }

  @Override
  public String getUsGallons() {
    return usGallons.getText();
  }

  @Override
  public void setUsGallons(String gallons) {
    usGallons.setText(gallons);
  }

  @Override
  public String getCubicInchesPrompt() {
    return cubicInches.getPromptText();
  }

  @Override
  public void setCubicInchesPrompt(String prompt) {
    cubicInches.setPromptText(prompt);
  }

  @Override
  public String getCubicInches() {
    return cubicInches.getText();
  }

  @Override
  public void setCubicInches(String cubicInches) {
    this.cubicInches.setText(cubicInches);
  }

  private void bindMetricTextFieldActionEvents() {
    bindTextFieldActionEvent(milliliters, MILLILITER);
    bindTextFieldActionEvent(deciliters, DECILITER);
    bindTextFieldActionEvent(liters, LITER);
    bindTextFieldActionEvent(hectoliters, HECTOLITER);
    bindTextFieldActionEvent(cubicMeters, CUBIC_METER);
  }

  private void bindImperialTextFieldActionEvents() {
    bindTextFieldActionEvent(ukTeaspoons, UK_TEASPOON);
    bindTextFieldActionEvent(ukTablespoons, UK_TABLESPOON);
    bindTextFieldActionEvent(ukCups, UK_CUP);
    bindTextFieldActionEvent(ukFluidOunces, UK_FLUID_OUNCE);
    bindTextFieldActionEvent(ukPints, UK_PINT);
    bindTextFieldActionEvent(ukGallons, UK_GALLON);
  }

  private void bindUsTextFieldActionEvents() {
    bindTextFieldActionEvent(usTeaspoons, US_TEASPOON);
    bindTextFieldActionEvent(usTablespoons, US_TABLESPOON);
    bindTextFieldActionEvent(usCups, US_CUP);
    bindTextFieldActionEvent(usFluidOunces, US_FLUID_OUNCE);
    bindTextFieldActionEvent(usPints, US_PINT);
    bindTextFieldActionEvent(usGallons, US_GALLON);
  }

  private void bindTextFieldActionEvent(JFXTextField textField, Volume unit) {
    textField.setOnAction(e -> pushEvent(new VolumeConversionRequest(textField.getText(), unit)));
  }
}
