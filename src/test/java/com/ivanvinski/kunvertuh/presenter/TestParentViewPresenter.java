package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.view.TestParentView;

public class TestParentViewPresenter implements Presenter<TestParentView, Object> {

  private TestParentView view;
  private Object model = new Object();

  @Inject
  public TestParentViewPresenter(TestParentView view) {
    this.view = view;
  }

  @Override
  public void initialize() {
  }

  @Override
  public TestParentView getView() {
    return view;
  }

  @Override
  public Object getModel() {
    return model;
  }
}
