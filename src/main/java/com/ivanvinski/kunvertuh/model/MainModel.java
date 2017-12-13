package com.ivanvinski.kunvertuh.model;

public interface MainModel<V> {

  V getActiveView();

  void setActiveView(V view);

  V getView(Class<? extends V> viewType);
}
