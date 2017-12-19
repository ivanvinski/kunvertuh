package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.presenter.AboutPresenter;
import com.ivanvinski.kunvertuh.view.AboutView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;

public class AboutViewImpl extends StackPane implements AboutView {

  @FXML
  private Parent root;
  @FXML
  private Hyperlink author, repository;

  @Override
  public void attach(AboutPresenter presenter) {
    author.setOnAction(e -> presenter.getModel().open(getAuthorPage()));
    repository.setOnAction(e -> presenter.getModel().open(getRepositoryPage()));
  }

  @Override
  public String getAuthorName() {
    return author.getText();
  }

  @Override
  public String getAuthorPage() {
    return (String) author.getUserData();
  }

  @Override
  public void setAuthor(String name, String pageUri) {
    author.setText(name);
    author.setUserData(pageUri);
  }

  @Override
  public String getRepositoryText() {
    return repository.getText();
  }

  @Override
  public String getRepositoryPage() {
    return (String) repository.getUserData();
  }

  @Override
  public void setRepository(String text, String pageUri) {
    repository.setText(text);
    repository.setUserData(pageUri);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }
}
