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

import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.mock.AboutViewMock;
import com.ivanvinski.kunvertuh.view.mock.LengthUnitsViewMock;
import com.ivanvinski.kunvertuh.view.mock.MainViewMock;
import com.ivanvinski.kunvertuh.view.mock.MassUnitsViewMock;
import com.ivanvinski.kunvertuh.view.mock.VolumeUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class MainPresenterTest {

  private MainViewMock view = new MainViewMock();
  private MainModel model;

  @Before
  public void setUp() {
    ViewCatalog catalog = new ViewCatalog();
    catalog.add(new LengthUnitsViewMock());
    catalog.add(new MassUnitsViewMock());
    catalog.add(new VolumeUnitsViewMock());
    catalog.add(new AboutViewMock());
    new MainPresenter(view, model = new MainModel(catalog)).initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new MainPresenter(null, model);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new MainPresenter(view, null);
  }

  @Test
  public void initializationSetsCorrectInitialView() {
    assertEquals(LengthUnitsViewMock.class, model.getActiveView().getClass());
  }

  @Test
  public void lengthActionEventSetsLengthUnitsView() {
    view.fireMassActionEvent();
    view.fireLengthActionEvent();
    assertEquals(LengthUnitsViewMock.class, view.getActiveView().getClass());
  }

  @Test
  public void massActionEventSetsMassUnitsView() {
    view.fireMassActionEvent();
    assertEquals(MassUnitsViewMock.class, view.getActiveView().getClass());
  }

  @Test
  public void volumeActionEventSetsVolumeUnitsView() {
    view.fireVolumeActionEvent();
    assertEquals(VolumeUnitsViewMock.class, view.getActiveView().getClass());
  }

  @Test
  public void aboutActionEventSetsAboutView() {
    view.fireAboutActionEvent();
    assertEquals(AboutViewMock.class, view.getActiveView().getClass());
  }
}
