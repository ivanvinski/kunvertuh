package com.ivanvinski.kunvertuh.mvp.loader;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.measurement.Area;
import com.ivanvinski.kunvertuh.measurement.Length;
import com.ivanvinski.kunvertuh.measurement.Mass;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.measurement.Volume;
import com.ivanvinski.kunvertuh.mvp.model.AboutModel;
import com.ivanvinski.kunvertuh.mvp.model.MainModel;
import com.ivanvinski.kunvertuh.mvp.model.SettingsModel;
import com.ivanvinski.kunvertuh.mvp.presenter.AboutPresenter;
import com.ivanvinski.kunvertuh.mvp.presenter.ConverterPresenter;
import com.ivanvinski.kunvertuh.mvp.presenter.MainPresenter;
import com.ivanvinski.kunvertuh.mvp.presenter.Presenter;
import com.ivanvinski.kunvertuh.mvp.presenter.SettingsPresenter;
import com.ivanvinski.kunvertuh.util.JFXBrowser;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXAboutView;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXConverterView;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXMainView;
import com.ivanvinski.kunvertuh.mvp.view.javafx.JFXSettingsView;
import javafx.application.HostServices;
import javafx.util.Callback;

final class JFXViewFactory implements Callback<Class<?>, Object> {

  private final EventStream eventStream;
  private final HostServices hostServices;
  private Presenter presenter;

  public JFXViewFactory(EventStream eventStream, HostServices hostServices) {
    this.eventStream = eventStream;
    this.hostServices = hostServices;
  }

  @Override
  public Object call(Class<?> presenterType) {
    presenter = createPresenter(presenterType);
    eventStream.subscribe(presenter);
    return presenter.getView();
  }

  public Presenter getPresenter() {
    return presenter;
  }

  private Presenter createPresenter(Class<?> presenterType) {
    if (presenterType == MainPresenter.class) {
      return new MainPresenter(new JFXMainView(),
          new MainModel(),
          eventStream);
    } else if (presenterType == SettingsPresenter.class) {
      return new SettingsPresenter(new JFXSettingsView(),
          new SettingsModel(Language.ALL),
          eventStream);
    } else if (presenterType == AboutPresenter.class) {
      return new AboutPresenter(new JFXAboutView(),
          new AboutModel(new JFXBrowser(hostServices)),
          eventStream);
    } else if (presenterType == Length.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Length.values()),
          new UnitConverter<>(Length.values()),
          eventStream);
    } else if (presenterType == Mass.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Mass.values()),
          new UnitConverter<>(Mass.values()),
          eventStream);
    } else if (presenterType == Volume.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Volume.values()),
          new UnitConverter<>(Volume.values()),
          eventStream);
    } else if (presenterType == Area.class) {
      return new ConverterPresenter<>(new JFXConverterView<>(Area.values()),
          new UnitConverter<>(Area.values()),
          eventStream);
    }
    throw new IllegalArgumentException("Unsupported presenter type: " + presenterType);
  }
}
