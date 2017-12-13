package com.ivanvinski.kunvertuh.presenter;

public interface Presenter<V, M> {

  void initialize();

  V getView();

  M getModel();
}
