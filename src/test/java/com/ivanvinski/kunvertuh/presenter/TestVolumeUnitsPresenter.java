package com.ivanvinski.kunvertuh.presenter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.NonSI.CUBIC_INCH;
import static javax.measure.unit.NonSI.GALLON_UK;
import static javax.measure.unit.NonSI.LITER;
import static javax.measure.unit.SI.CUBIC_METRE;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.model.VolumeUnitsModelImpl;
import com.ivanvinski.kunvertuh.view.VolumeUnitsViewMock;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class TestVolumeUnitsPresenter {

  private static final String SOURCE_VOLUME = "15";
  private String formattedSourceVolume;

  private VolumeUnitsViewMock view = new VolumeUnitsViewMock();
  private VolumeUnitsModel model = new VolumeUnitsModelImpl();
  private VolumeUnitsPresenter presenter = new VolumeUnitsPresenter(view, model);

  @Before
  public void setUp() {
    formattedSourceVolume = presenter.getDecimalFormat().format(new BigDecimal(SOURCE_VOLUME));
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new VolumeUnitsPresenter(null, model);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new VolumeUnitsPresenter(view, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setLiters("abc12.dfg");
    view.fireLitersActionEvent();
    assertEquals("", view.getLiters());
  }

  @Test
  public void litersActionEventInvokesConversion() {
    view.setLiters(SOURCE_VOLUME);
    view.fireLitersActionEvent();
    assertEquals(15d, model.getLiters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void litersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, LITER);
    assertEquals(formattedSourceVolume, view.getLiters());
  }

  @Test
  public void cubicMetersActionEventInvokesConversion() {
    view.setCubicMeters(SOURCE_VOLUME);
    view.fireCubicMetersActionEvent();
    assertEquals(15000d, model.getLiters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void cubicMetersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, CUBIC_METRE);
    assertEquals(formattedSourceVolume, view.getCubicMeters());
  }

  @Test
  public void gallonsActionEventInvokesConversion() {
    view.setGallons(SOURCE_VOLUME);
    view.fireGallonsActionEvent();
    assertEquals(68.191d, model.getLiters().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void gallonsConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, GALLON_UK);
    assertEquals(formattedSourceVolume, view.getGallons());
  }

  @Test
  public void cubicInchesActionEventInvokesConversion() {
    view.setCubicInches(SOURCE_VOLUME);
    view.fireCubicInchesActionEvent();
    assertEquals(0.246d, model.getLiters().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void cubicInchesConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, CUBIC_INCH);
    assertEquals(formattedSourceVolume, view.getCubicInches());
  }
}
