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

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.OpenInBrowserEvent;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.view.AboutView;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public final class JFXAboutView extends AbstractJFXView implements AboutView {

  @FXML
  private Label aboutSubheading, version, license;
  @FXML
  private Hyperlink repository;

  @FXML
  private Label helpSubheading, question, answer;
  @FXML
  private Hyperlink contact;

  @FXML
  private Label creditsSubheading, developerHeading, developerSubheading;
  @FXML
  private Hyperlink authorPage, authorGithub;
  @FXML
  private VBox creditsBox;

  @Inject
  public JFXAboutView(EventStream eventStream) {
    super(eventStream);
  }

  @Override
  public void initialize() {
    openHyperlinkInBrowserOnActionEvent(repository);
    openHyperlinkInBrowserOnActionEvent(contact);
    openHyperlinkInBrowserOnActionEvent(authorPage);
    openHyperlinkInBrowserOnActionEvent(authorGithub);
  }

  @Override
  public void addDependencyCredit(String name, String uri, String license, String licenseUri) {
    VBox dependencyCredit = new VBox();
    Hyperlink titleAndLink = new Hyperlink(name);
    titleAndLink.getStyleClass().add("important-hyperlink");
    titleAndLink.setUserData(uri);
    openHyperlinkInBrowserOnActionEvent(titleAndLink);
    Hyperlink licenseLink = new Hyperlink(license);
    licenseLink.setUserData(licenseUri);
    openHyperlinkInBrowserOnActionEvent(licenseLink);
    dependencyCredit.getChildren().addAll(new Separator(), titleAndLink, licenseLink);
    creditsBox.getChildren().add(dependencyCredit);
  }

  @Override
  public void setLanguage(Language language) {
    super.setLanguage(language);
    aboutSubheading.setText(language.getString("ABOUT"));
    version.setText(language.getString("VERSION") + ": -");
    license.setText(language.getString("LICENSE") + ": GPL v3.0");
    repository.setText(language.getString("FORK_ME"));
    helpSubheading.setText(language.getString("HELP"));
    question.setText(language.getString("HELP_QUESTION"));
    answer.setText(language.getString("HELP_ANSWER"));
    contact.setText(language.getString("CONTACT_FOR_MORE_INFO"));
    creditsSubheading.setText(language.getString("CREDITS"));
    developerSubheading.setText(language.getString("DEVELOPER"));
    authorPage.setText(language.getString("WEBSITE"));
    authorGithub.setText(language.getString("GITHUB"));
  }

  @Override
  public String getVersion() {
    return version.getText();
  }

  @Override
  public void setVersion(String version) {
    this.version.setText(version);
  }

  @Override
  public String getRepositoryPrompt() {
    return repository.getText();
  }

  @Override
  public void setRepositoryPrompt(String text) {
    repository.setText(text);
  }

  @Override
  public String getRepositoryPage() {
    return (String) repository.getUserData();
  }

  @Override
  public void setRepositoryPage(String repositoryUri) {
    repository.setUserData(repositoryUri);
  }

  @Override
  public String getLicense() {
    return license.getText();
  }

  @Override
  public void setLicense(String license) {
    this.license.setText(license);
  }

  @Override
  public String getContactPrompt() {
    return contact.getText();
  }

  @Override
  public void setContactPrompt(String text) {
    contact.setText(text);
  }

  @Override
  public String getContactUri() {
    return (String) contact.getUserData();
  }

  @Override
  public void setContactUri(String contactUri) {
    contact.setUserData(contactUri);
  }

  @Override
  public String getAuthorName() {
    return developerHeading.getText();
  }

  @Override
  public void setAuthorName(String name) {
    developerHeading.setText(name);
  }

  @Override
  public String getAuthorUri() {
    return (String) authorPage.getUserData();
  }

  @Override
  public void setAuthorUri(String authorUri) {
    authorPage.setUserData(authorUri);
  }

  @Override
  public String getAuthorGithubUri() {
    return (String) authorGithub.getUserData();
  }

  @Override
  public void setAuthorGithubUri(String githubUri) {
    authorGithub.setUserData(githubUri);
  }

  private void openHyperlinkInBrowserOnActionEvent(Hyperlink link) {
    link.setOnAction(e -> pushEvent(new OpenInBrowserEvent((String) link.getUserData())));
  }
}
