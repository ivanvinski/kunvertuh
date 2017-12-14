package com.ivanvinski.kunvertuh.view;

public interface MainView extends View {

  void setActiveView(View view);

  void setOnLengthActionEvent(Runnable action);

  void setOnMassActionEvent(Runnable action);

  void setOnVolumeActionEvent(Runnable action);
}
