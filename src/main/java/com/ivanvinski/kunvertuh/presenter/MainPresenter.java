package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.View;

public final class MainPresenter extends AbstractPresenter<MainView, MainModel> {

  @Inject
  public MainPresenter(MainView view, MainModel model) {
    super(view, model);
  }

  @Override
  public void initialize() {
    viewChangeRequested(LengthUnitsView.class);
  }

  public void viewChangeRequested(Class<? extends View> viewType) {
    View nextView = getModel().getView(viewType);
    if (!isActiveView(nextView.getClass())) {
      getView().setActiveView(nextView);
      getModel().setActiveView(nextView);
    }
  }

  private boolean isActiveView(Class<? extends View> nextViewType) {
    View activeView = getModel().getActiveView();
    Class<? extends View> activeViewType = activeView == null ? null : activeView.getClass();
    return nextViewType == activeViewType;
  }
}
