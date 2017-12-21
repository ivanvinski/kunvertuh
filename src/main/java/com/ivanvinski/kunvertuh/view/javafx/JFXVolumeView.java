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

import com.ivanvinski.kunvertuh.presenter.VolumePresenter;
import com.ivanvinski.kunvertuh.unit.Volume;
import com.ivanvinski.kunvertuh.view.VolumeView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public final class JFXVolumeView extends StackPane implements VolumeView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField milliliters, deciliters, liters, hectoliters, cubicMeters;
  @FXML
  private JFXTextField ukTeaspoons, ukTablespoons, ukCups, ukFluidOunces, ukPints, ukGallons;
  @FXML
  private JFXTextField usTeaspoons, usTablespoons, usCups, usFluidOunces, usPints, usGallons;
  @FXML
  private JFXTextField cubicInches;

  @Override
  public void attach(VolumePresenter presenter) {
    bindMetricInputEventsToPresenter(presenter);
    bindImperialInputEventsToPresenter(presenter);
    bindUsInputEventsToPresenter(presenter);
    bindInputEventToPresenter(presenter, cubicInches, CUBIC_INCH);
  }

  @Override
  public void setMillilitersPrompt(String prompt) {
    milliliters.setPromptText(prompt);
  }

  @Override
  public void setMillilitersValue(String value) {
    milliliters.setText(value);
  }

  @Override
  public void setDecilitersPrompt(String prompt) {
    deciliters.setPromptText(prompt);
  }

  @Override
  public void setDecilitersValue(String value) {
    deciliters.setText(value);
  }

  @Override
  public void setLitersPrompt(String prompt) {
    liters.setPromptText(prompt);
  }

  @Override
  public void setLitersValue(String value) {
    liters.setText(value);
  }

  @Override
  public void setHectolitersPrompt(String prompt) {
    hectoliters.setPromptText(prompt);
  }

  @Override
  public void setHectolitersValue(String value) {
    hectoliters.setText(value);
  }

  @Override
  public void setCubicMetersPrompt(String prompt) {
    cubicMeters.setPromptText(prompt);
  }

  @Override
  public void setCubicMetersValue(String value) {
    cubicMeters.setText(value);
  }

  @Override
  public void setUkTeaspoonsPrompt(String prompt) {
    ukTeaspoons.setPromptText(prompt);
  }

  @Override
  public void setUkTeaspoonsValue(String value) {
    ukTeaspoons.setText(value);
  }

  @Override
  public void setUkTablespoonsPrompt(String prompt) {
    ukTablespoons.setPromptText(prompt);
  }

  @Override
  public void setUkTablespoonsValue(String value) {
    ukTablespoons.setText(value);
  }

  @Override
  public void setUkCupsPrompt(String prompt) {
    ukCups.setPromptText(prompt);
  }

  @Override
  public void setUkCupsValue(String value) {
    ukCups.setText(value);
  }

  @Override
  public void setUkFluidOuncesPrompt(String prompt) {
    ukFluidOunces.setPromptText(prompt);
  }

  @Override
  public void setUkFluidOuncesValue(String value) {
    ukFluidOunces.setText(value);
  }

  @Override
  public void setUkPintsPrompt(String prompt) {
    ukPints.setPromptText(prompt);
  }

  @Override
  public void setUkPintsValue(String value) {
    ukPints.setText(value);
  }

  @Override
  public void setUkGallonsPrompt(String prompt) {
    ukGallons.setPromptText(prompt);
  }

  @Override
  public void setUkGallonsValue(String value) {
    ukGallons.setText(value);
  }

  @Override
  public void setUsTeaspoonsPrompt(String prompt) {
    usTeaspoons.setPromptText(prompt);
  }

  @Override
  public void setUsTeaspoonsValue(String value) {
    usTeaspoons.setText(value);
  }

  @Override
  public void setUsTablespoonsPrompt(String prompt) {
    usTablespoons.setPromptText(prompt);
  }

  @Override
  public void setUsTablespoonsValue(String value) {
    usTablespoons.setText(value);
  }

  @Override
  public void setUsCupsPrompt(String prompt) {
    usCups.setPromptText(prompt);
  }

  @Override
  public void setUsCupsValue(String value) {
    usCups.setText(value);
  }

  @Override
  public void setUsFluidOuncesPrompt(String prompt) {
    usFluidOunces.setPromptText(prompt);
  }

  @Override
  public void setUsFluidOuncesValue(String value) {
    usFluidOunces.setText(value);
  }

  @Override
  public void setUsPintsPrompt(String prompt) {
    usPints.setPromptText(prompt);
  }

  @Override
  public void setUsPintsValue(String value) {
    usPints.setText(value);
  }

  @Override
  public void setUsGallonsPrompt(String prompt) {
    usGallons.setPromptText(prompt);
  }

  @Override
  public void setUsGallonsValue(String value) {
    usGallons.setText(value);
  }

  @Override
  public void setCubicInchesPrompt(String prompt) {
    cubicInches.setPromptText(prompt);
  }

  @Override
  public void setCubicInchesValue(String value) {
    cubicInches.setText(value);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }

  private void bindMetricInputEventsToPresenter(VolumePresenter presenter) {
    bindInputEventToPresenter(presenter, milliliters, MILLILITER);
    bindInputEventToPresenter(presenter, deciliters, DECILITER);
    bindInputEventToPresenter(presenter, liters, LITER);
    bindInputEventToPresenter(presenter, hectoliters, HECTOLITER);
    bindInputEventToPresenter(presenter, cubicMeters, CUBIC_METER);
  }

  private void bindImperialInputEventsToPresenter(VolumePresenter presenter) {
    bindInputEventToPresenter(presenter, ukTeaspoons, UK_TEASPOON);
    bindInputEventToPresenter(presenter, ukTablespoons, UK_TABLESPOON);
    bindInputEventToPresenter(presenter, ukCups, UK_CUP);
    bindInputEventToPresenter(presenter, ukFluidOunces, UK_FLUID_OUNCE);
    bindInputEventToPresenter(presenter, ukPints, UK_PINT);
    bindInputEventToPresenter(presenter, ukGallons, UK_GALLON);
  }

  private void bindUsInputEventsToPresenter(VolumePresenter presenter) {
    bindInputEventToPresenter(presenter, usTeaspoons, US_TEASPOON);
    bindInputEventToPresenter(presenter, usTablespoons, US_TABLESPOON);
    bindInputEventToPresenter(presenter, usCups, US_CUP);
    bindInputEventToPresenter(presenter, usFluidOunces, US_FLUID_OUNCE);
    bindInputEventToPresenter(presenter, usPints, US_PINT);
    bindInputEventToPresenter(presenter, usGallons, US_GALLON);
  }

  private void bindInputEventToPresenter(VolumePresenter presenter, JFXTextField textField,
      Volume unit) {
    textField.setOnAction(e -> presenter
        .conversionRequested(textField.getText(), unit));
  }
}
