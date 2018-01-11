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

package com.ivanvinski.kunvertuh.mvp.model;

import com.ivanvinski.kunvertuh.measurement.Unit;
import com.ivanvinski.kunvertuh.measurement.UnitCategory;
import com.ivanvinski.kunvertuh.measurement.UnitConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConverterModel<U extends Unit> {

  private Map<UnitCategory, List<U>> categorizedUnits;
  private UnitConverter<U> converter;

  public ConverterModel(U[] units) {
    this(new UnitConverter<>(units));
  }

  public ConverterModel(UnitConverter<U> converter) {
    this.converter = converter;
    categorizedUnits = categorizeUnits(converter.getSupportedUnits());
  }

  public Collection<UnitCategory> getCategories() {
    return categorizedUnits.keySet();
  }

  public List<U> getUnits(UnitCategory category) {
    return categorizedUnits.get(category);
  }

  public Collection<U> getAllUnits() {
    return getConverter().getSupportedUnits();
  }

  public UnitConverter<U> getConverter() {
    return converter;
  }

  private Map<UnitCategory, List<U>> categorizeUnits(Collection<U> units) {
    Map<UnitCategory, List<U>> categorizedUnits = new HashMap<>();
    units.forEach(unit -> {
      categorizedUnits.putIfAbsent(unit.getCategory(), new ArrayList<>());
      categorizedUnits.get(unit.getCategory()).add(unit);
    });
    return categorizedUnits;
  }
}
