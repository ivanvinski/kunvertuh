package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.VolumeUnitsPresenter;

public interface VolumeUnitsView extends View<VolumeUnitsPresenter> {

  String getMilliliters();

  void setMilliliters(String milliliters);

  String getLiters();

  void setLiters(String liters);

  String getCubicMeters();

  void setCubicMeters(String cubicMeters);

  String getFluidOunces();

  void setFluidOunces(String fluidOunces);

  String getPints();

  void setPints(String pints);

  String getGallons();

  void setGallons(String gallons);
}
