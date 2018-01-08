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

package com.ivanvinski.kunvertuh.mvp.presenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.mvp.model.AboutModel;
import com.ivanvinski.kunvertuh.mvp.view.AboutView;
import com.ivanvinski.kunvertuh.mvp.view.AboutViewMock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AboutPresenterTest {

  private AboutView view = new AboutViewMock();
  private AboutModel model = Mockito.spy(new AboutModel());
  private EventStream eventStream = Mockito.mock(EventStream.class);
  private AboutPresenter presenter = Mockito.spy(new AboutPresenter(view, model, eventStream));
  private Language language = Language.ENGLISH;

  @Before
  public void setUp() {
    presenter.onInitialized();
    Mockito.when(model.getVersion()).thenReturn("VERSION_NUMBER");
    Mockito.when(model.getLicense()).thenReturn("LICENSE_NAME");
    presenter.onLanguageChanged(language);
  }

  @Test
  public void verifyName() {
    assertEquals("Kunvertuh", model.getName());
  }

  @Test
  public void verifyLicenseText() {
    assertTrue(model.getLicenseText().trim().startsWith("GNU GENERAL PUBLIC LICENSE"));
  }

  @Test
  public void verifyDeveloperWebsite() {
    view.getOnDeveloperWebsiteClicked().run();
    Mockito.verify(presenter).browse(model.getDeveloperWebsite());
  }

  @Test
  public void verifyDeveloperGithub() {
    view.getOnDeveloperGithubClicked().run();
    Mockito.verify(presenter).browse(model.getDeveloperGithub());
  }

  @Test
  public void verifyProjectRepository() {
    view.getOnProjectRepositoryClicked().run();
    Mockito.verify(presenter).browse(model.getRepositoryUri());
  }

  @Test
  public void verifyJFoenixLicenseLocation() {
    view.getOnJFoenixLicenseClicked().run();
    Mockito.verify(presenter).browse(model.getApacheLicenseUri());
  }

  @Test
  public void verifyJFoenixWebpage() {
    view.getOnJFoenixClicked().run();
    Mockito.verify(presenter).browse(model.getJfoenixUri());
  }

  @Test
  public void verifyFontAwesomeFXLicenseLocation() {
    view.getOnFontAwesomeFXLicenseClicked().run();
    Mockito.verify(presenter).browse(model.getApacheLicenseUri());
  }

  @Test
  public void verifyFontAwesomeFXWebpage() {
    view.getOnFontAwesomeFXClicked().run();
    Mockito.verify(presenter).browse(model.getFontAwesomeFxUri());
  }

  @Test
  public void verifyGuavaLicenseLocation() {
    view.getOnGuavaLicenseClicked().run();
    Mockito.verify(presenter).browse(model.getApacheLicenseUri());
  }

  @Test
  public void verifyGuavaWebpage() {
    view.getOnGuavaClicked().run();
    Mockito.verify(presenter).browse(model.getGuavaUri());
  }

  @Test
  public void verifyVersionInternationalization() {
    assertEquals(language.getString("VERSION") + " VERSION_NUMBER", view.getVersion());
  }

  @Test
  public void verifyLicenseInternationalization() {
    assertEquals("License: LICENSE_NAME", view.getLicensePrompt());
  }
}
