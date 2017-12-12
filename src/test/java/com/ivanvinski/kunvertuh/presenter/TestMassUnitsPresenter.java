package com.ivanvinski.kunvertuh.presenter;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.NonSI.METRIC_TON;
import static javax.measure.unit.NonSI.OUNCE;
import static javax.measure.unit.NonSI.POUND;
import static javax.measure.unit.NonSI.TON_UK;
import static javax.measure.unit.SI.GRAM;
import static javax.measure.unit.SI.KILOGRAM;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.MassUnitsModel;
import com.ivanvinski.kunvertuh.model.MassUnitsModelImpl;
import com.ivanvinski.kunvertuh.util.BigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.Converter;
import com.ivanvinski.kunvertuh.view.MassUnitsViewMock;
import java.math.BigDecimal;
import org.junit.Test;

public class TestMassUnitsPresenter {

  private static final String SOURCE_MASS = "5";

  private Converter<String, BigDecimal> valueConverter = new BigDecimalStringConverter();
  private String formattedSourceMass = valueConverter.format(valueConverter.parse(SOURCE_MASS));

  private MassUnitsViewMock view = new MassUnitsViewMock();
  private MassUnitsModel model = new MassUnitsModelImpl();
  private MassUnitsPresenter presenter = new MassUnitsPresenter(view, model, valueConverter);

  @Test(expected = NullPointerException.class)
  public void nullViewInstantiationThrowsException() {
    new MassUnitsPresenter(null, model, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullModelInstantiationThrowsException() {
    new MassUnitsPresenter(view, null, valueConverter);
  }

  @Test(expected = NullPointerException.class)
  public void nullValueConverterInstantiationThrowsException() {
    new MassUnitsPresenter(view, model, null);
  }

  @Test
  public void nonDecimalValueConversionSetsEmptyStrings() {
    view.setGrams("abc12.dfg");
    view.fireGramsActionEvent();
    assertEquals("", view.getGrams());
  }

  @Test
  public void gramsActionEventInvokesConversion() {
    view.setGrams(SOURCE_MASS);
    view.fireGramsActionEvent();
    assertEquals(5d, model.getGrams().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void gramsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, GRAM);
    assertEquals(formattedSourceMass, view.getGrams());
  }

  @Test
  public void kilogramsActionEventInvokesConversion() {
    view.setKilograms(SOURCE_MASS);
    view.fireKilogramsActionEvent();
    assertEquals(5000d, model.getGrams().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void kilogramConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, KILOGRAM);
    assertEquals(formattedSourceMass, view.getKilograms());
  }

  @Test
  public void metricTonsActionEventInvokesConversion() {
    view.setMetricTons(SOURCE_MASS);
    view.fireMetricTonsActionEvent();
    assertEquals(5000000d, model.getGrams().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void metricTonsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, METRIC_TON);
    assertEquals(formattedSourceMass, view.getMetricTons());
  }

  @Test
  public void ouncesActionEventInvokesConversion() {
    view.setOunces(SOURCE_MASS);
    view.fireOuncesActionEvent();
    assertEquals(141.7476d, model.getGrams().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void ouncesConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, OUNCE);
    assertEquals(formattedSourceMass, view.getOunces());
  }

  @Test
  public void poundsActionEventInvokesConversion() {
    view.setPounds(SOURCE_MASS);
    view.firePoundsActionEvent();
    assertEquals(2267.962d, model.getGrams().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void poundsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, POUND);
    assertEquals(formattedSourceMass, view.getPounds());
  }

  @Test
  public void imperialTonsActionEventInvokesConversion() {
    view.setImperialTons(SOURCE_MASS);
    view.fireImperialTonsActionEvent();
    assertEquals(5080234.544d, model.getGrams().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void imperialTonsConversionUpdatesView() {
    presenter.convert(SOURCE_MASS, TON_UK);
    assertEquals(formattedSourceMass, view.getImperialTons());
  }
}
