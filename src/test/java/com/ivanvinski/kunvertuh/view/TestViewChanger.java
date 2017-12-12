package com.ivanvinski.kunvertuh.view;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class TestViewChanger {

  private Map views = new LinkedHashMap();
  private ViewChanger viewChanger;

  @Before
  public void setUp() {
    views.put(String.class, "abc");
    views.put(Integer.class, 123);
    viewChanger = new ViewChangerMock(views);
  }

  @Test(expected = NullPointerException.class)
  public void nullViewsMapInitializationThrowsException() {
    new ViewChangerMock(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void emptyViewsMapInitializationThrowsException() {
    new ViewChangerMock(new HashMap());
  }

  @Test(expected = NullPointerException.class)
  public void changeToNullViewThrowsException() {
    viewChanger.changeView(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void changeToNonExistentViewThrowsException() {
    viewChanger.changeView(Double.class);
  }

  @Test
  public void initialActiveViewIsFirstInViewsMap() {
    assertEquals(views.values().iterator().next(), viewChanger.getActiveView());
  }

  @Test
  public void changeToExistentViewAppliesThatView() {
    viewChanger.changeView(Integer.class);
    assertEquals(views.get(Integer.class), viewChanger.getActiveView());
  }
}
