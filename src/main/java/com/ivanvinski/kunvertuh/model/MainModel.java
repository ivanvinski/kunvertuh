package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import java.util.Objects;

public class MainModel {

  private ViewCatalog catalog;
  private View activeView;

  public MainModel(ViewCatalog catalog) {
    this.catalog = Objects.requireNonNull(catalog, "View catalog can't be null");
  }

  public View getActiveView() {
    return activeView;
  }

  public void setActiveView(View view) {
    activeView = view;
  }

  public View getView(Class<? extends View> viewType) {
    return catalog.get(viewType);
  }
}
