package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.model.AboutModel;
import com.ivanvinski.kunvertuh.util.Software;
import com.ivanvinski.kunvertuh.util.SoftwareBuilder;
import com.ivanvinski.kunvertuh.view.AboutView;
import java.util.ArrayList;
import java.util.List;

public final class AboutPresenter extends AbstractPresenter<AboutView, AboutModel> {

  @Inject
  public AboutPresenter(AboutView view, AboutModel model) {
    super(view, model);
  }

  @Override
  public void initialize() {
    getView().setAuthor("Ivan Vinski");
    getView().setAuthorWebsite("https://ivanvinski.com/");
    getView().setRepositoryWebsite("https://github.com/ivanvinski/kunvertuh");
    getView().setOnURIAction(getModel()::openInBrowser);
    getView().setUsedOpenSourceSoftware(getUsedSoftware());
  }

  private List<Software> getUsedSoftware() {
    List<Software> usedSoftware = new ArrayList<>();
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
