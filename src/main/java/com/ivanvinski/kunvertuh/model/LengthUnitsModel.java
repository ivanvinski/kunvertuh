package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import java.math.BigDecimal;
import java.util.Objects;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;

public final class LengthUnitsModel {

  private ReadOnlyObjectWrapper<BigDecimal> millimeters, centimeters, meters, kilometers;
  private ReadOnlyObjectWrapper<BigDecimal> inches, feet, yards, miles;

  public LengthUnitsModel() {
    millimeters = newBigDecimalProperty();
    centimeters = newBigDecimalProperty();
    meters = newBigDecimalProperty();
    kilometers = newBigDecimalProperty();
    inches = newBigDecimalProperty();
    feet = newBigDecimalProperty();
    yards = newBigDecimalProperty();
    miles = newBigDecimalProperty();
  }

  public void convert(BigDecimal sourceLength, LengthUnit sourceUnit) {
    Objects.requireNonNull(sourceUnit, "Can't convert null length unit");
    millimeters.setValue(sourceUnit.toMillimeters(sourceLength));
    centimeters.setValue(sourceUnit.toCentimeters(sourceLength));
    meters.setValue(sourceUnit.toMeters(sourceLength));
    kilometers.setValue(sourceUnit.toKilometers(sourceLength));
    inches.setValue(sourceUnit.toInches(sourceLength));
    feet.setValue(sourceUnit.toFeet(sourceLength));
    yards.setValue(sourceUnit.toYards(sourceLength));
    miles.setValue(sourceUnit.toMiles(sourceLength));
  }

  public ReadOnlyObjectProperty<BigDecimal> millimetersProperty() {
    return millimeters.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> centimetersProperty() {
    return centimeters.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> metersProperty() {
    return meters.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> kilometersProperty() {
    return kilometers.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> inchesProperty() {
    return inches.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> feetProperty() {
    return feet.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> yardsProperty() {
    return yards.getReadOnlyProperty();
  }

  public ReadOnlyObjectProperty<BigDecimal> milesProperty() {
    return miles.getReadOnlyProperty();
  }

  private ReadOnlyObjectWrapper<BigDecimal> newBigDecimalProperty() {
    return new ReadOnlyObjectWrapper<>(new BigDecimal(0d));
  }
}
