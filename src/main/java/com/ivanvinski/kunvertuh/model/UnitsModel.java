package com.ivanvinski.kunvertuh.model;

import java.math.BigDecimal;

public interface UnitsModel<U> {

  void convert(BigDecimal sourceValue, U sourceUnit);
}
