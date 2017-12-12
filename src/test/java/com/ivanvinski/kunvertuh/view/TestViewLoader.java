package com.ivanvinski.kunvertuh.view;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import org.junit.Test;

public class TestViewLoader {

  private static final URL TEST_PARENT_LOCATION = TestViewLoader.class
      .getResource("/view/test-parent.fxml");
  private static final URL TEST_NON_PARENT_LOCATION = TestViewLoader.class
      .getResource("/view/test-non-parent.fxml");

  private ViewLoader viewLoader = new ViewLoader();

  @Test(expected = IllegalStateException.class)
  public void nullUrlLoadingThrowsException() {
    viewLoader.load(null);
  }

  @Test(expected = ClassCastException.class)
  public void nonParentViewClassLoadingThrowsException() {
    viewLoader.load(TEST_NON_PARENT_LOCATION);
  }

  @Test(expected = IllegalArgumentException.class)
  public void duplicateViewLoadingThrowsException() {
    viewLoader.load(TEST_PARENT_LOCATION);
    viewLoader.load(TEST_PARENT_LOCATION);
  }

  @Test
  public void validViewLoadingRegistersView() {
    viewLoader.load(TEST_PARENT_LOCATION);
    assertEquals(TestParentView.class,
        viewLoader.getLoadedViews().get(TestParentView.class).getClass());
  }
}
