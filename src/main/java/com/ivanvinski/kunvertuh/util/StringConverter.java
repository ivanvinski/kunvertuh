package com.ivanvinski.kunvertuh.util;

public interface StringConverter<T> {

  String format(T value);

  T parse(String value);
}
