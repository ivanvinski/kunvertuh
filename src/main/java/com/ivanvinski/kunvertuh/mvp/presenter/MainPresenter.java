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

import com.google.common.eventbus.Subscribe;
import com.ivanvinski.kunvertuh.Views;
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.event.ViewChangeRequest;
import com.ivanvinski.kunvertuh.event.ViewsLoadedEvent;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.mvp.model.MainModel;
import com.ivanvinski.kunvertuh.mvp.view.MainView;

public final class MainPresenter extends Presenter<MainView, MainModel> {

  private Language language;

  public MainPresenter(MainView view, MainModel model, EventStream eventStream) {
    super(view, model, eventStream);
  }

  @Override
  public void onInitialized() {
    getView().addNavigationItem(Views.LENGTH);
    getView().addNavigationItem(Views.MASS);
    getView().addNavigationItem(Views.VOLUME);
    getView().addNavigationItem(Views.AREA);
    getView().addNavigationItemSeparator();
    getView().addNavigationItem(Views.SETTINGS);
    getView().addNavigationItem(Views.ABOUT);
    getView().setOnNavigationItemClicked(viewIdentifier ->
        onViewChangeRequest(new ViewChangeRequest(viewIdentifier)));
  }

  @Override
  public void onLanguageChanged(Language language) {
    this.language = language;
    updateAppBarTitle();
    getModel().getViews().keySet().stream()
        .filter(getView()::containsNavigationButton)
        .forEach(viewIdentifier -> getView()
            .setNavigationButtonText(viewIdentifier, language.getString(viewIdentifier)));
  }

  @Subscribe
  public void onViewsLoaded(ViewsLoadedEvent event) {
    getModel().setViews(event.getLoadedViews());
  }

  @Subscribe
  public void onViewChangeRequest(ViewChangeRequest request) {
    getView().selectNavigationItem(request.getViewIdentifier());
    getModel().setActiveView(request.getViewIdentifier());
    getView().setActiveView(getModel().getActiveView());
    updateAppBarTitle();
  }

  private void updateAppBarTitle() {
    String activeViewIdentifier = getModel().getIdentifier(getModel().getActiveView());
    if (language == null) {
      getView().setAppBarTitle(activeViewIdentifier);
      return;
    }
    String title = language.getString(activeViewIdentifier + "_VIEW");
    title = title.equals("%null%") ? language.getString(activeViewIdentifier) : title;
    getView().setAppBarTitle(title);
  }
}
