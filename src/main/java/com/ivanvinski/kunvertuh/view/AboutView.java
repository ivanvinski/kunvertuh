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

  void addDependencyCredit(String name, String uri, String license, String licenseUri);

  String getVersion();

  void setVersion(String version);

  String getRepositoryPrompt();

  void setRepositoryPrompt(String text);

  String getRepositoryPage();

  void setRepositoryPage(String repositoryUri);

  String getLicense();

  void setLicense(String license);

  String getContactPrompt();

  void setContactPrompt(String text);

  String getContactUri();

  void setContactUri(String contactUri);

  String getAuthorName();

  void setAuthorName(String name);

  String getAuthorUri();

  void setAuthorUri(String authorUri);

  String getAuthorGithubUri();

  void setAuthorGithubUri(String githubUri);
}
