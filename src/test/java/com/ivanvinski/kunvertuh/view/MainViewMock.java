package com.ivanvinski.kunvertuh.view;

public class MainViewMock implements MainView {

  private Runnable lengthAction, massAction, volumeAction;
  private Object activeView;

  public Object getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(Object view) {
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