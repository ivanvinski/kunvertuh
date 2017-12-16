package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.AboutModel;
import com.ivanvinski.kunvertuh.util.Software;
import com.ivanvinski.kunvertuh.util.SoftwareBuilder;
import com.ivanvinski.kunvertuh.view.AboutView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AboutPresenter implements Presenter<AboutView, AboutModel> {

  private AboutView view;
  private AboutModel model;

  @Inject
  public AboutPresenter(AboutView view, AboutModel model) {
    this.view = Objects.requireNonNull(view, "About view can't be null");
    this.model = Objects.requireNonNull(model, "About model can't be null");
  }

  @Override
  public void initialize() {
    view.setAuthor("Ivan Vinski");
    view.setAuthorWebsite("https://ivanvinski.com/");
    view.setRepositoryWebsite("https://github.com/ivanvinski/kunvertuh");
    view.setOnURIAction(model::openInBrowser);
    view.setUsedOpenSourceSoftware(getUsedSoftware());
  }

  @Override
  public AboutView getView() {
    return view;
  }

  @Override
  public AboutModel getModel() {
    return model;
  }

  private List<Software> getUsedSoftware() {
    List<Software> usedSoftware = new ArrayList<>();
    usedSoftware.add(new SoftwareBuilder("JScience")
        .setVersion("4.3.1")
        .setLicense("JScience BSD License")
        .setWebsite("http://jscience.org/")
        .build());
    usedSoftware.add(new SoftwareBuilder("Guava")
        .setVersion("23.3-jre")
        .setLicense("Apache 2.0")
        .setWebsite("https://github.com/google/guava")
        .build());
    usedSoftware.add(new SoftwareBuilder("Guice")
        .setVersion("4.1.0")
        .setLicense("Apache 2.0")
        .setWebsite("https://github.com/google/guice")
        .build());
    usedSoftware.add(new SoftwareBuilder("JFoenix")
        .setVersion("1.9.0")
        .setLicense("Apache 2.0")
        .setWebsite("http://jfoenix.com/")
        .build());
    usedSoftware.add(new SoftwareBuilder("FontAwesomeFX Commons")
        .setVersion("8.15")
        .setLicense("Apache 2.0")
        .setWebsite("https://bitbucket.org/Jerady/fontawesomefx")
        .build());
    usedSoftware.add(new SoftwareBuilder("FontAwesomeFX MaterialDesignFont")
        .setVersion("1.7.22-4")
        .setLicense("Apache 2.0")
        .setWebsite("https://bitbucket.org/Jerady/fontawesomefx")
        .build());
    usedSoftware.add(new SoftwareBuilder("JUnit")
        .setVersion("4.12")
        .setLicense("Eclipse Public License 1.0")
        .setWebsite("http://junit.org/junit4/")
        .build());
    return usedSoftware;
  }
}
