package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.SI.KILOMETER;
import static javax.measure.unit.SI.METER;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;

public class TestAbstractUnitsModel {

  private AbstractUnitsModel model = new AbstractUnitsModelStub();

  @Test(expected = NullPointerException.class)
  public void safeConversionWithNullSourceUnitThrowsException() {
    model.convertSafely(new BigDecimal(0d), null, METER);
  }

  @Test(expected = NullPointerException.class)
  public void safeConversionWithNullOutputUnitThrowsException() {
    model.convertSafely(new BigDecimal(0d), METER, null);
  }

  @Test
  public void safeConversionWithNullSourceValueReturnsNull() {
    assertEquals(null, model.convertSafely(null, KILOMETER, METER));
  }

  @Test
  public void safeConversionWithNonNullSourceValuePerformsConversion() {
    double output = model.convertSafely(new BigDecimal(2d), KILOMETER, METER).doubleValue();
    assertEquals(2000d, output, METRIC_DELTA);
  }
}
