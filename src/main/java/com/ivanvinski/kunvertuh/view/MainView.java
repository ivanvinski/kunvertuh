package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.MainPresenter;

public interface MainView extends View<MainPresenter> {

  View getActiveView();

  void setActiveView(View view);
}
