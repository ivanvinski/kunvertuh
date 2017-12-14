package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;

public interface VolumeUnitsView extends View {

  String getMilliliters();

  void setMilliliters(String milliliters);

  void setOnMillilitersActionEvent(Consumer<String> actionConsumer);

  String getLiters();

  void setLiters(String liters);

  void setOnLitersActionEvent(Consumer<String> actionConsumer);

  String getCubicMeters();

  void setCubicMeters(String cubicMeters);

  void setOnCubicMetersActionEvent(Consumer<String> actionConsumer);

  String getFluidOunces();

  void setFluidOunces(String fluidOunces);

  void setOnFluidOuncesActionEvent(Consumer<String> actionConsumer);

  String getPints();

  void setPints(String pints);

  void setOnPintsActionEvent(Consumer<String> actionConsumer);

  String getGallons();

  void setGallons(String gallons);

  void setOnGallonsActionEvent(Consumer<String> actionConsumer);
}
