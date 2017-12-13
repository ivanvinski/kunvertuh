package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.LengthUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.MassUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.VolumeUnitsViewImpl;
import java.util.Objects;
import javafx.scene.Parent;

public class MainPresenter implements Presenter<MainView<Parent>, MainModel<Parent>> {

  private MainView<Parent> view;
  private MainModel<Parent> model;

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
  public MainView<Parent> getView() {
    return view;
  }

  @Override
  public MainModel<Parent> getModel() {
    return model;
  }

  private void changeView(Class<? extends Parent> nextViewType) {
    if (model.getActiveView() != null && nextViewType == model.getActiveView().getClass()) {
      return;
    }
    Parent nextView = model.getView(nextViewType);
    view.setActiveView(nextView);
    model.setActiveView(nextView);
  }
}
