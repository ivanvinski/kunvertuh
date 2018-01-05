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
import static org.junit.Assert.assertNotEquals;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.ViewChangeRequest;
import com.ivanvinski.kunvertuh.event.ViewsLoadedEvent;
import com.ivanvinski.kunvertuh.mvp.model.MainModel;
import com.ivanvinski.kunvertuh.mvp.view.MainView;
import com.ivanvinski.kunvertuh.mvp.view.MainViewMock;
import com.ivanvinski.kunvertuh.mvp.view.View;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MainPresenterTest {

  private MainView view = new MainViewMock();
  private MainModel model = new MainModel();
  private EventStream eventStream = Mockito.mock(EventStream.class);
  private MainPresenter presenter = Mockito.spy(new MainPresenter(view, model, eventStream));

  private final String NAV_VIEW_IDENTIFIER = "NAV_VIEW";
  private final View NAV_VIEW = Mockito.mock(View.class);
  private final Map<String, View> loadedViews = new HashMap<>();

  @Before
  public void setUp() {
    loadedViews.put(NAV_VIEW_IDENTIFIER, NAV_VIEW);
    model.setViews(loadedViews);
    presenter.onInitialized();
    view.addNavigationItem(NAV_VIEW_IDENTIFIER);
  }

  @Test
  public void viewsLoadedEventUpdatesModelViews() {
    presenter.onViewsLoaded(new ViewsLoadedEvent(new HashMap<>()));
    assertNotEquals(loadedViews, model.getViews());
  }

  @Test
  public void viewChangeRequestUpdatesViewActiveView() {
    presenter.onViewChangeRequest(new ViewChangeRequest(NAV_VIEW_IDENTIFIER));
    assertEquals(NAV_VIEW, view.getActiveView());
  }

  @Test
  public void viewChangeRequestUpdatesModelActiveView() {
    presenter.onViewChangeRequest(new ViewChangeRequest(NAV_VIEW_IDENTIFIER));
    assertEquals(NAV_VIEW, model.getActiveView());
  }

  @Test
  public void viewChangeRequestUpdatesSelectedNavigationItem() {
    presenter.onViewChangeRequest(new ViewChangeRequest(NAV_VIEW_IDENTIFIER));
    assertEquals(NAV_VIEW_IDENTIFIER, view.getSelectedNavigationItem());
  }

  @Test
  public void viewChangeRequestUpdatesAppBarTitleToViewIdentifier() {
    presenter.onViewChangeRequest(new ViewChangeRequest(NAV_VIEW_IDENTIFIER));
    assertEquals(NAV_VIEW_IDENTIFIER, view.getSelectedNavigationItem());
  }

  @Test
  public void navigationItemClickActionPushesViewChangeRequest() {
    view.getOnNavigationItemClicked().accept(NAV_VIEW_IDENTIFIER);
    Mockito.verify(presenter).onViewChangeRequest(Mockito.any());
  }
}
