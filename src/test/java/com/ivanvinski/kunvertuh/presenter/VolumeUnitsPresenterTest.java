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

import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.mock.VolumeUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class VolumeUnitsPresenterTest {

  private static final String SOURCE_VOLUME = "15";

  private DoubleStringConverter valueConverter = new DoubleStringConverter();
  private String formattedSourceVolume = valueConverter.format(valueConverter.parse(SOURCE_VOLUME));

  private VolumeUnitsViewMock view = new VolumeUnitsViewMock();
  private VolumeUnitsModel model = new VolumeUnitsModel();
  private VolumeUnitsPresenter presenter = new VolumeUnitsPresenter(view, model, valueConverter);

  @Before
  public void setUp() {
    presenter.initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new VolumeUnitsPresenter(null, model, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new VolumeUnitsPresenter(view, null, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullValueConverterInstantiationThrowsException() {
    new VolumeUnitsPresenter(view, model, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setLiters("abc12.dfg");
    view.fireLitersActionEvent();
    assertEquals("", view.getLiters());
  }

  @Test
  public void millilitersActionEventInvokesConversion() {
    view.setMilliliters(SOURCE_VOLUME);
    view.fireMillilitersActionEvent();
    assertEquals(0.015d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void millilitersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.MILLILITER);
    assertEquals(formattedSourceVolume, view.getMilliliters());
  }

  @Test
  public void litersActionEventInvokesConversion() {
    view.setLiters(SOURCE_VOLUME);
    view.fireLitersActionEvent();
    assertEquals(15d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void litersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.LITER);
    assertEquals(formattedSourceVolume, view.getLiters());
  }

  @Test
  public void cubicMetersActionEventInvokesConversion() {
    view.setCubicMeters(SOURCE_VOLUME);
    view.fireCubicMetersActionEvent();
    assertEquals(15000d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void cubicMetersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.CUBIC_METER);
    assertEquals(formattedSourceVolume, view.getCubicMeters());
  }

  @Test
  public void fluidOuncesActionEventInvokesConversion() {
    view.setFluidOunces(SOURCE_VOLUME);
    view.fireFluidOuncesActionEvent();
    assertEquals(.426d, model.getLiters(), IMPERIAL_DELTA);
  }

  @Test
  public void fluidOuncesConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.UK_FLUID_OUNCE);
    assertEquals(formattedSourceVolume, view.getFluidOunces());
  }

  @Test
  public void pintsActionEventInvokesConversion() {
    view.setPints(SOURCE_VOLUME);
    view.firePintsActionEvent();
    assertEquals(8.524d, model.getLiters(), IMPERIAL_DELTA);
  }

  @Test
  public void pintsConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.PINT);
    assertEquals(formattedSourceVolume, view.getPints());
  }

  @Test
  public void gallonsActionEventInvokesConversion() {
    view.setGallons(SOURCE_VOLUME);
    view.fireGallonsActionEvent();
    assertEquals(68.191d, model.getLiters(), IMPERIAL_DELTA);
  }

  @Test
  public void gallonsConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.UK_GALLON);
    assertEquals(formattedSourceVolume, view.getGallons());
  }
}
