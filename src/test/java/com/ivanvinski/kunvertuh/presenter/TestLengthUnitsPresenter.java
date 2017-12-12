package com.ivanvinski.kunvertuh.presenter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.NonSI.FOOT;
import static javax.measure.unit.NonSI.INCH;
import static javax.measure.unit.NonSI.MILE;
import static javax.measure.unit.NonSI.YARD;
import static javax.measure.unit.SI.CENTIMETER;
import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static javax.measure.unit.SI.MILLIMETER;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.model.LengthUnitsModelImpl;
import com.ivanvinski.kunvertuh.util.BigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.Converter;
import com.ivanvinski.kunvertuh.view.LengthUnitsViewMock;
import java.math.BigDecimal;
import org.junit.Test;

public class TestLengthUnitsPresenter {

  private static final String SOURCE_LENGTH = "500";

  private Converter<String, BigDecimal> valueConverter = new BigDecimalStringConverter();
  private String formattedSourceLength = valueConverter.format(valueConverter.parse(SOURCE_LENGTH));

  private LengthUnitsViewMock view = new LengthUnitsViewMock();
  private LengthUnitsModel model = new LengthUnitsModelImpl();
  private LengthUnitsPresenter presenter = new LengthUnitsPresenter(view, model, valueConverter);

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new LengthUnitsPresenter(null, model, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new LengthUnitsPresenter(view, null, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullValueConverterInstantiationThrowsException() {
    new LengthUnitsPresenter(view, model, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setMeters("abc12.dfg");
    view.fireMetersActionEvent();
    assertEquals("", view.getMeters());
  }

  @Test
  public void millimetersActionEventInvokesConversion() {
    view.setMillimeters(SOURCE_LENGTH);
    view.fireMillimetersActionEvent();
    assertEquals(0.5d, model.getMeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void millimetersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, MILLIMETER);
    assertEquals(formattedSourceLength, view.getMillimeters());
  }

  @Test
  public void centimetersActionEventInvokesConversion() {
    view.setCentimeters(SOURCE_LENGTH);
    view.fireCentimetersActionEvent();
    assertEquals(5d, model.getMeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void centimetersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, CENTIMETER);
    assertEquals(formattedSourceLength, view.getCentimeters());
  }

  @Test
  public void metersActionEventInvokesConversion() {
    view.setMeters(SOURCE_LENGTH);
    view.fireMetersActionEvent();
    assertEquals(50000d, model.getCentimeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void metersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, METER);
    assertEquals(formattedSourceLength, view.getMeters());
  }

  @Test
  public void kilometersActionEventInvokesConversion() {
    view.setKilometers(SOURCE_LENGTH);
    view.fireKilometersActionEvent();
    assertEquals(500000d, model.getMeters().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void kilometersConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, KILOMETER);
    assertEquals(formattedSourceLength, view.getKilometers());
  }

  @Test
  public void inchesActionEventInvokesConversion() {
    view.setInches(SOURCE_LENGTH);
    view.fireInchesActionEvent();
    assertEquals(12.7d, model.getMeters().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void inchesConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, INCH);
    assertEquals(formattedSourceLength, view.getInches());
  }

  @Test
  public void feetActionEventInvokesConversion() {
    view.setFeet(SOURCE_LENGTH);
    view.fireFeetActionEvent();
    assertEquals(152.4d, model.getMeters().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void feetConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, FOOT);
    assertEquals(formattedSourceLength, view.getFeet());
  }

  @Test
  public void yardsActionEventInvokesConversion() {
    view.setYards(SOURCE_LENGTH);
    view.fireYardsActionEvent();
    assertEquals(457.2d, model.getMeters().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void yardsConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, YARD);
    assertEquals(formattedSourceLength, view.getYards());
  }

  @Test
  public void milesActionEventInvokesConversion() {
    view.setMiles(SOURCE_LENGTH);
    view.fireMilesActionEvent();
    assertEquals(804.672d, model.getKilometers().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void milesConversionUpdatesView() {
    presenter.convert(SOURCE_LENGTH, MILE);
    assertEquals(formattedSourceLength, view.getMiles());
  }
}
