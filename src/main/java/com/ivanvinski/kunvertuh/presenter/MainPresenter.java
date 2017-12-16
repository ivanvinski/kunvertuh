package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.VolumeUnitsView;
import java.util.Objects;

public class MainPresenter implements Presenter<MainView, MainModel> {

  private MainView view;
  private MainModel model;

  @Inject
  public MainPresenter(MainView view, MainModel model) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
  }

  @Override
  public void initialize() {
    view.setOnLengthActionEvent(() -> requestViewChange(LengthUnitsView.class));
    view.setOnMassActionEvent(() -> requestViewChange(MassUnitsView.class));
    view.setOnVolumeActionEvent(() -> requestViewChange(VolumeUnitsView.class));
    requestViewChange(LengthUnitsView.class);
  }

  @Override
  public MainView getView() {
    return view;
  }

  @Override
  public MainModel getModel() {
    return model;
  }

  private void requestViewChange(Class<? extends View> viewType) {
    View nextView = model.getView(viewType);
    if (!isActiveView(nextView.getClass())) {
      view.setActiveView(nextView);
      model.setActiveView(nextView);
    }
  }

  private boolean isActiveView(Class<? extends View> nextViewType) {
    View activeView = model.getActiveView();
    Class<? extends View> activeViewType = activeView == null ? null : activeView.getClass();
    return nextViewType == activeViewType;
  }
}
