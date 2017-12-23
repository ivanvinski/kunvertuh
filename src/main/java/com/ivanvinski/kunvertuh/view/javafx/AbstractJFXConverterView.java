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

import com.ivanvinski.kunvertuh.event.ConversionRequest;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.measurement.MeasurementSystem;
import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.view.ConverterView;
import com.jfoenix.controls.JFXTextField;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public abstract class AbstractJFXConverterView<U extends Unit> extends AbstractJFXView implements
    ConverterView<U> {

  private Map<MeasurementSystem, Label> containerTitles = new HashMap<>();
  private Map<MeasurementSystem, VBox> inputContainers = new HashMap<>();
  private Map<Unit, JFXTextField> inputControls = new HashMap<>();

  public AbstractJFXConverterView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void initialize(Collection<U> supportedUnits) {
    Arrays.stream(MeasurementSystem.values()).forEachOrdered(this::registerInputContainerFor);
    supportedUnits.forEach(this::registerInputFor);
  }

  @Override
  public String getTitle(MeasurementSystem system) {
    return containerTitles.get(system).getText();
  }

  @Override
  public void setTitle(MeasurementSystem system, String title) {
    containerTitles.get(system).setText(title);
  }

  @Override
  public String getPrompt(U unit) {
    return inputControls.get(unit).getPromptText();
  }

  @Override
  public void setPrompt(U unit, String prompt) {
    inputControls.get(unit).setPromptText(prompt);
  }

  @Override
  public String getValue(U unit) {
    return inputControls.get(unit).getText();
  }

  @Override
  public void setValue(U unit, String value) {
    inputControls.get(unit).setText(value);
  }

  protected abstract ObservableList<Node> getCardContainerChildren();

  private void registerInputContainerFor(MeasurementSystem system) {
    Label containerTitle = new Label(system.toString());
    containerTitle.getStyleClass().add("subheading");
    VBox container = new VBox();
    container.getStyleClass().addAll("card", "unit-card");
    getCardContainerChildren().addAll(containerTitle, container);
    containerTitles.put(system, containerTitle);
    inputContainers.put(system, container);
  }

  private void registerInputFor(U unit) {
    JFXTextField input = new JFXTextField();
    input.setPromptText(unit.toString());
    input.setOnAction(e -> pushEvent(new ConversionRequest(input.getText(), unit)));
    inputContainers.get(unit.getSystem()).getChildren().add(input);
    inputControls.put(unit, input);
  }
}
