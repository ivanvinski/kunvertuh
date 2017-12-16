package com.ivanvinski.kunvertuh.view.javafx;

import static org.junit.Assert.assertEquals;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.module.TestParentViewPresenterModule;
import com.ivanvinski.kunvertuh.view.TestParentView;
import com.ivanvinski.kunvertuh.view.ViewLoader;
import java.io.UncheckedIOException;
import java.net.URL;
import org.junit.Test;

public class ViewLoaderImplTest {

  private static final URL TEST_PARENT_LOCATION = ViewLoaderImplTest.class
      .getResource("/view/test-parent.fxml");
  private static final URL TEST_NON_PARENT_LOCATION = ViewLoaderImplTest.class
      .getResource("/view/test-non-parent.fxml");
  private static final AbstractModule moduleStub = new AbstractModule() {
    @Override
    protected void configure() {
    }
  };

  private ViewLoader viewLoader = new ViewLoaderImpl();

  @Test(expected = IllegalStateException.class)
  public void nullUrlLoadingThrowsException() {
    viewLoader.load(null, moduleStub);
  }

  @Test(expected = NullPointerException.class)
  public void nullModuleLoadingThrowsException() {
    viewLoader.load(TEST_PARENT_LOCATION, null);
  }

  @Test(expected = UncheckedIOException.class)
  public void nonParentViewClassLoadingThrowsException() {
    viewLoader.load(TEST_NON_PARENT_LOCATION, moduleStub);
  }

  @Test(expected = IllegalArgumentException.class)
  public void duplicateViewLoadingThrowsException() {
    viewLoader.load(TEST_PARENT_LOCATION, new TestParentViewPresenterModule());
    viewLoader.load(TEST_PARENT_LOCATION, new TestParentViewPresenterModule());
  }

  @Test
  public void validViewLoadingRegistersView() {
    viewLoader.load(TEST_PARENT_LOCATION, new TestParentViewPresenterModule());
    assertEquals(TestParentView.class,
        viewLoader.getLoadedViews().get(TestParentView.class).getClass());
  }
}
