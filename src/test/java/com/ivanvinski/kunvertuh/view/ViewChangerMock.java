package com.ivanvinski.kunvertuh.view;

import java.util.Map;

public class ViewChangerMock extends ViewChanger {

  public ViewChangerMock(Map views) {
    super(views);
  }

  @Override
  protected void onViewChange(Object activeView, Object nextView) {
  }

  @Override
  protected void applyView(Object view) {
  }
}
