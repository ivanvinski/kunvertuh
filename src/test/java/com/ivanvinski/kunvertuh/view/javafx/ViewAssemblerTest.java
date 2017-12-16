package com.ivanvinski.kunvertuh.view.javafx;

import static org.junit.Assert.assertEquals;

import com.google.inject.AbstractModule;
import com.ivanvinski.kunvertuh.module.TestParentViewPresenterModule;
import com.ivanvinski.kunvertuh.presenter.TestParentViewPresenter;
import com.ivanvinski.kunvertuh.view.TestParentView;
import org.junit.Test;

public class ViewAssemblerTest {

  @Test(expected = NullPointerException.class)
  public void nullModuleInitializationThrowsException() {
    new ViewAssembler(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPresenterTypeAssemblyThrowsException() {
    new ViewAssembler(new AbstractModule() {
      @Override
      protected void configure() {

      }
    }).call(Object.class);
  }

  @Test
  public void presenterTypeAssemblyReturnsView() {
    TestParentView actual = (TestParentView) new ViewAssembler(new TestParentViewPresenterModule())
        .call(TestParentViewPresenter.class);
    assertEquals(TestParentView.class, actual.getClass());
  }

  @Test
  public void presenterTypeAssemblySetsPresenter() {
    ViewAssembler viewAssembler = new ViewAssembler(new TestParentViewPresenterModule());
    viewAssembler.call(TestParentViewPresenter.class);
    assertEquals(TestParentViewPresenter.class, viewAssembler.getPresenter().getClass());
  }
}
