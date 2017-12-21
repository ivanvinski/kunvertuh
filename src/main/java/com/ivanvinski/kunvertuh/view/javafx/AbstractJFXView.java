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

package com.ivanvinski.kunvertuh.view.javafx;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.view.View;
import java.util.Objects;
import javafx.scene.layout.StackPane;

public abstract class AbstractJFXView extends StackPane implements View {

  private EventStream eventStream;

  public AbstractJFXView(EventStream eventStream) {
    this.eventStream = Objects.requireNonNull(eventStream, "Event streams can't be null");
  }

  @Override
  public void pushEvent(Object event) {
    eventStream.push(event);
  }
}
