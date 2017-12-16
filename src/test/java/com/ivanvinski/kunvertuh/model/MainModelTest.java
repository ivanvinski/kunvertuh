package com.ivanvinski.kunvertuh.model;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.MassUnitsView;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.mock.LengthUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class MainModelTest {

  private MainModel model;

  @Before
  public void setUp() {
    ViewCatalog viewCatalog = new ViewCatalog();
    viewCatalog.add(new LengthUnitsViewMock());
    model = new MainModel(viewCatalog);
  }

  @Test(expected = NullPointerException.class)
  public void nullViewsInitializationThrowsException() {
    new MainModel(null);
  }

  @Test(expected = NullPointerException.class)
  public void viewRetrievalByNonExistentAbstractionTypeThrowsException() {
    model.getView(MassUnitsView.class);
  }

  @Test
  public void viewRetrievalByAbstractionTypeReturnsViewImplementation() {
    assertEquals(LengthUnitsViewMock.class, model.getView(LengthUnitsView.class).getClass());
  }
}
