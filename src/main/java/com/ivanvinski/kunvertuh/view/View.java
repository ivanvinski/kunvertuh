package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.Presenter;

public interface View<P extends Presenter> {

  void attach(P presenter);
}
