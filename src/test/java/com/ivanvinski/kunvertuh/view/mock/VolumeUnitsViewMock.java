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

import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VolumeUnitsViewMock implements VolumeUnitsView {

  private StringProperty milliliters, liters, cubicMeters;
  private Consumer<String> millilitersAction, litersAction, cubicMetersAction;
  private StringProperty fluidOunces, pints, gallons;
  private Consumer<String> fluidOuncesAction, pintsAction, gallonsAction;

  public VolumeUnitsViewMock() {
    milliliters = newStringProperty();
    liters = newStringProperty();
    cubicMeters = newStringProperty();
    fluidOunces = newStringProperty();
    pints = newStringProperty();
    gallons = newStringProperty();
  }

  @Override
  public String getMilliliters() {
    return milliliters.getValue();
  }

  @Override
  public void setMilliliters(String milliliters) {
    this.milliliters.setValue(milliliters);
  }

  @Override
  public void setOnMillilitersActionEvent(Consumer<String> actionConsumer) {
    millilitersAction = actionConsumer;
  }

  public void fireMillilitersActionEvent() {
    millilitersAction.accept(getMilliliters());
  }

  @Override
  public String getLiters() {
    return liters.getValue();
  }

  @Override
  public void setLiters(String liters) {
    this.liters.setValue(liters);
  }

  @Override
  public void setOnLitersActionEvent(Consumer<String> actionConsumer) {
    litersAction = actionConsumer;
  }

  public void fireLitersActionEvent() {
    litersAction.accept(getLiters());
  }

  @Override
  public String getCubicMeters() {
    return cubicMeters.getValue();
  }

  @Override
  public void setCubicMeters(String cubicMeters) {
    this.cubicMeters.setValue(cubicMeters);
  }

  @Override
  public void setOnCubicMetersActionEvent(Consumer<String> actionConsumer) {
    cubicMetersAction = actionConsumer;
  }

  public void fireCubicMetersActionEvent() {
    cubicMetersAction.accept(getCubicMeters());
  }

  @Override
  public String getFluidOunces() {
    return fluidOunces.getValue();
  }

  @Override
  public void setFluidOunces(String fluidOunces) {
    this.fluidOunces.setValue(fluidOunces);
  }

  @Override
  public void setOnFluidOuncesActionEvent(Consumer<String> actionConsumer) {
    fluidOuncesAction = actionConsumer;
  }

  public void fireFluidOuncesActionEvent() {
    fluidOuncesAction.accept(getFluidOunces());
  }

  @Override
  public String getPints() {
    return pints.getValue();
  }

  @Override
  public void setPints(String pints) {
    this.pints.setValue(pints);
  }

  @Override
  public void setOnPintsActionEvent(Consumer<String> actionConsumer) {
    pintsAction = actionConsumer;
  }

  public void firePintsActionEvent() {
    pintsAction.accept(getPints());
  }

  @Override
  public String getGallons() {
    return gallons.getValue();
  }

  @Override
  public void setGallons(String gallons) {
    this.gallons.setValue(gallons);
  }

  @Override
  public void setOnGallonsActionEvent(Consumer<String> actionConsumer) {
    gallonsAction = actionConsumer;
  }

  public void fireGallonsActionEvent() {
    gallonsAction.accept(getGallons());
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
