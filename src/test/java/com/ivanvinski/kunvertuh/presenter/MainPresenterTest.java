package com.ivanvinski.kunvertuh.presenter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.mock.AboutViewMock;
import com.ivanvinski.kunvertuh.view.mock.LengthUnitsViewMock;
import com.ivanvinski.kunvertuh.view.mock.MainViewMock;
import com.ivanvinski.kunvertuh.view.mock.MassUnitsViewMock;
import com.ivanvinski.kunvertuh.view.mock.VolumeUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class MainPresenterTest {

  private MainViewMock view = new MainViewMock();
  private MainModel model;

  @Before
  public void setUp() {
    ViewCatalog catalog = new ViewCatalog();
    catalog.add(new LengthUnitsViewMock());
    catalog.add(new MassUnitsViewMock());
    catalog.add(new VolumeUnitsViewMock());
    catalog.add(new AboutViewMock());
    new MainPresenter(view, model = new MainModel(catalog)).initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new MainPresenter(null, model);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new MainPresenter(view, null);
  }

  @Test
  public void initializationSetsCorrectInitialView() {
    assertEquals(LengthUnitsViewMock.class, model.getActiveView().getClass());
  }

  @Test
  public void lengthActionEventSetsLengthUnitsView() {
    view.fireMassActionEvent();
    view.fireLengthActionEvent();
    assertEquals(LengthUnitsViewMock.class, view.getActiveView().getClass());
  }

  @Test
  public void massActionEventSetsMassUnitsView() {
    view.fireMassActionEvent();
    assertEquals(MassUnitsViewMock.class, view.getActiveView().getClass());
  }

  @Test
  public void volumeActionEventSetsVolumeUnitsView() {
    view.fireVolumeActionEvent();
    assertEquals(VolumeUnitsViewMock.class, view.getActiveView().getClass());
  }

  @Test
  public void aboutActionEventSetsAboutView() {
    view.fireAboutActionEvent();
    assertEquals(AboutViewMock.class, view.getActiveView().getClass());
  }
}
