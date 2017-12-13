package com.ivanvinski.kunvertuh.presenter;

public interface UnitsPresenter<U> extends Presenter {

  @Override
  void initialize();

  void convert(String sourceValue, U sourceUnit);
}
