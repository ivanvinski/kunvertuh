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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.ivanvinski.kunvertuh.event.EventStream;
import com.ivanvinski.kunvertuh.i18n.Language;
import com.ivanvinski.kunvertuh.measurement.Length;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import com.ivanvinski.kunvertuh.mvp.model.ConverterModel;
import com.ivanvinski.kunvertuh.mvp.view.ConverterView;
import com.ivanvinski.kunvertuh.mvp.view.ConverterViewMock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ConverterPresenterTest {

  private ConverterView<Length> view = new ConverterViewMock<>();
  private UnitConverter<Length> converter = Mockito.spy(new UnitConverter<>(Length.values()));
  private ConverterModel<Length> model = new ConverterModel<>(converter);
  private EventStream eventStream = Mockito.mock(EventStream.class);
  private ConverterPresenter<Length> presenter = Mockito
      .spy(new ConverterPresenter<>(view, model, eventStream));

  @Before
  public void setUp() {
    presenter.onInitialized();
  }

  @Test
  public void conversionActionsForAllSupportedUnitsAreInitialized() {
    converter.getSupportedUnits().forEach(unit ->
        assertNotNull("Conversion action not set for: " + unit.toString(), unit));
  }

  @Test
  public void unitPromptsAreChangedOnLanguageChange() {
    final Language language = Language.CROATIAN;
    presenter.onLanguageChanged(language);
    converter.getSupportedUnits().forEach(unit ->
        assertEquals("Incorrect prompt for unit: " + unit.toString(),
            language.getString(unit.toString()),
            view.getUnitPrompt(unit)));
  }

  @Test
  public void unitValuesAreChangedOnConversion() {
    presenter.onConversionRequested(Length.KILOMETER, "100");
    converter.getSupportedUnits().forEach(unit ->
        assertNotEquals("Value not set for unit: " + unit.toString(),
            "",
            view.getUnitValue(unit)));
  }
}
