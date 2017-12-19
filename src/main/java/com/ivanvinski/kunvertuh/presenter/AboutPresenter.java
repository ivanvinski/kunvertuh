package com.ivanvinski.kunvertuh.presenter;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.util.Browser;
import com.ivanvinski.kunvertuh.view.AboutView;

public final class AboutPresenter extends AbstractPresenter<AboutView, Browser> {

  @Inject
  public AboutPresenter(AboutView view, Browser model) {
    super(view, model);
  }

  @Override
  public void initialize() {
    getView().setAuthor("Ivan Vinski", "https://ivanvinski.com/");
    getView().setRepository("GitHub repository", "https://github.com/ivanvinski/kunvertuh");
  }
}
