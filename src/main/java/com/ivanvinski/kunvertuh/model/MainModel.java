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

package com.ivanvinski.kunvertuh.model;

import com.google.inject.Inject;
import com.ivanvinski.kunvertuh.view.View;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import java.util.Objects;

public class MainModel {

  private ViewCatalog views;
  private View activeView;
  private String activeViewIdentifier;

  @Inject
  public MainModel(ViewCatalog views) {
    this.views = Objects.requireNonNull(views, "View catalog can't be null");
  }

  public View getActiveView() {
    return activeView;
  }

  public void setActiveView(String identifier) {
    activeView = views.getView(identifier);
    activeViewIdentifier = identifier;
  }

  public String getActiveViewIdentifier() {
    return activeViewIdentifier;
  }
}
