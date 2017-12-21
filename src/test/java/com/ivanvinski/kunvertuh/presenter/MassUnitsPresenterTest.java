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

package com.ivanvinski.kunvertuh.presenter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.unit.MassUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.mock.MassUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class MassUnitsPresenterTest {

  private static final String SOURCE_MASS = "5";

  private DoubleStringConverter valueConverter = new DoubleStringConverter();
  private String formattedSourceMass = valueConverter.format(valueConverter.parse(SOURCE_MASS));

  private MassUnitsViewMock view = new MassUnitsViewMock();
  private MassUnitsModel model = new MassUnitsModel();
  private MassUnitsPresenter presenter = new MassUnitsPresenter(view, model, valueConverter);

  @Before
  public void setUp() {
    presenter.initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new MassUnitsPresenter(null, model, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new MassUnitsPresenter(view, null, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullValueConverterInstantiationThrowsException() {
    new MassUnitsPresenter(view, model, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setGrams("abc12.dfg");
    view.fireGramsActionEvent();
    assertEquals("", view.getGrams());
  }

  @Test
  public void milligramsActionEventInvokesConversion() {
    view.setMilligrams(SOURCE_MASS);
    view.fireMilligramsActionEvent();
    assertEquals(0.005d, model.getGrams(), METRIC_DELTA);
  }

  @Test
  public void milligramsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.MILLIGRAMS);
    assertEquals(formattedSourceMass, view.getMilligrams());
  }

  @Test
  public void gramsActionEventInvokesConversion() {
    view.setGrams(SOURCE_MASS);
    view.fireGramsActionEvent();
    assertEquals(5d, model.getGrams(), METRIC_DELTA);
  }

  @Test
  public void gramsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.GRAMS);
    assertEquals(formattedSourceMass, view.getGrams());
  }

  @Test
  public void dekagramsActionEventInvokesConversion() {
    view.setDekagrams(SOURCE_MASS);
    view.fireDekagramsActionEvent();
    assertEquals(50d, model.getGrams(), METRIC_DELTA);
  }

  @Test
  public void dekagramsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.DEKAGRAMS);
    assertEquals(formattedSourceMass, view.getDekagrams());
  }

  @Test
  public void kilogramsActionEventInvokesConversion() {
    view.setKilograms(SOURCE_MASS);
    view.fireKilogramsActionEvent();
    assertEquals(5000d, model.getGrams(), METRIC_DELTA);
  }

  @Test
  public void kilogramConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.KILOGRAMS);
    assertEquals(formattedSourceMass, view.getKilograms());
  }

  @Test
  public void grainsActionEventInvokesConversion() {
    view.setGrains(SOURCE_MASS);
    view.fireGrainsActionEvent();
    assertEquals(0.324d, model.getGrams(), IMPERIAL_DELTA);
  }

  @Test
  public void grainsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.GRAINS);
    assertEquals(formattedSourceMass, view.getGrains());
  }

  @Test
  public void dramsActionEventInvokesConversion() {
    view.setDrams(SOURCE_MASS);
    view.fireDramsActionEvent();
    assertEquals(8.86d, model.getGrams(), IMPERIAL_DELTA);
  }

  @Test
  public void dramsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.DRAMS);
    assertEquals(formattedSourceMass, view.getDrams());
  }

  @Test
  public void ouncesActionEventInvokesConversion() {
    view.setOunces(SOURCE_MASS);
    view.fireOuncesActionEvent();
    assertEquals(141.7476d, model.getGrams(), IMPERIAL_DELTA);
  }

  @Test
  public void ouncesConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.OUNCES);
    assertEquals(formattedSourceMass, view.getOunces());
  }

  @Test
  public void poundsActionEventInvokesConversion() {
    view.setPounds(SOURCE_MASS);
    view.firePoundsActionEvent();
    assertEquals(2267.962d, model.getGrams(), IMPERIAL_DELTA);
  }

  @Test
  public void poundsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, MassUnit.POUNDS);
    assertEquals(formattedSourceMass, view.getPounds());
  }
}
