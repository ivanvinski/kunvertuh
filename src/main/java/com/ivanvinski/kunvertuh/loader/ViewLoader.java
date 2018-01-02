package com.ivanvinski.kunvertuh.loader;

import com.ivanvinski.kunvertuh.view.View;
import java.util.Map;

public interface ViewLoader<R> {

  void loadView(String identifier, R resource);

  void loadViewTemplate(String identifier, R resource, Class<?> presenterType);

  Map<String, View> getLoadedViews();
}
