package com.ivanvinski.kunvertuh.view;

import java.util.function.Consumer;

public interface MassUnitsView extends View {

  String getMilligrams();

  void setMilligrams(String milligrams);

  void setOnMilligramsActionEvent(Consumer<String> actionConsumer);

  String getGrams();

  void setGrams(String grams);

  void setOnGramsActionEvent(Consumer<String> actionConsumer);

  String getDekagrams();

  void setDekagrams(String dekagrams);

  void setOnDekagramsActionEvent(Consumer<String> actionConsumer);

  String getKilograms();

  void setKilograms(String kilograms);

  void setOnKilogramsActionEvent(Consumer<String> actionConsumer);

  String getGrains();

  void setGrains(String grains);

  void setOnGrainsActionEvent(Consumer<String> actionConsumer);

  String getDrams();

  void setDrams(String drams);

  void setOnDramsActionEvent(Consumer<String> actionConsumer);

  String getOunces();

  void setOunces(String ounces);

  void setOnOuncesActionEvent(Consumer<String> actionConsumer);

  String getPounds();

  void setPounds(String pounds);

  void setOnPoundsActionEvent(Consumer<String> actionConsumer);
}
