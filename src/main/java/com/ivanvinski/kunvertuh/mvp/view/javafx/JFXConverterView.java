/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.mvp.view.javafx;

import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.mvp.view.ConverterView;
import com.jfoenix.controls.JFXTextField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class JFXConverterView<U extends Unit> extends StackPane implements ConverterView<U> {

  private Map<U, JFXTextField> unitFields = new HashMap<>();
  private Map<U, Consumer<String>> conversionActions = new HashMap<>();

  @FXML
  private VBox cards;

  @Override
  public void initialize() {
  }

  @Override
  public void appendUnitsCard(List<U> leftColumn, List<U> rightColumn) {
    GridPane card = new GridPane();
    card.getStyleClass().addAll("card", "unit-card");
    for (int i = 0; i < leftColumn.size(); i++) {
      card.add(constructUnitField(leftColumn.get(i)), 0, i);
    }
    for (int i = 0; i < rightColumn.size(); i++) {
      card.add(constructUnitField(rightColumn.get(i)), 1, i);
    }
    cards.getChildren().add(card);
  }

  @Override
  public String getUnitPrompt(U unit) {
    return unitFields.get(unit).getPromptText();
  }

  @Override
  public void setUnitPrompt(U unit, String prompt) {
    unitFields.get(unit).setPromptText(prompt);
  }

  @Override
  public String getUnitValue(U unit) {
    return unitFields.get(unit).getText();
  }

  @Override
  public void setUnitValue(U unit, String value) {
    unitFields.get(unit).setText(value);
  }

  @Override
  public Consumer<String> getOnConversionAction(U unit) {
    return conversionActions.get(unit);
  }

  @Override
  public void setOnConversionAction(U unit, Consumer<String> conversionAction) {
    JFXTextField unitField = unitFields.get(unit);
    unitField.setOnAction(e -> conversionAction.accept(unitField.getText()));
    conversionActions.put(unit, conversionAction);
  }

  protected JFXTextField constructUnitField(U unit) {
    JFXTextField unitField = new JFXTextField();
    GridPane.setHgrow(unitField, Priority.ALWAYS);
    GridPane.setVgrow(unitField, Priority.ALWAYS);
    unitField.setMaxWidth(Double.MAX_VALUE);
    unitField.setPromptText(unit.toString());
    unitFields.put(unit, unitField);
    return unitField;
  }
}
