package com.ivanvinski.kunvertuh.mvp.loader;

import com.ivanvinski.kunvertuh.mvp.view.View;
import java.util.Map;

public interface ViewLoader<R> {

  void loadView(String identifier, R resource);

  void loadViewTemplate(String identifier, R resource, Class<?> presenterType);

  Map<String, View> getLoadedViews();
}
