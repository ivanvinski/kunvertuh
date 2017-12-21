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

import static com.ivanvinski.kunvertuh.unit.Mass.DEKAGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.DRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.GRAIN;
import static com.ivanvinski.kunvertuh.unit.Mass.GRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.KILOGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.METRIC_TON;
import static com.ivanvinski.kunvertuh.unit.Mass.MILLIGRAM;
import static com.ivanvinski.kunvertuh.unit.Mass.OUNCE;
import static com.ivanvinski.kunvertuh.unit.Mass.POUND;
import static com.ivanvinski.kunvertuh.unit.Mass.UK_TON;
import static com.ivanvinski.kunvertuh.unit.Mass.US_TON;

import com.ivanvinski.kunvertuh.presenter.MassPresenter;
import com.ivanvinski.kunvertuh.unit.Mass;
import com.ivanvinski.kunvertuh.view.MassView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.StackPane;

public final class JFXMassView extends StackPane implements MassView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField milligrams, grams, dekagrams, kilograms, metricTons;
  @FXML
  private JFXTextField grains, drams, ounces, pounds, ukTons, usTons;

  @Override
  public void attach(MassPresenter presenter) {
    bindMetricInputEventsToPresenter(presenter);
    bindNonMetricInputEventsToPresenter(presenter);
  }

  @Override
  public void setMilligramsPrompt(String prompt) {
    milligrams.setPromptText(prompt);
  }

  @Override
  public void setMilligramsValue(String value) {
    milligrams.setText(value);
  }

  @Override
  public void setGramsPrompt(String prompt) {
    grams.setPromptText(prompt);
  }

  @Override
  public void setGramsValue(String value) {
    grams.setText(value);
  }

  @Override
  public void setDekagramsPrompt(String prompt) {
    dekagrams.setPromptText(prompt);
  }

  @Override
  public void setDekagramsValue(String value) {
    dekagrams.setText(value);
  }

  @Override
  public void setKilogramsPrompt(String prompt) {
    kilograms.setPromptText(prompt);
  }

  @Override
  public void setKilogramsValue(String value) {
    kilograms.setText(value);
  }

  @Override
  public void setMetricTonsPrompt(String prompt) {
    metricTons.setPromptText(prompt);
  }

  @Override
  public void setMetricTonsValue(String value) {
    metricTons.setText(value);
  }

  @Override
  public void setGrainsPrompt(String prompt) {
    grains.setPromptText(prompt);
  }

  @Override
  public void setGrainsValue(String value) {
    grains.setText(value);
  }

  @Override
  public void setDramsPrompt(String prompt) {
    drams.setPromptText(prompt);
  }

  @Override
  public void setDramsValue(String value) {
    drams.setText(value);
  }

  @Override
  public void setOuncesPrompt(String prompt) {
    ounces.setPromptText(prompt);
  }

  @Override
  public void setOuncesValue(String value) {
    ounces.setText(value);
  }

  @Override
  public void setPoundsPrompt(String prompt) {
    pounds.setPromptText(prompt);
  }

  @Override
  public void setPoundsValue(String value) {
    pounds.setText(value);
  }

  @Override
  public void setUkTonsPrompt(String prompt) {
    ukTons.setPromptText(prompt);
  }

  @Override
  public void setUkTonsValue(String value) {
    ukTons.setText(value);
  }

  @Override
  public void setUsTonsPrompt(String prompt) {
    usTons.setPromptText(prompt);
  }

  @Override
  public void setUsTonsValue(String value) {
    usTons.setText(value);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }

  private void bindMetricInputEventsToPresenter(MassPresenter presenter) {
    bindInputEventToPresenter(presenter, milligrams, MILLIGRAM);
    bindInputEventToPresenter(presenter, grams, GRAM);
    bindInputEventToPresenter(presenter, dekagrams, DEKAGRAM);
    bindInputEventToPresenter(presenter, kilograms, KILOGRAM);
    bindInputEventToPresenter(presenter, metricTons, METRIC_TON);
  }

  private void bindNonMetricInputEventsToPresenter(MassPresenter presenter) {
    bindInputEventToPresenter(presenter, grains, GRAIN);
    bindInputEventToPresenter(presenter, drams, DRAM);
    bindInputEventToPresenter(presenter, ounces, OUNCE);
    bindInputEventToPresenter(presenter, pounds, POUND);
    bindInputEventToPresenter(presenter, ukTons, UK_TON);
    bindInputEventToPresenter(presenter, usTons, US_TON);
  }

  private void bindInputEventToPresenter(MassPresenter presenter,
      TextInputControl textField, Mass unit) {
    textField.setOnInputMethodTextChanged(e -> presenter
        .conversionRequested(textField.getText(), unit));
  }
}
