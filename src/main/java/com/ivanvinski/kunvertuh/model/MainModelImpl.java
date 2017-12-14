package com.ivanvinski.kunvertuh.model;

import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import java.util.Objects;

public class MainModelImpl implements MainModel {

  private ViewCatalog catalog;
  private View activeView;

  public MainModelImpl(ViewCatalog catalog) {
    this.catalog = Objects.requireNonNull(catalog, "View catalog can't be null");
  }

  @Override
  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    activeView = view;
  }

  @Override
  public View getView(Class<? extends View> viewType) {
    return catalog.get(viewType);
  }
}
