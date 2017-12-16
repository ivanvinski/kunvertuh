package com.ivanvinski.kunvertuh.presenter;

import com.ivanvinski.kunvertuh.view.View;
import java.util.Objects;

public abstract class AbstractPresenter<V extends View, M> implements Presenter<V, M> {

  private V view;
  private M model;

  public AbstractPresenter(V view, M model) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
  }

  @Override
  public V getView() {
    return view;
  }

  @Override
  public M getModel() {
    return model;
  }
}
