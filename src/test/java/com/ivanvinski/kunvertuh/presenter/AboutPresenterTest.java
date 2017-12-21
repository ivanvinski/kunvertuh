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

package com.ivanvinski.kunvertuh.presenter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.AboutModelMock;
import com.ivanvinski.kunvertuh.view.mock.AboutViewMock;
import org.junit.Before;
import org.junit.Test;

public class AboutPresenterTest {

  private static final String AUTHOR_WEBSITE = "https://ivanvinski.com/";
  private static final String REPOSITORY_WEBSITE = "https://github.com/ivanvinski/kunvertuh";

  private AboutViewMock view = new AboutViewMock();
  private AboutModelMock model = new AboutModelMock();

  @Before
  public void setUp() {
    new AboutPresenter(view, model).initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new AboutPresenter(null, model);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new AboutPresenter(view, null);
  }

  @Test
  public void initializationSetsAuthor() {
    assertEquals("Ivan Vinski", view.getAuthor());
  }

  @Test
  public void initializationSetsAuthorWebsite() {
    assertEquals(AUTHOR_WEBSITE, view.getAuthorWebsite());
  }

  @Test
  public void initializationSetsRepositoryWebsite() {
    assertEquals(REPOSITORY_WEBSITE, view.getRepositoryWebsite());
  }

  @Test
  public void authorWebsiteActionOpensAuthorWebsite() {
    view.fireAuthorWebsiteAction();
    assertEquals(AUTHOR_WEBSITE, model.getOpenedWebsite());
  }

  @Test
  public void repositoryWebsiteActionOpensRepositoryWebsite() {
    view.fireRepositoryWebsiteAction();
    assertEquals(REPOSITORY_WEBSITE, model.getOpenedWebsite());
  }
}
