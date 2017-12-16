package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.javafx.LengthUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.javafx.MassUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.javafx.VolumeUnitsViewImpl;
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
    LengthUnitsViewImpl firstView = (LengthUnitsViewImpl) model.getView(LengthUnitsViewImpl.class);
    view.setActiveView(firstView);
    view.setOnLengthActionEvent(() -> changeView(LengthUnitsViewImpl.class));
    view.setOnMassActionEvent(() -> changeView(MassUnitsViewImpl.class));
    view.setOnVolumeActionEvent(() -> changeView(VolumeUnitsViewImpl.class));
  }

  @Override
  public MainView getView() {
    return view;
  }

  @Override
  public MainModel getModel() {
    return model;
  }

  private void changeView(Class<? extends View> nextViewType) {
    if (model.getActiveView() != null && nextViewType == model.getActiveView().getClass()) {
      return;
    }
    View nextView = model.getView(nextViewType);
    view.setActiveView(nextView);
    model.setActiveView(nextView);
  }
}
