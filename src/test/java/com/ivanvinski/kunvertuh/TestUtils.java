package com.ivanvinski.kunvertuh;

import java.math.BigDecimal;
import org.junit.Assert;

public class TestUtils {

  public static void assertEqualsCompare(BigDecimal expected, BigDecimal actual) {
    assertEqualsCompare(expected, actual, 3);
  }

  public static void assertEqualsCompare(BigDecimal expected, BigDecimal actual, int scale) {
    expected = expected.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    actual = actual.setScale(scale, BigDecimal.ROUND_HALF_EVEN);
    if (expected.compareTo(actual) != 0) {
      Assert.fail("Expected: " + expected + ", Actual: " + actual);
    }
  }
}
