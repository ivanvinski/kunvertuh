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

package com.ivanvinski.kunvertuh.mvp.view.javafx;

import com.ivanvinski.kunvertuh.mvp.view.AboutView;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public final class JFXAboutView extends StackPane implements AboutView {

  @FXML
  private Label name, version, tagline, developer, developerRole;
  @FXML
  private Hyperlink developerWebsite, developerGithub;
  private Runnable developerWebsiteClickAction, developerGithubClickAction;

  @FXML
  private Label openSource;
  @FXML
  private JFXTextArea license;
  @FXML
  private Hyperlink projectRepository;
  private Runnable projectRepositoryClickAction;

  @FXML
  private Label dependenciesHeader, jfoenixNote, fontAwesomeFxNote, guavaNote;
  @FXML
  private Hyperlink jfoenixLicense, fontAwesomeFxLicense, guavaLicense;
  private Runnable jfoenixLicenseClickAction, fontAwesomeFxLicenseClickAction, guavaLicenseClickAction;
  @FXML
  private Hyperlink jfoenixWebsite, fontAwesomeFxWebsite, guavaWebsite;
  private Runnable jfoenixClickAction, fontAwesomeFxClickAction, guavaClickAction;

  @Override
  public void initialize() {
    developerWebsite.setOnAction(e -> developerWebsiteClickAction.run());
    developerGithub.setOnAction(e -> developerGithubClickAction.run());
    projectRepository.setOnAction(e -> projectRepositoryClickAction.run());
    jfoenixLicense.setOnAction(e -> jfoenixLicenseClickAction.run());
    fontAwesomeFxLicense.setOnAction(e -> fontAwesomeFxLicenseClickAction.run());
    guavaLicense.setOnAction(e -> fontAwesomeFxLicenseClickAction.run());
    jfoenixWebsite.setOnAction(e -> jfoenixClickAction.run());
    fontAwesomeFxWebsite.setOnAction(e -> fontAwesomeFxClickAction.run());
    guavaWebsite.setOnAction(e -> guavaClickAction.run());
  }

  @Override
  public String getName() {
    return name.getText();
  }

  @Override
  public void setName(String name) {
    this.name.setText(name);
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
  public String getTagline() {
    return tagline.getText();
  }

  @Override
  public void setTagline(String tagline) {
    this.tagline.setText(tagline);
  }

  @Override
  public String getDeveloper() {
    return developer.getText();
  }

  public void setDeveloper(String developer) {
    this.developer.setText(developer);
  }

  @Override
  public String getDeveloperRoleText() {
    return developerRole.getText();
  }

  @Override
  public void setDeveloperRoleText(String developerRoleText) {
    developerRole.setText(developerRoleText);
  }

  @Override
  public String getDeveloperWebsiteText() {
    return developerWebsite.getText();
  }

  @Override
  public void setDeveloperWebsiteText(String developerWebsiteText) {
    developerWebsite.setText(developerWebsiteText);
  }

  @Override
  public Runnable getOnDeveloperWebsiteClicked() {
    return developerWebsiteClickAction;
  }

  @Override
  public void setOnDeveloperWebsiteClicked(Runnable developerWebsiteClickAction) {
    this.developerWebsiteClickAction = developerWebsiteClickAction;
  }

  @Override
  public String getDeveloperGithubText() {
    return developerGithub.getText();
  }

  @Override
  public void setDeveloperGithubText(String developerGithubText) {
    developerGithub.setText(developerGithubText);
  }

  @Override
  public Runnable getOnDeveloperGithubClicked() {
    return developerGithubClickAction;
  }

  @Override
  public void setOnDeveloperGithubClicked(Runnable developerGithubClickAction) {
    this.developerGithubClickAction = developerGithubClickAction;
  }

  @Override
  public String getOpenSourceHeading() {
    return openSource.getText();
  }

  @Override
  public void setOpenSourceHeading(String openSourceHeading) {
    openSource.setText(openSourceHeading);
  }

  @Override
  public String getLicensePrompt() {
    return license.getPromptText();
  }

  @Override
  public void setLicensePrompt(String licensePrompt) {
    license.setPromptText(licensePrompt);
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
  public String getProjectRepositoryText() {
    return projectRepository.getText();
  }

  @Override
  public void setProjectRepositoryText(String projectRepositoryText) {
    projectRepository.setText(projectRepositoryText);
  }

  @Override
  public Runnable getOnProjectRepositoryClicked() {
    return projectRepositoryClickAction;
  }

  @Override
  public void setOnProjectRepositoryClicked(Runnable projectRepositoryClickAction) {
    this.projectRepositoryClickAction = projectRepositoryClickAction;
  }

  @Override
  public String getDependenciesHeader() {
    return dependenciesHeader.getText();
  }

  @Override
  public void setDependenciesHeader(String dependenciesHeader) {
    this.dependenciesHeader.setText(dependenciesHeader);
  }

  @Override
  public String getJFoenixNote() {
    return jfoenixNote.getText();
  }

  @Override
  public void setJFoenixNote(String jfoenixNote) {
    this.jfoenixNote.setText(jfoenixNote);
  }

  @Override
  public String getJFoenixWebsiteText() {
    return jfoenixWebsite.getText();
  }

  @Override
  public void setJFoenixWebsiteText(String jfoenixWebsiteText) {
    jfoenixWebsite.setText(jfoenixWebsiteText);
  }

  @Override
  public Runnable getOnJFoenixClicked() {
    return jfoenixClickAction;
  }

  @Override
  public void setOnJFoenixClicked(Runnable jfoenixClickAction) {
    this.jfoenixClickAction = jfoenixClickAction;
  }

  @Override
  public Runnable getOnJFoenixLicenseClicked() {
    return jfoenixLicenseClickAction;
  }

  @Override
  public void setOnJFoenixLicenseClicked(Runnable jfoenixLicenseClickAction) {
    this.jfoenixLicenseClickAction = jfoenixLicenseClickAction;
  }

  @Override
  public String getFontAwesomeFXNote() {
    return fontAwesomeFxNote.getText();
  }

  @Override
  public void setFontAwesomeFXNote(String fontAwesomeFxNote) {
    this.fontAwesomeFxNote.setText(fontAwesomeFxNote);
  }

  @Override
  public String getFontAwesomeFXWebsiteText() {
    return fontAwesomeFxWebsite.getText();
  }

  @Override
  public void setFontAwesomeFXWebsiteText(String fontAwesomeFXWebsiteText) {
    fontAwesomeFxWebsite.setText(fontAwesomeFXWebsiteText);
  }

  @Override
  public Runnable getOnFontAwesomeFXClicked() {
    return fontAwesomeFxClickAction;
  }

  @Override
  public void setOnFontAwesomeFXClicked(Runnable fontAwesomeFxClickAction) {
    this.fontAwesomeFxClickAction = fontAwesomeFxClickAction;
  }

  @Override
  public Runnable getOnFontAwesomeFXLicenseClicked() {
    return fontAwesomeFxLicenseClickAction;
  }

  @Override
  public void setOnFontAwesomeFXLicenseClicked(Runnable fontAwesomeFxLicenseClickAction) {
    this.fontAwesomeFxLicenseClickAction = fontAwesomeFxLicenseClickAction;
  }

  @Override
  public String getGuavaNote() {
    return guavaNote.getText();
  }

  @Override
  public void setGuavaNote(String guavaNote) {
    this.guavaNote.setText(guavaNote);
  }

  @Override
  public String getGuavaWebsiteText() {
    return guavaWebsite.getText();
  }

  @Override
  public void setGuavaWebsiteText(String guavaWebsiteText) {
    guavaWebsite.setText(guavaWebsiteText);
  }

  @Override
  public Runnable getOnGuavaClicked() {
    return guavaClickAction;
  }

  @Override
  public void setOnGuavaClicked(Runnable guavaClickAction) {
    this.guavaClickAction = guavaClickAction;
  }

  @Override
  public Runnable getOnGuavaLicenseClicked() {
    return guavaLicenseClickAction;
  }

  @Override
  public void setOnGuavaLicenseClicked(Runnable guavaLicenseClickAction) {
    this.guavaLicenseClickAction = guavaLicenseClickAction;
  }
}
