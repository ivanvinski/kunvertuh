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

package com.ivanvinski.kunvertuh.view.mock;

import com.ivanvinski.kunvertuh.util.Software;
import com.ivanvinski.kunvertuh.view.AboutView;
import java.util.List;
import java.util.function.Consumer;

public class AboutViewMock implements AboutView {

  private String author, authorWebsite, repositoryWebsite;
  private Consumer<String> uriActionConsumer;

  public String getAuthor() {
    return author;
  }

  @Override
  public void setAuthor(String author) {
    this.author = author;
  }

  public String getAuthorWebsite() {
    return authorWebsite;
  }

  @Override
  public void setAuthorWebsite(String authorWebsiteURI) {
    authorWebsite = authorWebsiteURI;
  }

  public void fireAuthorWebsiteAction() {
    uriActionConsumer.accept(getAuthorWebsite());
  }

  public String getRepositoryWebsite() {
    return repositoryWebsite;
  }

  @Override
  public void setRepositoryWebsite(String repositoryWebsiteURI) {
    this.repositoryWebsite = repositoryWebsiteURI;
  }

  public void fireRepositoryWebsiteAction() {
    uriActionConsumer.accept(getRepositoryWebsite());
  }

  @Override
  public void setOnURIAction(Consumer<String> actionConsumer) {
    uriActionConsumer = actionConsumer;
  }

  @Override
  public void setUsedOpenSourceSoftware(List<Software> software) {
  }
}
