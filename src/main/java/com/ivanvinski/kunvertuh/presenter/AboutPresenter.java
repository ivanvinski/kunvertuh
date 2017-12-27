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
    getView().setContactUri("https://ivanvinski.com/contact/");
    getView().setRepositoryPrompt("Fork me on Github");
    getView().setRepositoryPage("https://github.com/ivanvinski/kunvertuh");
    getView().setAuthorUri("https://ivanvinski.com/");
    getView().setAuthorGithubUri("https://github.com/ivanvinski");
    getView().addDependencyCredit("Guava", "https://github.com/google/guava",
        "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.txt");
    getView().addDependencyCredit("Guice", "https://github.com/google/guice",
        "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.txt");
    getView().addDependencyCredit("JFoenix", "http://jfoenix.com/",
        "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.txt");
    getView().addDependencyCredit("FontAwesomeFX", "https://bitbucket.org/Jerady/fontawesomefx",
        "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.txt");
    getView().addDependencyCredit("JUnit", "https://github.com/junit-team/junit4",
        "Eclipse Public License 1.0", "https://www.eclipse.org/legal/epl-v10.html");
    getView().addDependencyCredit("Mockito", "https://github.com/mockito/mockito",
        "MIT", "https://mit-license.org/");
  }

  @Subscribe
  public void onOpenInBrowser(OpenInBrowserEvent event) {
    getModel().open(event.getUri());
  }
}
