package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.AboutView;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;

public final class MainPresenter extends AbstractPresenter<MainView, MainModel> {

  @Inject
  public MainPresenter(MainView view, MainModel model) {
    super(view, model);
  }

  @Override
  public void initialize() {
    getView().setOnLengthActionEvent(() -> requestViewChange(LengthUnitsView.class));
    getView().setOnMassActionEvent(() -> requestViewChange(MassUnitsView.class));
    getView().setOnVolumeActionEvent(() -> requestViewChange(VolumeUnitsView.class));
    getView().setOnAboutActionEvent(() -> requestViewChange(AboutView.class));
    requestViewChange(LengthUnitsView.class);
  }

  private void requestViewChange(Class<? extends View> viewType) {
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
