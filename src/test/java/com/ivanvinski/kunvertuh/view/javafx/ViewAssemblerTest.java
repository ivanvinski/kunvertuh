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

import static org.junit.Assert.assertEquals;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.module.TestParentViewPresenterModule;
import com.ivanvinski.kunvertuh.presenter.TestParentViewPresenter;
import com.ivanvinski.kunvertuh.view.TestParentView;
import org.junit.Test;

public class ViewAssemblerTest {

  @Test(expected = NullPointerException.class)
  public void nullModuleInitializationThrowsException() {
    new ViewAssembler(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPresenterTypeAssemblyThrowsException() {
    new ViewAssembler(new AbstractModule() {
      @Override
      protected void configure() {

      }
    }).call(Object.class);
  }

  @Test
  public void presenterTypeAssemblyReturnsView() {
    TestParentView actual = (TestParentView) new ViewAssembler(new TestParentViewPresenterModule())
        .call(TestParentViewPresenter.class);
    assertEquals(TestParentView.class, actual.getClass());
  }

  @Test
  public void presenterTypeAssemblySetsPresenter() {
    ViewAssembler viewAssembler = new ViewAssembler(new TestParentViewPresenterModule());
    viewAssembler.call(TestParentViewPresenter.class);
    assertEquals(TestParentViewPresenter.class, viewAssembler.getPresenter().getClass());
  }
}
