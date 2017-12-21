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

package com.ivanvinski.kunvertuh.view.mock;

import com.ivanvinski.kunvertuh.view.MainView;
import com.ivanvinski.kunvertuh.view.View;

public class MainViewMock implements MainView {

  private Runnable lengthAction, massAction, volumeAction, aboutAction;
  private View activeView;

  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    activeView = view;
  }

  @Override
  public void setOnLengthActionEvent(Runnable action) {
    lengthAction = action;
  }

  public void fireLengthActionEvent() {
    lengthAction.run();
  }

  @Override
  public void setOnMassActionEvent(Runnable action) {
    massAction = action;
  }

  public void fireMassActionEvent() {
    massAction.run();
  }

  @Override
  public void setOnVolumeActionEvent(Runnable action) {
    volumeAction = action;
  }

  public void fireVolumeActionEvent() {
    volumeAction.run();
  }

  @Override
  public void setOnAboutActionEvent(Runnable action) {
    aboutAction = action;
  }

  public void fireAboutActionEvent() {
    aboutAction.run();
  }
}
