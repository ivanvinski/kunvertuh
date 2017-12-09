package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;

public interface LengthUnitsView {

  String getMillimeters();

  void setMillimeters(String millimeters);

  void setOnMillimetersActionEvent(Consumer<String> actionConsumer);

  String getCentimeters();

  void setCentimeters(String centimeters);

  void setOnCentimetersActionEvent(Consumer<String> actionConsumer);

  String getMeters();

  void setMeters(String meters);

  void setOnMetersActionEvent(Consumer<String> actionConsumer);

  String getKilometers();

  void setKilometers(String kilometers);

  void setOnKilometersActionEvent(Consumer<String> actionConsumer);

  String getInches();

  void setInches(String inches);

  void setOnInchesActionEvent(Consumer<String> actionConsumer);

  String getFeet();

  void setFeet(String feet);

  void setOnFeetChanged(Consumer<String> actionConsumer);

  String getYards();

  void setYards(String yards);

  void setOnYardsChanged(Consumer<String> actionConsumer);

  String getMiles();

  void setMiles(String miles);

  void setOnMilesChanged(Consumer<String> actionConsumer);
}
