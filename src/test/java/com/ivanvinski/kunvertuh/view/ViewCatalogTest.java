package com.ivanvinski.kunvertuh.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ViewCatalogTest {

  private ViewCatalog viewCatalog = new ViewCatalog();
  private View view = new View() {
  };

  @Test(expected = NullPointerException.class)
  public void nullViewAdditionThrowsException() {
    viewCatalog.add(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void duplicateViewAdditionThrowsException() {
    viewCatalog.add(view);
    viewCatalog.add(view);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonAddedViewRetrievalThrowsException() {
    viewCatalog.get(view.getClass());
  }

  @Test
  public void addedViewRetrievalReturnsView() {
    viewCatalog.add(view);
    assertEquals(view, viewCatalog.get(view.getClass()));
  }
}
