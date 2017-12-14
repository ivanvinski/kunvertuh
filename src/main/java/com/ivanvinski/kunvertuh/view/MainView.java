package com.ivanvinski.kunvertuh.view;

public interface MainView<V> extends View {

  void setActiveView(V view);

  void setOnLengthActionEvent(Runnable action);

  void setOnMassActionEvent(Runnable action);

  void setOnVolumeActionEvent(Runnable action);
}
