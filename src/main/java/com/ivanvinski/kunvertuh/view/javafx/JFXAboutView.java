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
import javafx.scene.layout.StackPane;

public class JFXAboutView extends StackPane implements AboutView {

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
