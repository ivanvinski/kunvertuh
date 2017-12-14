package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestConstants.IMPERIAL_DELTA;
import static com.ivanvinski.kunvertuh.TestConstants.METRIC_DELTA;
import static javax.measure.unit.SI.GRAM;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class TestMassUnitModelImpl {

  private static final BigDecimal SOURCE_LENGTH = new BigDecimal(1998d);

  private MassUnitsModel model = new MassUnitsModelImpl();

  @Before
  public void setUp() {
    model.convert(SOURCE_LENGTH, GRAM);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(new BigDecimal(0d), null);
  }

  @Test
  public void convertsNullSourceMassToNullValues() {
    model.convert(null, GRAM);
    assertEquals(null, model.getKilograms());
  }

  @Test
  public void convertsNonNullMassToGrams() {
    assertEquals(1998d, model.getGrams().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToKilograms() {
    assertEquals(1.998d, model.getKilograms().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToMetricTons() {
    assertEquals(0.001998d, model.getMetricTons().doubleValue(), METRIC_DELTA);
  }

  @Test
  public void convertsNonNullMassToOunces() {
    assertEquals(70.477d, model.getOunces().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullMassToPounds() {
    assertEquals(4.405d, model.getPounds().doubleValue(), IMPERIAL_DELTA);
  }

  @Test
  public void convertsNonNullMassToImperialTons() {
    assertEquals(0.00197d, model.getImperialTons().doubleValue(), IMPERIAL_DELTA);
  }
}
