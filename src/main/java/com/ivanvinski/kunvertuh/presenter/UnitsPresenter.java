package com.ivanvinski.kunvertuh.presenter;

public interface UnitsPresenter<U> {

  void convert(String sourceValue, U sourceUnit);
}
