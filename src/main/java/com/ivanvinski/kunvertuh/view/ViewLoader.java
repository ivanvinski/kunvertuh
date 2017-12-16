package com.ivanvinski.kunvertuh.view;

import com.google.inject.AbstractModule;
import java.net.URL;

public interface ViewLoader {

  void load(URL location, AbstractModule presenterModule);

  ViewCatalog getLoadedViews();
}
