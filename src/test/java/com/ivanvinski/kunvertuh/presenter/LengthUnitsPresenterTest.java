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

import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.unit.LengthUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.mock.LengthUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class LengthUnitsPresenterTest {

  private static final String SOURCE_LENGTH = "500";

  private DoubleStringConverter valueConverter = new DoubleStringConverter();
  private String formattedSourceLength = valueConverter.format(valueConverter.parse(SOURCE_LENGTH));

  private LengthUnitsViewMock view = new LengthUnitsViewMock();
  private LengthUnitsModel model = new LengthUnitsModel();
  private LengthUnitsPresenter presenter = new LengthUnitsPresenter(view, model, valueConverter);

  @Before
  public void setUp() {
    presenter.initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new LengthUnitsPresenter(null, model, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new LengthUnitsPresenter(view, null, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullValueConverterInstantiationThrowsException() {
    new LengthUnitsPresenter(view, model, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setMeters("abc12.dfg");
    view.fireMetersActionEvent();
    assertEquals("", view.getMeters());
  }

  @Test
  public void millimetersActionEventInvokesConversion() {
    view.setMillimeters(SOURCE_LENGTH);
    view.fireMillimetersActionEvent();
    assertEquals(0.5d, model.getMeters(), METRIC_DELTA);
  }

  @Test
  public void millimetersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.MILLIMETER);
    assertEquals(formattedSourceLength, view.getMillimeters());
  }

  @Test
  public void centimetersActionEventInvokesConversion() {
    view.setCentimeters(SOURCE_LENGTH);
    view.fireCentimetersActionEvent();
    assertEquals(5d, model.getMeters(), METRIC_DELTA);
  }

  @Test
  public void centimetersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.CENTIMETER);
    assertEquals(formattedSourceLength, view.getCentimeters());
  }

  @Test
  public void decimetersActionEventInvokesConversion() {
    view.setDecimeters(SOURCE_LENGTH);
    view.fireDecimetersActionEvent();
    assertEquals(50d, model.getMeters(), METRIC_DELTA);
  }

  @Test
  public void decimetersConversionUpdateView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.DECIMETER);
    assertEquals(formattedSourceLength, view.getDecimeters());
  }

  @Test
  public void metersActionEventInvokesConversion() {
    view.setMeters(SOURCE_LENGTH);
    view.fireMetersActionEvent();
    assertEquals(50000d, model.getCentimeters(), METRIC_DELTA);
  }

  @Test
  public void metersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.METER);
    assertEquals(formattedSourceLength, view.getMeters());
  }

  @Test
  public void kilometersActionEventInvokesConversion() {
    view.setKilometers(SOURCE_LENGTH);
    view.fireKilometersActionEvent();
    assertEquals(500000d, model.getMeters(), METRIC_DELTA);
  }

  @Test
  public void kilometersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.KILOMETER);
    assertEquals(formattedSourceLength, view.getKilometers());
  }

  @Test
  public void inchesActionEventInvokesConversion() {
    view.setInches(SOURCE_LENGTH);
    view.fireInchesActionEvent();
    assertEquals(12.7d, model.getMeters(), IMPERIAL_DELTA);
  }

  @Test
  public void inchesConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.INCH);
    assertEquals(formattedSourceLength, view.getInches());
  }

  @Test
  public void feetActionEventInvokesConversion() {
    view.setFeet(SOURCE_LENGTH);
    view.fireFeetActionEvent();
    assertEquals(152.4d, model.getMeters(), IMPERIAL_DELTA);
  }

  @Test
  public void feetConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.FOOT);
    assertEquals(formattedSourceLength, view.getFeet());
  }

  @Test
  public void yardsActionEventInvokesConversion() {
    view.setYards(SOURCE_LENGTH);
    view.fireYardsActionEvent();
    assertEquals(457.2d, model.getMeters(), IMPERIAL_DELTA);
  }

  @Test
  public void yardsConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.YARD);
    assertEquals(formattedSourceLength, view.getYards());
  }

  @Test
  public void milesActionEventInvokesConversion() {
    view.setMiles(SOURCE_LENGTH);
    view.fireMilesActionEvent();
    assertEquals(804.672d, model.getKilometers(), IMPERIAL_DELTA);
  }

  @Test
  public void milesConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, LengthUnit.MILE);
    assertEquals(formattedSourceLength, view.getMiles());
  }
}
