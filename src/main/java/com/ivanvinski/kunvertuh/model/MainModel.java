package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.view.View;

public interface MainModel {

  View getActiveView();

  void setActiveView(View view);

  View getView(Class<? extends View> viewType);
}
