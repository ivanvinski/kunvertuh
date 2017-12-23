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

import static com.ivanvinski.kunvertuh.measurement.Mass.DEKAGRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.DRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.GRAIN;
import static com.ivanvinski.kunvertuh.measurement.Mass.GRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.KILOGRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.METRIC_TON;
import static com.ivanvinski.kunvertuh.measurement.Mass.MILLIGRAM;
import static com.ivanvinski.kunvertuh.measurement.Mass.OUNCE;
import static com.ivanvinski.kunvertuh.measurement.Mass.POUND;
import static com.ivanvinski.kunvertuh.measurement.Mass.UK_TON;
import static com.ivanvinski.kunvertuh.measurement.Mass.US_TON;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.conversion.MassConversionRequest;
import com.ivanvinski.kunvertuh.measurement.Mass;
import com.ivanvinski.kunvertuh.view.MassView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public final class JFXMassView extends AbstractJFXView implements MassView {

  @FXML
  private JFXTextField milligrams, grams, dekagrams, kilograms, metricTons;
  @FXML
  private JFXTextField grains, drams, ounces, pounds, ukTons, usTons;

  @Inject
  public JFXMassView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void bindEvents() {
    bindMetricTextFieldActionEvents();
    bindNonMetricTextFieldActionEvents();
  }

  @Override
  public String getMilligramsPrompt() {
    return milligrams.getPromptText();
  }

  @Override
  public void setMilligramsPrompt(String prompt) {
    milligrams.setPromptText(prompt);
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
  public String getGramsPrompt() {
    return grams.getPromptText();
  }

  @Override
  public void setGramsPrompt(String prompt) {
    grams.setPromptText(prompt);
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
  public String getDekagramsPrompt() {
    return dekagrams.getPromptText();
  }

  @Override
  public void setDekagramsPrompt(String prompt) {
    dekagrams.setPromptText(prompt);
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
  public String getKilogramsPrompt() {
    return kilograms.getPromptText();
  }

  @Override
  public void setKilogramsPrompt(String prompt) {
    kilograms.setPromptText(prompt);
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
  public String getMetricTonsPrompt() {
    return metricTons.getPromptText();
  }

  @Override
  public void setMetricTonsPrompt(String prompt) {
    metricTons.setPromptText(prompt);
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
  public String getGrainsPrompt() {
    return grains.getPromptText();
  }

  @Override
  public void setGrainsPrompt(String prompt) {
    grains.setPromptText(prompt);
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
  public String getDramsPrompt() {
    return drams.getPromptText();
  }

  @Override
  public void setDramsPrompt(String prompt) {
    drams.setPromptText(prompt);
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
  public String getOuncesPrompt() {
    return ounces.getPromptText();
  }

  @Override
  public void setOuncesPrompt(String prompt) {
    ounces.setPromptText(prompt);
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
  public String getPoundsPrompt() {
    return pounds.getPromptText();
  }

  @Override
  public void setPoundsPrompt(String prompt) {
    pounds.setPromptText(prompt);
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
  public String getUkTonsPrompt() {
    return ukTons.getPromptText();
  }

  @Override
  public void setUkTonsPrompt(String prompt) {
    ukTons.setPromptText(prompt);
  }

  @Override
  public String getUkTons() {
    return ukTons.getText();
  }

  @Override
  public void setUkTons(String ukTons) {
    this.ukTons.setText(ukTons);
  }

  @Override
  public String getUsTonsPrompt() {
    return usTons.getPromptText();
  }

  @Override
  public void setUsTonsPrompt(String prompt) {
    this.usTons.setPromptText(prompt);
  }

  @Override
  public String getUsTons() {
    return usTons.getText();
  }

  @Override
  public void setUsTons(String usTons) {
    this.usTons.setText(usTons);
  }

  private void bindMetricTextFieldActionEvents() {
    bindTextFieldActionEvent(milligrams, MILLIGRAM);
    bindTextFieldActionEvent(grams, GRAM);
    bindTextFieldActionEvent(dekagrams, DEKAGRAM);
    bindTextFieldActionEvent(kilograms, KILOGRAM);
    bindTextFieldActionEvent(metricTons, METRIC_TON);
  }

  private void bindNonMetricTextFieldActionEvents() {
    bindTextFieldActionEvent(grains, GRAIN);
    bindTextFieldActionEvent(drams, DRAM);
    bindTextFieldActionEvent(ounces, OUNCE);
    bindTextFieldActionEvent(pounds, POUND);
    bindTextFieldActionEvent(ukTons, UK_TON);
    bindTextFieldActionEvent(usTons, US_TON);
  }

  private void bindTextFieldActionEvent(JFXTextField textField, Mass unit) {
    textField.setOnAction(e -> pushEvent(new MassConversionRequest(textField.getText(), unit)));
  }
}
