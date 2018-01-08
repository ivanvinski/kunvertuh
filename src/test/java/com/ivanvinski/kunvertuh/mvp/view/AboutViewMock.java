/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh.mvp.view;

public class AboutViewMock implements AboutView {

  private String name, version, tagline, developer, developerRole, developerWebsite, developerGithub;
  private Runnable developerWebsiteClickAction, developerGithubClickAction;

  private String openSource, licensePrompt, license, projectRepository;
  private Runnable projectRepositoryClickAction;

  private String dependenciesHeader, jfoenixNote, fontAwesomeFxNote, guavaNote;
  private String jfoenixLicense, fontAwesomeFxLicense, guavaLicense;
  private Runnable jfoenixLicenseClickAction, fontAwesomeFxLicenseClickAction, guavaLicenseClickAction;
  private String jfoenixWebsite, fontAwesomeFxWebsite, guavaWebsite;
  private Runnable jfoenixClickAction, fontAwesomeFxClickAction, guavaClickAction;

  @Override
  public void initialize() {
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getVersion() {
    return version;
  }

  @Override
  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public String getTagline() {
    return tagline;
  }

  @Override
  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  @Override
  public String getDeveloper() {
    return developer;
  }

  @Override
  public void setDeveloper(String developer) {
    this.developer = developer;
  }

  @Override
  public String getDeveloperRoleText() {
    return developerRole;
  }

  @Override
  public void setDeveloperRoleText(String developerRoleText) {
    developerRole = developerRoleText;
  }

  @Override
  public String getDeveloperWebsiteText() {
    return developerWebsite;
  }

  @Override
  public void setDeveloperWebsiteText(String developerWebsiteText) {
    developerWebsite = developerWebsiteText;
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
    return developerGithub;
  }

  @Override
  public void setDeveloperGithubText(String developerGithubText) {
    developerGithub = developerGithubText;
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
    return openSource;
  }

  @Override
  public void setOpenSourceHeading(String openSourceHeading) {
    openSource = openSourceHeading;

  }

  @Override
  public String getLicensePrompt() {
    return licensePrompt;
  }

  @Override
  public void setLicensePrompt(String licensePrompt) {
    this.licensePrompt = licensePrompt;
  }

  @Override
  public String getLicense() {
    return license;
  }

  @Override
  public void setLicense(String license) {
    this.license = license;
  }

  @Override
  public String getProjectRepositoryText() {
    return projectRepository;
  }

  @Override
  public void setProjectRepositoryText(String projectRepositoryText) {
    projectRepository = projectRepositoryText;
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
    return dependenciesHeader;
  }

  @Override
  public void setDependenciesHeader(String dependenciesHeader) {
    this.dependenciesHeader = dependenciesHeader;
  }

  @Override
  public String getJFoenixNote() {
    return jfoenixNote;
  }

  @Override
  public void setJFoenixNote(String jfoenixNote) {
    this.jfoenixNote = jfoenixNote;
  }

  @Override
  public String getJFoenixWebsiteText() {
    return jfoenixWebsite;
  }

  @Override
  public void setJFoenixWebsiteText(String jfoenixWebsiteText) {
    jfoenixWebsite = jfoenixWebsiteText;
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
    return fontAwesomeFxNote;
  }

  @Override
  public void setFontAwesomeFXNote(String fontAwesomeFxNote) {
    this.fontAwesomeFxNote = fontAwesomeFxNote;
  }

  @Override
  public String getFontAwesomeFXWebsiteText() {
    return fontAwesomeFxWebsite;
  }

  @Override
  public void setFontAwesomeFXWebsiteText(String fontAwesomeFXWebsiteText) {
    fontAwesomeFxWebsite = fontAwesomeFXWebsiteText;
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
    return guavaNote;
  }

  @Override
  public void setGuavaNote(String guavaNote) {
    this.guavaNote = guavaNote;
  }

  @Override
  public String getGuavaWebsiteText() {
    return guavaWebsite;
  }

  @Override
  public void setGuavaWebsiteText(String guavaWebsiteText) {
    guavaWebsite = guavaWebsiteText;
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
