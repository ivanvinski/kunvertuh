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

import static com.ivanvinski.kunvertuh.unit.VolumeUnit.CUBIC_METERS;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.FLUID_OUNCES;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.GALLONS;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.LITERS;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.MILLILITERS;
import static com.ivanvinski.kunvertuh.unit.VolumeUnit.PINTS;

import com.ivanvinski.kunvertuh.presenter.VolumeUnitsPresenter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class VolumeUnitsViewImpl extends StackPane implements VolumeUnitsView {

  @FXML
  private Parent root;
  @FXML
  private JFXTextField milliliters, liters, cubicMeters;
  @FXML
  private JFXTextField fluidOunces, pints, gallons;

  @Override
  public void attach(VolumeUnitsPresenter presenter) {
    milliliters.setOnAction(e -> presenter.conversionRequested(getMilliliters(), MILLILITERS));
    liters.setOnAction(e -> presenter.conversionRequested(getLiters(), LITERS));
    cubicMeters.setOnAction(e -> presenter.conversionRequested(getCubicMeters(), CUBIC_METERS));
    fluidOunces.setOnAction(e -> presenter.conversionRequested(getFluidOunces(), FLUID_OUNCES));
    pints.setOnAction(e -> presenter.conversionRequested(getPints(), PINTS));
    gallons.setOnAction(e -> presenter.conversionRequested(getGallons(), GALLONS));
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
  public String getLiters() {
    return liters.getText();
  }

  @Override
  public void setLiters(String liters) {
    this.liters.setText(liters);
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
  public String getFluidOunces() {
    return fluidOunces.getText();
  }

  @Override
  public void setFluidOunces(String fluidOunces) {
    this.fluidOunces.setText(fluidOunces);
  }

  @Override
  public String getPints() {
    return pints.getText();
  }

  @Override
  public void setPints(String pints) {
    this.pints.setText(pints);
  }

  @Override
  public String getGallons() {
    return gallons.getText();
  }

  @Override
  public void setGallons(String gallons) {
    this.gallons.setText(gallons);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }
}
