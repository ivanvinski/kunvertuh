package com.ivanvinski.kunvertuh.presenter;

import com.ivanvinski.kunvertuh.view.TestNonParentView;

public class TestNonParentViewPresenter implements Presenter<TestNonParentView, Object> {

  private TestNonParentView view;
  private Object model = new Object();

  public TestNonParentViewPresenter(TestNonParentView view) {
    this.view = view;
  }

  @Override
  public void initialize() {
  }

  @Override
  public TestNonParentView getView() {
    return view;
  }

  @Override
  public Object getModel() {
    return model;
  }
}
