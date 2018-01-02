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

package com.ivanvinski.kunvertuh.mvp.model;

import com.ivanvinski.kunvertuh.mvp.view.View;
import java.util.HashMap;
import java.util.Map;

public class MainModel {

  private Map<String, View> views = new HashMap<>();
  private Map<View, String> identifiers = new HashMap<>();
  private View activeView;

  public View getActiveView() {
    return activeView;
  }

  public void setActiveView(String viewIdentifier) {
    View nextView = getView(viewIdentifier);
    if (nextView == null) {
      throw new IllegalArgumentException("Can't set non-existent view: " + viewIdentifier);
    } else if (activeView != nextView) {
      activeView = nextView;
    }
  }

  public Map<String, View> getViews() {
    return views;
  }

  public View getView(String viewIdentifier) {
    return views.get(viewIdentifier);
  }

  public String getIdentifier(View view) {
    return identifiers.get(view);
  }

  public void setViews(Map<String, View> views) {
    this.views = views;
    views.forEach((identifier, view) -> identifiers.put(view, identifier));
  }
}
