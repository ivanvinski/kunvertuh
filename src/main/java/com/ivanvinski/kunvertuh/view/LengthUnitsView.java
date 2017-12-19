package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.LengthUnitsPresenter;

public interface LengthUnitsView extends View<LengthUnitsPresenter> {

  String getMillimeters();

  void setMillimeters(String millimeters);

  String getCentimeters();

  void setCentimeters(String centimeters);

  String getDecimeters();

  void setDecimeters(String decimeters);

  String getMeters();

  void setMeters(String meters);

  String getKilometers();

  void setKilometers(String kilometers);

  String getInches();

  void setInches(String inches);

  String getFeet();

  void setFeet(String feet);

  String getYards();

  void setYards(String yards);

  String getMiles();

  void setMiles(String miles);
}
