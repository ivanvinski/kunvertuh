package com.ivanvinski.kunvertuh.mvp.view.javafx;

import com.ivanvinski.kunvertuh.measurement.MeasurementSystem;
import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.mvp.view.ConverterView;
import com.jfoenix.controls.JFXTextField;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class JFXConverterView<U extends Unit> extends StackPane implements ConverterView<U> {

  private U[] units;
  private Map<U, JFXTextField> unitFields = new HashMap<>();

  @FXML
  private VBox metricUnits, otherUnits;

  public JFXConverterView(U[] units) {
    this.units = Objects.requireNonNull(units, "Converter view can't operate with null units");
  }

  @Override
  public void initialize() {
    Arrays.stream(units).forEachOrdered(this::constructUnitField);
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
  public void setOnConversionAction(U unit, Consumer<String> valueConsumer) {
    JFXTextField unitField = unitFields.get(unit);
    unitField.setOnAction(e -> valueConsumer.accept(unitField.getText()));
  }

  protected void constructUnitField(U unit) {
    JFXTextField unitField = new JFXTextField();
    unitField.setPromptText(unit.toString());
    getUnitFieldContainerFor(unit).getChildren().add(unitField);
    unitFields.put(unit, unitField);
  }

  protected VBox getUnitFieldContainerFor(U unit) {
    return unit.getSystem() == MeasurementSystem.METRIC ? metricUnits : otherUnits;
  }
}
