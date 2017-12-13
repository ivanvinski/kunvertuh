package com.ivanvinski.kunvertuh.view;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ivanvinski.kunvertuh.module.ViewModule;
import com.ivanvinski.kunvertuh.presenter.Presenter;
import java.util.Objects;
import javafx.util.Callback;

public class ViewAssembler implements Callback<Class<?>, Object> {

  private final Injector presenterCreator;
  private Presenter presenter;

  public ViewAssembler(AbstractModule presenterModule) {
    Objects.requireNonNull(presenterModule, "Can't assemble view with null module");
    presenterCreator = Guice.createInjector(presenterModule);
  }

  @Override
  public Object call(Class<?> presenterType) {
    throwExceptionIfNotImplementPresenter(presenterType);
    presenter = (Presenter) presenterCreator.getInstance(presenterType);
    Injector presenterInjector = Guice.createInjector(new ViewModule(presenter));
    presenterInjector.injectMembers(presenter.getView());
    return presenter.getView();
  }

  public Presenter getPresenter() {
    return presenter;
  }

  private void throwExceptionIfNotImplementPresenter(Class<?> presenterType) {
    if (!Presenter.class.isAssignableFrom(presenterType)) {
      throw new IllegalArgumentException("Does not implement Presenter: " + presenterType);
    }
  }
}
