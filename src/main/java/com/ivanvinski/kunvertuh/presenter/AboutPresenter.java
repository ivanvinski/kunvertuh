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
import com.ivanvinski.kunvertuh.event.OpenInBrowserEvent;
import com.ivanvinski.kunvertuh.util.Browser;
import com.ivanvinski.kunvertuh.view.AboutView;

public final class AboutPresenter extends AbstractPresenter<AboutView, Browser> {

  @Inject
  public AboutPresenter(AboutView view, Browser model) {
    super(view, model);
  }

  @Override
  public void onInitialization() {
    getView().setVersion("Version: -");
    getView().setLicense("Licensed under GPL v3.0");
    getView().setContactPrompt("For more information, feel free to contact me.");
    getView().setContactUri("https://ivanvinski.com/contact/");
    getView().setRepositoryPrompt("Fork me on Github");
    getView().setRepositoryPage("https://github.com/ivanvinski/kunvertuh");
    getView().setAuthorName("Ivan Vinski");
    getView().setAuthorUri("https://ivanvinski.com/");
    getView().setAuthorGithubUri("https://github.com/ivanvinski");
  }

  @Subscribe
  public void onOpenInBrowser(OpenInBrowserEvent event) {
    getModel().open(event.getUri());
  }
}
