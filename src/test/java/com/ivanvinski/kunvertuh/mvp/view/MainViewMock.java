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

package com.ivanvinski.kunvertuh.mvp.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class MainViewMock implements MainView {

  public static final String ITEM_SEPARATOR = "%ITEM_SEPARATOR%";

  private List<String> navigationItems = new ArrayList<>();
  private String selectedNavigationItem;
  private String appBarTitle;
  private Map<String, String> navigationButtonsText = new HashMap<>();
  private Consumer<String> navigationItemClickAction;
  private View activeView;

  @Override
  public void initialize() {
  }

  @Override
  public void addNavigationItem(String viewIdentifier) {
    navigationItems.add(viewIdentifier);
  }

  @Override
  public void addNavigationItemSeparator() {
    navigationItems.add(ITEM_SEPARATOR);
  }

  @Override
  public void selectNavigationItem(String viewIdentifier) {
    selectedNavigationItem = navigationItems.stream()
        .filter(viewIdentifier::equals)
        .findFirst()
        .orElse("%FAIL%");
  }

  @Override
  public String getSelectedNavigationItem() {
    return selectedNavigationItem;
  }

  @Override
  public String getAppBarTitle() {
    return appBarTitle;
  }

  @Override
  public void setAppBarTitle(String appBarTitle) {
    this.appBarTitle = appBarTitle;
  }

  @Override
  public String getNavigationButtonText(String viewIdentifier) {
    return navigationButtonsText.get(viewIdentifier);
  }

  @Override
  public void setNavigationButtonText(String viewIdentifier, String buttonText) {
    navigationButtonsText.put(viewIdentifier, buttonText);
  }

  @Override
  public boolean containsNavigationButton(String viewIdentifier) {
    return navigationButtonsText.containsKey(viewIdentifier);
  }

  @Override
  public Consumer<String> getOnNavigationItemClicked() {
    return navigationItemClickAction;
  }

  @Override
  public void setOnNavigationItemClicked(Consumer<String> navigationItemClickAction) {
    this.navigationItemClickAction = navigationItemClickAction;
  }

  @Override
  public View getActiveView() {
    return activeView;
  }

  @Override
  public void setActiveView(View view) {
    activeView = view;
  }
}
