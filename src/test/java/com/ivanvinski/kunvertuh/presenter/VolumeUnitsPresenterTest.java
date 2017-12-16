package com.ivanvinski.kunvertuh.presenter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.VolumeUnitsModel;
import com.ivanvinski.kunvertuh.unit.VolumeUnit;
import com.ivanvinski.kunvertuh.util.DoubleStringConverter;
import com.ivanvinski.kunvertuh.view.VolumeUnitsViewMock;
import org.junit.Before;
import org.junit.Test;

public class VolumeUnitsPresenterTest {

  private static final String SOURCE_VOLUME = "15";

  private DoubleStringConverter valueConverter = new DoubleStringConverter();
  private String formattedSourceVolume = valueConverter.format(valueConverter.parse(SOURCE_VOLUME));

  private VolumeUnitsViewMock view = new VolumeUnitsViewMock();
  private VolumeUnitsModel model = new VolumeUnitsModel();
  private VolumeUnitsPresenter presenter = new VolumeUnitsPresenter(view, model, valueConverter);

  @Before
  public void setUp() {
    presenter.initialize();
  }

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new VolumeUnitsPresenter(null, model, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new VolumeUnitsPresenter(view, null, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullValueConverterInstantiationThrowsException() {
    new VolumeUnitsPresenter(view, model, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setLiters("abc12.dfg");
    view.fireLitersActionEvent();
    assertEquals("", view.getLiters());
  }

  @Test
  public void millilitersActionEventInvokesConversion() {
    view.setMilliliters(SOURCE_VOLUME);
    view.fireMillilitersActionEvent();
    assertEquals(0.015d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void millilitersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.MILLILITERS);
    assertEquals(formattedSourceVolume, view.getMilliliters());
  }

  @Test
  public void litersActionEventInvokesConversion() {
    view.setLiters(SOURCE_VOLUME);
    view.fireLitersActionEvent();
    assertEquals(15d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void litersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.LITERS);
    assertEquals(formattedSourceVolume, view.getLiters());
  }

  @Test
  public void cubicMetersActionEventInvokesConversion() {
    view.setCubicMeters(SOURCE_VOLUME);
    view.fireCubicMetersActionEvent();
    assertEquals(15000d, model.getLiters(), METRIC_DELTA);
  }

  @Test
  public void cubicMetersConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.CUBIC_METERS);
    assertEquals(formattedSourceVolume, view.getCubicMeters());
  }

  @Test
  public void fluidOuncesActionEventInvokesConversion() {
    view.setFluidOunces(SOURCE_VOLUME);
    view.fireFluidOuncesActionEvent();
    assertEquals(0.43d, model.getLiters(), IMPERIAL_DELTA);
  }

  @Test
  public void fluidOuncesConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.FLUID_OUNCES);
    assertEquals(formattedSourceVolume, view.getFluidOunces());
  }

  @Test
  public void pintsActionEventInvokesConversion() {
    view.setPints(SOURCE_VOLUME);
    view.firePintsActionEvent();
    assertEquals(8.52d, model.getLiters(), IMPERIAL_DELTA);
  }

  @Test
  public void pintsConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.PINTS);
    assertEquals(formattedSourceVolume, view.getPints());
  }

  @Test
  public void gallonsActionEventInvokesConversion() {
    view.setGallons(SOURCE_VOLUME);
    view.fireGallonsActionEvent();
    assertEquals(68.191d, model.getLiters(), IMPERIAL_DELTA);
  }

  @Test
  public void gallonsConversionUpdatesView() {
    presenter.convert(SOURCE_VOLUME, VolumeUnit.GALLONS);
    assertEquals(formattedSourceVolume, view.getGallons());
  }
}
