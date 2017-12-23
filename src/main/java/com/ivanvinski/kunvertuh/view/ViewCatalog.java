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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ViewCatalog {

  private Map<String, View> views = new HashMap<>();

  public void addView(String identifier, View view) {
    Objects.requireNonNull(identifier, "Identifier can't be null");
    throwExceptionIfDuplicateIdentifier(identifier);
    Objects.requireNonNull(view, "Can't add null view");
    throwExceptionIfDuplicateView(view.getClass());
    views.put(identifier, view);
  }

  public <V extends View> V getView(String identifier) {
    if (!containsIdentifier(identifier)) {
      throw new IllegalArgumentException("View not added: identifier=" + identifier);
    }
    return (V) views.get(identifier);
  }

  public boolean containsIdentifier(String identifier) {
    return identifier != null && views.containsKey(identifier);
  }

  public boolean containsView(Class<? extends View> viewType) {
    for (View view : views.values()) {
      if (viewType == view.getClass()) {
        return true;
      }
    }
    return false;
  }

  private void throwExceptionIfDuplicateIdentifier(String identifier) {
    if (containsIdentifier(identifier)) {
      throw new IllegalArgumentException("Duplicate identifier: " + identifier);
    }
  }

  private void throwExceptionIfDuplicateView(Class<? extends View> viewType) {
    if (containsView(viewType)) {
      throw new IllegalArgumentException("Duplicate view: " + viewType.getClass());
    }
  }
}
