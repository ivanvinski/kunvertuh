package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;

public interface MassUnitsView extends View {

  String getGrams();

  void setGrams(String grams);

  void setOnGramsActionEvent(Consumer<String> actionConsumer);

  String getKilograms();

  void setKilograms(String kilograms);

  void setOnKilogramsActionEvent(Consumer<String> actionConsumer);

  String getMetricTons();

  void setMetricTons(String metricTons);

  void setOnMetricTonsActionEvent(Consumer<String> actionConsumer);

  String getOunces();

  void setOunces(String ounces);

  void setOnOuncesActionEvent(Consumer<String> actionConsumer);

  String getPounds();

  void setPounds(String pounds);

  void setOnPoundsActionEvent(Consumer<String> actionConsumer);

  String getImperialTons();

  void setImperialTons(String imperialTons);

  void setOnImperialTonsActionEvent(Consumer<String> actionConsumer);
}
