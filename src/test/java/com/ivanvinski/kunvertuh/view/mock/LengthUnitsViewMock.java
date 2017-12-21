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

package com.ivanvinski.kunvertuh.view.mock;

import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LengthUnitsViewMock implements LengthUnitsView {

  private StringProperty millimeters, centimeters, decimeters, meters, kilometers;
  private Consumer<String> millimetersAction, centimetersAction, decimetersAction, metersAction, kilometersAction;
  private StringProperty inches, feet, yards, miles;
  private Consumer<String> inchesAction, feetAction, yardsAction, milesAction;

  public LengthUnitsViewMock() {
    millimeters = newStringProperty();
    centimeters = newStringProperty();
    decimeters = newStringProperty();
    meters = newStringProperty();
    kilometers = newStringProperty();
    inches = newStringProperty();
    feet = newStringProperty();
    yards = newStringProperty();
    miles = newStringProperty();
  }

  @Override
  public String getMillimeters() {
    return millimeters.getValue();
  }

  @Override
  public void setMillimeters(String millimeters) {
    this.millimeters.setValue(millimeters);
  }

  @Override
  public void setOnMillimetersActionEvent(Consumer<String> actionConsumer) {
    millimetersAction = actionConsumer;
  }

  public void fireMillimetersActionEvent() {
    millimetersAction.accept(getMillimeters());
  }

  @Override
  public String getCentimeters() {
    return centimeters.getValue();
  }

  @Override
  public void setCentimeters(String centimeters) {
    this.centimeters.setValue(centimeters);
  }

  @Override
  public void setOnCentimetersActionEvent(Consumer<String> actionConsumer) {
    centimetersAction = actionConsumer;
  }

  public void fireCentimetersActionEvent() {
    centimetersAction.accept(getCentimeters());
  }

  @Override
  public String getDecimeters() {
    return decimeters.getValue();
  }

  @Override
  public void setDecimeters(String decimeters) {
    this.decimeters.setValue(decimeters);
  }

  @Override
  public void setOnDecimetersActionEvent(Consumer<String> actionConsumer) {
    decimetersAction = actionConsumer;
  }

  public void fireDecimetersActionEvent() {
    decimetersAction.accept(getDecimeters());
  }

  @Override
  public String getMeters() {
    return meters.getValue();
  }

  @Override
  public void setMeters(String meters) {
    this.meters.setValue(meters);
  }

  @Override
  public void setOnMetersActionEvent(Consumer<String> actionConsumer) {
    metersAction = actionConsumer;
  }

  public void fireMetersActionEvent() {
    metersAction.accept(getMeters());
  }

  @Override
  public String getKilometers() {
    return kilometers.getValue();
  }

  @Override
  public void setKilometers(String kilometers) {
    this.kilometers.setValue(kilometers);
  }

  @Override
  public void setOnKilometersActionEvent(Consumer<String> actionConsumer) {
    kilometersAction = actionConsumer;
  }

  public void fireKilometersActionEvent() {
    kilometersAction.accept(getKilometers());
  }

  @Override
  public String getInches() {
    return inches.getValue();
  }

  @Override
  public void setInches(String inches) {
    this.inches.setValue(inches);
  }

  @Override
  public void setOnInchesActionEvent(Consumer<String> actionConsumer) {
    inchesAction = actionConsumer;
  }

  public void fireInchesActionEvent() {
    inchesAction.accept(getInches());
  }

  @Override
  public String getFeet() {
    return feet.getValue();
  }

  @Override
  public void setFeet(String feet) {
    this.feet.setValue(feet);
  }

  @Override
  public void setOnFeetChanged(Consumer<String> actionConsumer) {
    feetAction = actionConsumer;
  }

  public void fireFeetActionEvent() {
    feetAction.accept(getFeet());
  }

  @Override
  public String getYards() {
    return yards.getValue();
  }

  @Override
  public void setYards(String yards) {
    this.yards.setValue(yards);
  }

  @Override
  public void setOnYardsChanged(Consumer<String> actionConsumer) {
    yardsAction = actionConsumer;
  }

  public void fireYardsActionEvent() {
    yardsAction.accept(getYards());
  }

  @Override
  public String getMiles() {
    return miles.getValue();
  }

  @Override
  public void setMiles(String miles) {
    this.miles.setValue(miles);
  }

  @Override
  public void setOnMilesChanged(Consumer<String> actionConsumer) {
    milesAction = actionConsumer;
  }

  public void fireMilesActionEvent() {
    milesAction.accept(getMiles());
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
