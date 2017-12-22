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

package com.ivanvinski.kunvertuh.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ViewCatalog {

  private Map<Class<? extends View>, View> views = new HashMap<>();

  public void add(View view) {
    Objects.requireNonNull(view, "Can't add null view");
    Class<? extends View> viewType = view.getClass();
    if (contains(viewType)) {
      getViews().stream().map(Object::getClass).forEach(System.out::println);
      throw new IllegalArgumentException("Duplicate views are not allowed: " + viewType);
    } else {
      views.put(viewType, view);
    }
  }

  public Collection<View> getViews() {
    return views.values();
  }

  public View get(Class<? extends View> viewType) {
    if (!contains(viewType)) {
      throw new IllegalArgumentException("View does not exist: " + viewType);
    }
    return views.get(viewType) == null ? getIfAssignable(viewType) : views.get(viewType);
  }

  public boolean contains(Class<? extends View> viewType) {
    return views.containsKey(viewType) || getIfAssignable(viewType) != null;
  }

  private View getIfAssignable(Class<? extends View> assignableType) {
    for (View view : getViews()) {
      if (assignableType.isAssignableFrom(view.getClass())) {
        return view;
      }
    }
    return null;
  }
}
