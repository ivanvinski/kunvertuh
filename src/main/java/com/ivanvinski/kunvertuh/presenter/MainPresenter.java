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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.event.ViewChangeRequest;
import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.MainView;

public final class MainPresenter extends AbstractPresenter<MainView, MainModel> {

  @Inject
  public MainPresenter(MainView view, MainModel model) {
    super(view, model);
  }

  @Subscribe
  public void onViewChangeRequst(ViewChangeRequest request) {
    getModel().setActiveView(request.getViewIdentifier());
    if (isActiveView(request.getViewIdentifier())) {
      getView().setActiveView(getModel().getActiveView());
    }
  }

  private boolean isActiveView(String viewIdentifier) {
    String activeViewIdentifier = getModel().getActiveViewIdentifier();
    return activeViewIdentifier != null && viewIdentifier.equals(activeViewIdentifier);
  }
}
