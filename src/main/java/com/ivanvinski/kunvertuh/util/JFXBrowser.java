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

package com.ivanvinski.kunvertuh.util;

import com.google.inject.Inject;
import java.util.Objects;
import javafx.application.HostServices;

public final class JFXBrowser implements Browser {

  private HostServices hostServices;

  @Inject
  public JFXBrowser(HostServices hostServices) {
    this.hostServices = Objects.requireNonNull(hostServices, "Host services can't be null");
  }

  @Override
  public void open(String uri) {
    hostServices.showDocument(uri);
  }
}
