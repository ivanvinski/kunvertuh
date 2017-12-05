package com.ivanvinski.kunvertuh.model;

import static com.ivanvinski.kunvertuh.TestUtils.assertEqualsCompare;

import com.ivanvinski.kunvertuh.unit.LengthUnit;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class LengthUnitsModelTest {

  private static final BigDecimal SOURCE_LENGTH = new BigDecimal(2017d);
  private static final LengthUnit SOURCE_UNIT = LengthUnit.METERS;

  private static final BigDecimal EXPECTED_MILLIMETERS = new BigDecimal(2017000d);
  private static final BigDecimal EXPECTED_CENTIMETERS = new BigDecimal(201700d);
  private static final BigDecimal EXPECTED_METERS = new BigDecimal(2017d);
  private static final BigDecimal EXPECTED_KILOMETERS = new BigDecimal(2.017d);
  private static final BigDecimal EXPECTED_INCHES = new BigDecimal(79409.451d);
  private static final BigDecimal EXPECTED_FEET = new BigDecimal(6617.454d);
  private static final BigDecimal EXPECTED_YARDS = new BigDecimal(2205.817d);
  private static final BigDecimal EXPECTED_MILES = new BigDecimal(1.253306d);

  private LengthUnitsModel model;

  @Before
  public void setUp() {
    model = new LengthUnitsModel();
    model.convert(SOURCE_LENGTH, SOURCE_UNIT);
  }

  @Test(expected = NullPointerException.class)
  public void throwsExceptionWhenSourceUnitIsNull() {
    model.convert(SOURCE_LENGTH, null);
  }

  @Test
  public void convertsToMillimeters() {
    assertEqualsCompare(EXPECTED_MILLIMETERS, model.millimetersProperty().getValue());
  }

  @Test
  public void convertsToCentimeters() {
    assertEqualsCompare(EXPECTED_CENTIMETERS, model.centimetersProperty().getValue());
  }

  @Test
  public void convertsToMeters() {
    assertEqualsCompare(EXPECTED_METERS, model.metersProperty().getValue());
  }

  @Test
  public void convertsToKilometers() {
    assertEqualsCompare(EXPECTED_KILOMETERS, model.kilometersProperty().getValue());
  }

  @Test
  public void convertsToInches() {
    assertEqualsCompare(EXPECTED_INCHES, model.inchesProperty().getValue());
  }

  @Test
  public void convertsToFeet() {
    assertEqualsCompare(EXPECTED_FEET, model.feetProperty().getValue());
  }

  @Test
  public void convertsToYards() {
    assertEqualsCompare(EXPECTED_YARDS, model.yardsProperty().getValue());
  }

  @Test
  public void convertsToMiles() {
    assertEqualsCompare(EXPECTED_MILES, model.milesProperty().getValue());
  }
}
