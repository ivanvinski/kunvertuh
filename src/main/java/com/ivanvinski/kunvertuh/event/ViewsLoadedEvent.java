package com.ivanvinski.kunvertuh.event;

import com.ivanvinski.kunvertuh.view.View;
import java.util.Map;

public final class ViewsLoadedEvent {

  private Map<String, View> loadedViews;

  public ViewsLoadedEvent(Map<String, View> loadedViews) {
    this.loadedViews = loadedViews;
  }

  public Map<String, View> getLoadedViews() {
    return loadedViews;
  }
}
