package com.ivanvinski.kunvertuh.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ViewCatalog {

  private Map<Class<? extends View>, View> views = new HashMap<>();

  public void add(View view) {
    Objects.requireNonNull(view, "Can't add null view");
    Class<? extends View> viewType = view.getClass();
    if (contains(viewType)) {
      throw new IllegalArgumentException("Duplicate views are not allowed: " + viewType);
    } else {
      views.put(viewType, view);
    }
  }

  public View get(Class<? extends View> viewType) {
    if (!contains(viewType)) {
      throw new IllegalArgumentException("View does not exist: " + viewType);
    }
    return views.get(viewType);
  }

  public boolean contains(Class<? extends View> viewType) {
    return views.containsKey(viewType);
  }
}
