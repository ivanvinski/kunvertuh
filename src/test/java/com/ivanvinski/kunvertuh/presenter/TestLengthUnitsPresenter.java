package com.ivanvinski.kunvertuh.presenter;

import static javax.measure.unit.SI.METER;
import static org.junit.Assert.assertEquals;

import com.ivanvinski.kunvertuh.model.LengthUnitsModel;
import com.ivanvinski.kunvertuh.model.LengthUnitsModelImpl;
import com.ivanvinski.kunvertuh.view.LengthUnitsView;
import com.ivanvinski.kunvertuh.view.LengthUnitsViewMock;
import java.math.BigDecimal;
import org.junit.Test;

public class TestLengthUnitsPresenter {

  private static final String SOURCE_LENGTH = "500";

  private LengthUnitsView view = new LengthUnitsViewMock();
  private LengthUnitsModel model = new LengthUnitsModelImpl();
  private LengthUnitsPresenter presenter = new LengthUnitsPresenter(view, model);

  @Test(expected = NullPointerException.class)
  public void instantiationWithNullViewShouldThrowNullPointerException() {
    new LengthUnitsPresenter(null, model);
  }

  @Test(expected = NullPointerException.class)
  public void instantiationWithNullModelShouldThrowNullPointerException() {
    new LengthUnitsPresenter(view, null);
  }

  @Test(expected = NullPointerException.class)
  public void conversionWithNullSourceUnitShouldThrowNullPointerException() {
    model.convert(new BigDecimal(0d), null);
  }

  @Test
  public void conversionWithNullSourceLengthShouldSetEmptyStrings() {
    model.convert(null, METER);
    assertEquals("", view.getMeters());
  }

  @Test
  public void millimetersActionEventShouldInvokeConversion() {
    view.setMillimeters(SOURCE_LENGTH);
    assertEquals(0.5d, model.getMeters().doubleValue(), 0d);
  }

  @Test
  public void centimetersActionEventShouldInvokeConversion() {
    view.setCentimeters(SOURCE_LENGTH);
    assertEquals(5d, model.getMeters().doubleValue(), 0d);
  }

  @Test
  public void metersActionEventShouldInvokeConversion() {
    view.setMeters(SOURCE_LENGTH);
    assertEquals(50000d, model.getCentimeters().doubleValue(), 0d);
  }

  @Test
  public void kilometersActionEventShouldInvokeConversion() {
    view.setKilometers(SOURCE_LENGTH);
    assertEquals(500000d, model.getMeters().doubleValue(), 0d);
  }

  @Test
  public void inchesActionEventShouldInvokeConversion() {
    view.setInches(SOURCE_LENGTH);
    assertEquals(12.7d, model.getMeters().doubleValue(), 0d);
  }

  @Test
  public void feetActionEventShouldInvokeConversion() {
    view.setFeet(SOURCE_LENGTH);
    assertEquals(152.4d, model.getMeters().doubleValue(), 0d);
  }

  @Test
  public void yardsActionEventShouldInvokeConversion() {
    view.setYards(SOURCE_LENGTH);
    assertEquals(457.2d, model.getMeters().doubleValue(), 0d);
  }

  @Test
  public void milesActionEventShouldInvokeConversion() {
    view.setMiles(SOURCE_LENGTH);
    assertEquals(804.672d, model.getKilometers().doubleValue(), 0d);
  }
}
