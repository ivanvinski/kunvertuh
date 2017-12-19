package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.MassUnitsPresenter;

public interface MassUnitsView extends View<MassUnitsPresenter> {

  String getMilligrams();

  void setMilligrams(String milligrams);

  String getGrams();

  void setGrams(String grams);

  String getDekagrams();

  void setDekagrams(String dekagrams);

  String getKilograms();

  void setKilograms(String kilograms);

  String getGrains();

  void setGrains(String grains);

  String getDrams();

  void setDrams(String drams);

  String getOunces();

  void setOunces(String ounces);

  String getPounds();

  void setPounds(String pounds);
}
