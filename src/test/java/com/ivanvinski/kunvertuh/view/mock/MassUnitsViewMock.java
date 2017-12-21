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

import com.ivanvinski.kunvertuh.view.MassUnitsView;
import java.util.function.Consumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MassUnitsViewMock implements MassUnitsView {

  private StringProperty milligrams, grams, dekagrams, kilograms;
  private Consumer<String> milligramsAction, gramsAction, dekagramsAction, kilogramsAction;
  private StringProperty grains, drams, ounces, pounds;
  private Consumer<String> grainsAction, dramsAction, ouncesAction, poundsAction;

  public MassUnitsViewMock() {
    milligrams = newStringProperty();
    grams = newStringProperty();
    dekagrams = newStringProperty();
    kilograms = newStringProperty();
    grains = newStringProperty();
    drams = newStringProperty();
    ounces = newStringProperty();
    pounds = newStringProperty();
  }

  @Override
  public String getMilligrams() {
    return milligrams.getValue();
  }

  @Override
  public void setMilligrams(String milligrams) {
    this.milligrams.setValue(milligrams);
  }

  @Override
  public void setOnMilligramsActionEvent(Consumer<String> actionConsumer) {
    milligramsAction = actionConsumer;
  }

  public void fireMilligramsActionEvent() {
    milligramsAction.accept(getMilligrams());
  }

  @Override
  public String getGrams() {
    return grams.getValue();
  }

  @Override
  public void setGrams(String grams) {
    this.grams.setValue(grams);
  }

  @Override
  public void setOnGramsActionEvent(Consumer<String> actionConsumer) {
    gramsAction = actionConsumer;
  }

  public void fireGramsActionEvent() {
    gramsAction.accept(getGrams());
  }

  @Override
  public String getDekagrams() {
    return dekagrams.getValue();
  }

  @Override
  public void setDekagrams(String dekagrams) {
    this.dekagrams.setValue(dekagrams);
  }

  @Override
  public void setOnDekagramsActionEvent(Consumer<String> actionConsumer) {
    dekagramsAction = actionConsumer;
  }

  public void fireDekagramsActionEvent() {
    dekagramsAction.accept(getDekagrams());
  }

  @Override
  public String getKilograms() {
    return kilograms.getValue();
  }

  @Override
  public void setKilograms(String kilograms) {
    this.kilograms.setValue(kilograms);
  }

  @Override
  public void setOnKilogramsActionEvent(Consumer<String> actionConsumer) {
    kilogramsAction = actionConsumer;
  }

  public void fireKilogramsActionEvent() {
    kilogramsAction.accept(getKilograms());
  }

  @Override
  public String getGrains() {
    return grains.getValue();
  }

  @Override
  public void setGrains(String grains) {
    this.grains.setValue(grains);
  }

  @Override
  public void setOnGrainsActionEvent(Consumer<String> actionConsumer) {
    grainsAction = actionConsumer;
  }

  public void fireGrainsActionEvent() {
    grainsAction.accept(getGrains());
  }

  @Override
  public String getDrams() {
    return drams.getValue();
  }

  @Override
  public void setDrams(String drams) {
    this.drams.setValue(drams);
  }

  @Override
  public void setOnDramsActionEvent(Consumer<String> actionConsumer) {
    dramsAction = actionConsumer;
  }

  public void fireDramsActionEvent() {
    dramsAction.accept(getDrams());
  }

  @Override
  public String getOunces() {
    return ounces.getValue();
  }

  @Override
  public void setOunces(String ounces) {
    this.ounces.setValue(ounces);
  }

  @Override
  public void setOnOuncesActionEvent(Consumer<String> actionConsumer) {
    ouncesAction = actionConsumer;
  }

  public void fireOuncesActionEvent() {
    ouncesAction.accept(getOunces());
  }

  @Override
  public String getPounds() {
    return pounds.getValue();
  }

  @Override
  public void setPounds(String pounds) {
    this.pounds.setValue(pounds);
  }

  @Override
  public void setOnPoundsActionEvent(Consumer<String> actionConsumer) {
    poundsAction = actionConsumer;
  }

  public void firePoundsActionEvent() {
    poundsAction.accept(getPounds());
  }

  private StringProperty newStringProperty() {
    return new SimpleStringProperty("");
  }
}
