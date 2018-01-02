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

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.model.AboutModel;
import com.ivanvinski.kunvertuh.view.AboutView;

public final class AboutPresenter extends Presenter<AboutView, AboutModel> {

  public AboutPresenter(AboutView view, AboutModel model, EventStream eventStream) {
    super(view, model, eventStream);
  }

  @Override
  public void onInitialized() {
    getView().setName(getModel().getName());
    getView().setLicense(getModel().getLicenseText());
    getView().setOnDeveloperWebsiteClicked(() -> browse(getModel().getDeveloperWebsite()));
    getView().setOnDeveloperGithubClicked(() -> browse(getModel().getDeveloperGithub()));
    getView().setOnProjectRepositoryClicked(() -> browse(getModel().getRepositoryUri()));
    getView().setOnJFoenixLicenseClicked(() -> browse(getModel().getApacheLicenseUri()));
    getView().setOnJFoenixClicked(() -> browse(getModel().getJfoenixUri()));
    getView().setOnFontAwesomeFXLicenseClicked(() -> browse(getModel().getApacheLicenseUri()));
    getView().setOnFontAwesomeFXClicked(() -> browse(getModel().getFontAwesomeFxUri()));
    getView().setOnGuavaLicenseClicked(() -> browse(getModel().getApacheLicenseUri()));
    getView().setOnGuavaClicked(() -> browse(getModel().getGuavaUri()));
  }

  @Override
  public void onLanguageChanged(Language language) {
    getView().setVersion(language.getString("VERSION") + ' ' + getModel().getVersion());
    getView().setTagline(language.getString("TAGLINE"));
    getView().setDeveloper(getModel().getDeveloper());
    getView().setDeveloperRoleText(language.getString("DEVELOPER_ROLE"));
    getView().setDeveloperWebsiteText(language.getString("WEBSITE"));
    getView().setOpenSourceHeading(language.getString("OPEN_SOURCE"));
    getView().setLicensePrompt(language.getString("LICENSE") + ": " + getModel().getLicense());
    getView().setProjectRepositoryText(language.getString("FORK_ME"));
    getView().setDependenciesHeader(language.getString("OPEN_SOURCE_DEPENDENCIES"));
    getView().setJFoenixNote(language.getString("JFOENIX_NOTE"));
    getView().setJFoenixWebsiteText(language.getString("WEBSITE"));
    getView().setFontAwesomeFXNote(language.getString("FONT_AWESOME_FX_NOTE"));
    getView().setFontAwesomeFXWebsiteText(language.getString("REPOSITORY"));
    getView().setGuavaNote(language.getString("GUAVA_NOTE"));
    getView().setGuavaWebsiteText(language.getString("REPOSITORY"));
  }

  private void browse(String uri) {
    getModel().browse(uri);
  }
}
