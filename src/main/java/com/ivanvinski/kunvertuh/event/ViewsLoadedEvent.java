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

package com.ivanvinski.kunvertuh.event;

import com.ivanvinski.kunvertuh.mvp.view.View;
import java.util.Map;

public final class ViewsLoadedEvent {

  private Map<String, View> loadedViews;

  public ViewsLoadedEvent(Map<String, View> loadedViews) {
    this.loadedViews = loadedViews;
  }

  public Map<String, View> getLoadedViews() {
    return loadedViews;
  }
}