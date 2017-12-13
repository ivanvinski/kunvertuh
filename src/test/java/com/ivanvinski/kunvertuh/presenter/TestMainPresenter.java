package com.ivanvinski.kunvertuh.presenter;

import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.MainModel;
import com.ivanvinski.kunvertuh.model.MainModelImpl;
import com.ivanvinski.kunvertuh.view.LengthUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.MainViewMock;
import com.ivanvinski.kunvertuh.view.MassUnitsViewImpl;
import com.ivanvinski.kunvertuh.view.VolumeUnitsViewImpl;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Parent;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestMainPresenter {

  private MainViewMock view = new MainViewMock();
  private MainModel<Parent> model;
  private MainPresenter presenter;

  private LengthUnitsViewImpl lengthView = Mockito.mock(LengthUnitsViewImpl.class);
  private MassUnitsViewImpl massView = Mockito.mock(MassUnitsViewImpl.class);
  private VolumeUnitsViewImpl volumeView = Mockito.mock(VolumeUnitsViewImpl.class);

  @Before
  public void setUp() {
    Map<Class<? extends Parent>, Parent> views = new HashMap<>();
    views.put(LengthUnitsViewImpl.class, lengthView);
    views.put(MassUnitsViewImpl.class, massView);
    views.put(VolumeUnitsViewImpl.class, volumeView);
    presenter = new MainPresenter(view, model = new MainModelImpl(views));
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
