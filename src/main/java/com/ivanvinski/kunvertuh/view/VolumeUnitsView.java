package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;

public interface VolumeUnitsView {

  String getLiters();

  void setLiters(String liters);

  void setOnLitersActionEvent(Consumer<String> actionConsumer);

  String getCubicMeters();

  void setCubicMeters(String cubicMeters);

  void setOnCubicMetersActionEvent(Consumer<String> actionConsumer);

  String getGallons();

  void setGallons(String gallons);

  void setOnGallonsActionEvent(Consumer<String> actionConsumer);

  String getCubicInches();

  void setCubicInches(String cubicInches);

  void setOnCubicInchesActionEvent(Consumer<String> actionConsumer);
}
