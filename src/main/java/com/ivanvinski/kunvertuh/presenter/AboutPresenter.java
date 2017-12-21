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

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.util.Browser;
import com.ivanvinski.kunvertuh.view.AboutView;

public final class AboutPresenter extends AbstractPresenter<AboutView, Browser> {

  @Inject
  public AboutPresenter(AboutView view, Browser model) {
    super(view, model);
  }

  @Override
  public void initialize() {
    getView().setVersion("Version: -");
    getView().setLicense("Licensed under GPL v3.0");
    getView().setContactText("For more information, feel free to contact me.");
    getView().setContactPage("https://ivanvinski.com/contact/");
    getView().setRepositoryText("Fork me on Github");
    getView().setRepositoryPage("https://github.com/ivanvinski/kunvertuh");
    getView().setAuthor("Ivan Vinski");
    getView().setAuthorPage("https://ivanvinski.com/");
    getView().setAuthorGithub("https://github.com/ivanvinski");
  }

  public void openInBrowser(String uri) {
    getModel().open(uri);
  }
}
