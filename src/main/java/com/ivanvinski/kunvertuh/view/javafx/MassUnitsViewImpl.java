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

import static com.ivanvinski.kunvertuh.unit.MassUnit.DEKAGRAMS;
import static com.ivanvinski.kunvertuh.unit.MassUnit.DRAMS;
import static com.ivanvinski.kunvertuh.unit.MassUnit.GRAINS;
import static com.ivanvinski.kunvertuh.unit.MassUnit.GRAMS;
import static com.ivanvinski.kunvertuh.unit.MassUnit.KILOGRAMS;
import static com.ivanvinski.kunvertuh.unit.MassUnit.MILLIGRAMS;
import static com.ivanvinski.kunvertuh.unit.MassUnit.OUNCES;
import static com.ivanvinski.kunvertuh.unit.MassUnit.POUNDS;

import com.ivanvinski.kunvertuh.presenter.MassUnitsPresenter;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import com.jfoenix.controls.JFXTextField;
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

  @Override
  public void attach(MassUnitsPresenter presenter) {
    milligrams.setOnAction(e -> presenter.conversionRequested(getMilligrams(), MILLIGRAMS));
    grams.setOnAction(e -> presenter.conversionRequested(getGrams(), GRAMS));
    dekagrams.setOnAction(e -> presenter.conversionRequested(getDekagrams(), DEKAGRAMS));
    kilograms.setOnAction(e -> presenter.conversionRequested(getKilograms(), KILOGRAMS));
    grains.setOnAction(e -> presenter.conversionRequested(getGrams(), GRAINS));
    drams.setOnAction(e -> presenter.conversionRequested(getDrams(), DRAMS));
    ounces.setOnAction(e -> presenter.conversionRequested(getOunces(), OUNCES));
    pounds.setOnAction(e -> presenter.conversionRequested(getPounds(), POUNDS));
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
  public String getGrams() {
    return grams.getText();
  }

  @Override
  public void setGrams(String grams) {
    this.grams.setText(grams);
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
  public String getKilograms() {
    return kilograms.getText();
  }

  @Override
  public void setKilograms(String kilograms) {
    this.kilograms.setText(kilograms);
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
  public String getDrams() {
    return drams.getText();
  }

  @Override
  public void setDrams(String drams) {
    this.drams.setText(drams);
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
  public String getPounds() {
    return pounds.getText();
  }

  @Override
  public void setPounds(String pounds) {
    this.pounds.setText(pounds);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }
}
