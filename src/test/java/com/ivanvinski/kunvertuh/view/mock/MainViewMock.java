package com.ivanvinski.kunvertuh.view.mock;

import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.View;

public class MainViewMock implements MainView {

  private Runnable lengthAction, massAction, volumeAction;
  private View activeView;

  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    activeView = view;
  }

  @Override
  public void setOnLengthActionEvent(Runnable action) {
    lengthAction = action;
  }

  public void fireLengthActionEvent() {
    lengthAction.run();
  }

  @Override
  public void setOnMassActionEvent(Runnable action) {
    massAction = action;
  }

  public void fireMassActionEvent() {
    massAction.run();
  }

  @Override
  public void setOnVolumeActionEvent(Runnable action) {
    volumeAction = action;
  }

  public void fireVolumeActionEvent() {
    volumeAction.run();
  }
}
