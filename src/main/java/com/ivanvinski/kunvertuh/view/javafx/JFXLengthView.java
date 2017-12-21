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

import static com.ivanvinski.kunvertuh.unit.Length.CENTIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.DECIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.FOOT;
import static com.ivanvinski.kunvertuh.unit.Length.INCH;
import static com.ivanvinski.kunvertuh.unit.Length.KILOMETER;
import static com.ivanvinski.kunvertuh.unit.Length.METER;
import static com.ivanvinski.kunvertuh.unit.Length.MILE;
import static com.ivanvinski.kunvertuh.unit.Length.MILLIMETER;
import static com.ivanvinski.kunvertuh.unit.Length.UK_LEAGUE;
import static com.ivanvinski.kunvertuh.unit.Length.US_LEAGUE;
import static com.ivanvinski.kunvertuh.unit.Length.YARD;

import com.ivanvinski.kunvertuh.presenter.LengthPresenter;
import com.ivanvinski.kunvertuh.unit.Length;
import com.ivanvinski.kunvertuh.view.LengthView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.StackPane;

public final class JFXLengthView extends StackPane implements LengthView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField millimeters, centimeters, decimeters, meters, kilometers;
  @FXML
  private JFXTextField inches, feet, yards, miles, ukLeagues, usLeagues;

  @Override
  public void attach(LengthPresenter presenter) {
    bindMetricInputEventsToPresenter(presenter);
    bindNonMetricInputEventsToPresenter(presenter);
  }

  @Override
  public void setMillimetersPrompt(String prompt) {
    millimeters.setPromptText(prompt);
  }

  @Override
  public void setMillimetersValue(String value) {
    millimeters.setText(value);
  }

  @Override
  public void setCentimetersPrompt(String prompt) {
    centimeters.setPromptText(prompt);
  }

  @Override
  public void setCentimetersValue(String value) {
    centimeters.setText(value);
  }

  @Override
  public void setDecimetersPrompt(String prompt) {
    decimeters.setPromptText(prompt);
  }

  @Override
  public void setDecimetersValue(String value) {
    decimeters.setText(value);
  }

  @Override
  public void setMetersPrompt(String prompt) {
    meters.setPromptText(prompt);
  }

  @Override
  public void setMetersValue(String value) {
    meters.setText(value);
  }

  @Override
  public void setKilometersPrompt(String prompt) {
    kilometers.setPromptText(prompt);
  }

  @Override
  public void setKilometersValue(String value) {
    kilometers.setText(value);
  }

  @Override
  public void setInchesPrompt(String prompt) {
    inches.setPromptText(prompt);
  }

  @Override
  public void setInchesValue(String value) {
    inches.setText(value);
  }

  @Override
  public void setFeetPrompt(String prompt) {
    feet.setPromptText(prompt);
  }

  @Override
  public void setFeetValue(String value) {
    feet.setText(value);
  }

  @Override
  public void setYardsPrompt(String prompt) {
    yards.setPromptText(prompt);
  }

  @Override
  public void setYardsValue(String value) {
    yards.setText(value);
  }

  @Override
  public void setMilesPrompt(String prompt) {
    miles.setPromptText(prompt);
  }

  @Override
  public void setMilesValue(String value) {
    miles.setText(value);
  }

  @Override
  public void setUkLeaguesPrompt(String prompt) {
    ukLeagues.setPromptText(prompt);
  }

  @Override
  public void setUkLeaguesValue(String value) {
    ukLeagues.setText(value);
  }

  @Override
  public void setUsLeaguesPrompt(String prompt) {
    usLeagues.setPromptText(prompt);
  }

  @Override
  public void setUsLeaguesValue(String value) {
    usLeagues.setText(value);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }

  private void bindMetricInputEventsToPresenter(LengthPresenter presenter) {
    bindInputEventToPresenter(presenter, millimeters, MILLIMETER);
    bindInputEventToPresenter(presenter, centimeters, CENTIMETER);
    bindInputEventToPresenter(presenter, decimeters, DECIMETER);
    bindInputEventToPresenter(presenter, meters, METER);
    bindInputEventToPresenter(presenter, kilometers, KILOMETER);
  }

  private void bindNonMetricInputEventsToPresenter(LengthPresenter presenter) {
    bindInputEventToPresenter(presenter, inches, INCH);
    bindInputEventToPresenter(presenter, feet, FOOT);
    bindInputEventToPresenter(presenter, yards, YARD);
    bindInputEventToPresenter(presenter, miles, MILE);
    bindInputEventToPresenter(presenter, ukLeagues, UK_LEAGUE);
    bindInputEventToPresenter(presenter, usLeagues, US_LEAGUE);
  }

  private void bindInputEventToPresenter(LengthPresenter presenter,
      TextInputControl textField, Length unit) {
    textField.setOnInputMethodTextChanged(e -> presenter
        .conversionRequested(textField.getText(), unit));
  }
}
