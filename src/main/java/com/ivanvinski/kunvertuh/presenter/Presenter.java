package com.ivanvinski.kunvertuh.presenter;

import com.ivanvinski.kunvertuh.view.View;

public interface Presenter<V extends View, M> {

  void initialize();

  V getView();

  M getModel();
}
