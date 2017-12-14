package com.ivanvinski.kunvertuh.presenter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.view.LengthUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.MainViewMock;
import com.ivanvinski.kunvertuh.view.MassUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.ViewCatalog;
import com.ivanvinski.kunvertuh.view.VolumeUnitsViewImpl;
import org.junit.Before;
import org.junit.Test;

public class TestMainPresenter {

  private MainViewMock view = new MainViewMock();
  private MainModel model;
  private MainPresenter presenter;

  private LengthUnitsViewImpl lengthView = new LengthUnitsViewImpl();
  private MassUnitsViewImpl massView = new MassUnitsViewImpl();
  private VolumeUnitsViewImpl volumeView = new VolumeUnitsViewImpl();

  @Before
  public void setUp() {
    ViewCatalog catalog = new ViewCatalog();
    catalog.add(lengthView);
    catalog.add(massView);
    catalog.add(volumeView);
    presenter = new MainPresenter(view, model = new MainModel(catalog));
    presenter.initialize();
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
    assertEquals(lengthView, view.getActiveView());
  }

  @Test
  public void lengthActionEventSetsLengthUnitsView() {
    view.fireMassActionEvent();
    view.fireLengthActionEvent();
    assertEquals(lengthView, view.getActiveView());
  }

  @Test
  public void massActionEventSetsMassUnitsView() {
    view.fireMassActionEvent();
    assertEquals(massView, view.getActiveView());
  }

  @Test
  public void volumeActionEventSetsVolumeUnitsView() {
    view.fireVolumeActionEvent();
    assertEquals(volumeView, view.getActiveView());
  }
}
