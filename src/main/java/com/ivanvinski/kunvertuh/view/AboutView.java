package com.ivanvinski.kunvertuh.view;

import com.ivanvinski.kunvertuh.presenter.AboutPresenter;

public interface AboutView extends View<AboutPresenter> {

  String getAuthorName();

  String getAuthorPage();

  void setAuthor(String name, String pageUri);

  String getRepositoryText();

  String getRepositoryPage();

  void setRepository(String text, String pageUri);
}
