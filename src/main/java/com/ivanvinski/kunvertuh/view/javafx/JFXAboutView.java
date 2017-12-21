/*
 * Kunvertuh
 * Copyright (C) 2017  Ivan Vinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.presenter.AboutPresenter;
import com.ivanvinski.kunvertuh.view.AboutView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class JFXAboutView extends StackPane implements AboutView {

  @FXML
  private Parent root;
  @FXML
  private Label version, license, author;
  @FXML
  private Hyperlink repository, contact, authorPage, authorGithub;

  @Override
  public void attach(AboutPresenter presenter) {
    openInBrowserOnActionEvent(presenter, repository);
    openInBrowserOnActionEvent(presenter, contact);
    openInBrowserOnActionEvent(presenter, authorPage);
    openInBrowserOnActionEvent(presenter, authorGithub);
  }

  @Override
  public void setVersion(String version) {
    this.version.setText(version);
  }

  @Override
  public void setRepositoryText(String text) {
    this.repository.setText(text);
  }

  @Override
  public void setRepositoryPage(String repositoryUri) {
    repository.setUserData(repositoryUri);
  }

  @Override
  public void setLicense(String license) {
    this.license.setText(license);
  }

  @Override
  public void setContactText(String text) {
    contact.setText(text);
  }

  @Override
  public void setContactPage(String contactUri) {
    contact.setUserData(contactUri);
  }

  @Override
  public void setAuthor(String author) {
    this.author.setText(author);
  }

  @Override
  public void setAuthorPage(String authorUri) {
    authorPage.setUserData(authorUri);
  }

  @Override
  public void setAuthorGithub(String githubUri) {
    authorGithub.setUserData(githubUri);
  }

  @FXML
  private void initialize() {
    getChildren().setAll(root);
  }

  private void openInBrowserOnActionEvent(AboutPresenter presenter, Hyperlink link) {
    link.setOnAction(e -> presenter.openInBrowser((String) link.getUserData()));
  }
}
