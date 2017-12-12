package com.ivanvinski.kunvertuh.view;

import java.util.Map;
import java.util.Objects;

public abstract class ViewChanger<V> {

  private Map<Class<? extends V>, V> views;
  private V activeView;

  public ViewChanger(Map<Class<? extends V>, V> views) {
    this.views = Objects.requireNonNull(views, "Views map can't be null");
    requireNonEmptyMap(views);
    activeView = views.values().iterator().next();
    applyView(activeView);
  }

  public void changeView(Class<? extends V> viewType) {
    Objects.requireNonNull(viewType, "Can't change to null view");
    throwExceptionIfViewDoesNotExist(viewType);
    V nextView = getViews().get(viewType);
    onViewChange(getActiveView(), nextView);
    activeView = nextView;
  }

  public V getActiveView() {
    return activeView;
  }

  public Map<Class<? extends V>, V> getViews() {
    return views;
  }

  protected abstract void onViewChange(V activeView, V nextView);

  protected abstract void applyView(V view);

  private void requireNonEmptyMap(Map<Class<? extends V>, V> views) {
    if (views.isEmpty()) {
      throw new IllegalArgumentException("Views map can't be empty");
    }
  }

  private void throwExceptionIfViewDoesNotExist(Class<? extends V> viewType) {
    if (!views.containsKey(viewType)) {
      throw new IllegalArgumentException("View does not exist: " + viewType);
    }
  }
}
