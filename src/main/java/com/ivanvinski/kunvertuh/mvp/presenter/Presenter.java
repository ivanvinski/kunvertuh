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
import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.mvp.view.View;
import java.util.Objects;

public abstract class Presenter<V extends View, M> {

  private V view;
  private M model;
  private EventStream eventStream;

  public Presenter(V view, M model, EventStream eventStream) {
    this.view = Objects.requireNonNull(view, "View can't be null");
    this.model = Objects.requireNonNull(model, "Model can't be null");
    this.eventStream = Objects.requireNonNull(eventStream, "Event stream can't be null");
  }

  public abstract void onInitialized();

  @Subscribe
  public abstract void onLanguageChanged(Language language);

  public V getView() {
    return view;
  }

  public M getModel() {
    return model;
  }

  public EventStream getEventStream() {
    return eventStream;
  }
}
