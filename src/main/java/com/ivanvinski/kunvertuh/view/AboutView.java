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

package com.ivanvinski.kunvertuh.view;

public interface AboutView extends View {

  String getName();

  void setName(String name);

  String getVersion();

  void setVersion(String version);

  String getTagline();

  void setTagline(String tagline);

  String getDeveloper();

  void setDeveloper(String developer);

  String getDeveloperRoleText();

  void setDeveloperRoleText(String developerRoleText);

  String getDeveloperWebsiteText();

  void setDeveloperWebsiteText(String developerWebsiteText);

  Runnable getOnDeveloperWebsiteClicked();

  void setOnDeveloperWebsiteClicked(Runnable developerWebsiteClickAction);

  String getDeveloperGithubText();

  void setDeveloperGithubText(String developerGithubText);

  Runnable getOnDeveloperGithubClicked();

  void setOnDeveloperGithubClicked(Runnable developerGithubClickAction);

  String getOpenSourceHeading();

  void setOpenSourceHeading(String openSourceHeading);

  String getLicensePrompt();

  void setLicensePrompt(String licensePrompt);

  String getLicense();

  void setLicense(String license);

  String getProjectRepositoryText();

  void setProjectRepositoryText(String projectRepositoryText);

  Runnable getOnProjectRepositoryClicked();

  void setOnProjectRepositoryClicked(Runnable projectRepositoryClickAction);

  String getDependenciesHeader();

  void setDependenciesHeader(String dependenciesHeader);

  String getJFoenixNote();

  void setJFoenixNote(String jfoenixNote);

  String getJFoenixWebsiteText();

  void setJFoenixWebsiteText(String jfoenixWebsiteText);

  Runnable getOnJFoenixClicked();

  void setOnJFoenixClicked(Runnable jfoenixClickAction);

  Runnable getOnJFoenixLicenseClicked();

  void setOnJFoenixLicenseClicked(Runnable jfoenixLicenseClickAction);

  String getFontAwesomeFXNote();

  void setFontAwesomeFXNote(String fontAwesomeFxNote);

  String getFontAwesomeFXWebsiteText();

  void setFontAwesomeFXWebsiteText(String fontAwesomeFXWebsiteText);

  Runnable getOnFontAwesomeFXClicked();

  void setOnFontAwesomeFXClicked(Runnable fontAwesomeFxClickAction);

  Runnable getOnFontAwesomeFXLicenseClicked();

  void setOnFontAwesomeFXLicenseClicked(Runnable fontAwesomeFxLicenseClickAction);

  String getGuavaNote();

  void setGuavaNote(String guavaNote);

  String getGuavaWebsiteText();

  void setGuavaWebsiteText(String guavaWebsiteText);

  Runnable getOnGuavaClicked();

  void setOnGuavaClicked(Runnable guavaClickAction);

  Runnable getOnGuavaLicenseClicked();

  void setOnGuavaLicenseClicked(Runnable guavaLicenseClickAction);
}
