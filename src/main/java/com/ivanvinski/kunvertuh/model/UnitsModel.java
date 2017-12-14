package com.ivanvinski.kunvertuh.model;

public interface UnitsModel<U> {

  void convert(Double sourceValue, U sourceUnit);
}
