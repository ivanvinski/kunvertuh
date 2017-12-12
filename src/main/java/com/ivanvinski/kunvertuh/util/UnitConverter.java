package com.ivanvinski.kunvertuh.util;

import java.math.BigDecimal;

public interface UnitConverter<U> {

  BigDecimal convert(BigDecimal sourceValue, U sourceUnit, U outputUnit);
}
