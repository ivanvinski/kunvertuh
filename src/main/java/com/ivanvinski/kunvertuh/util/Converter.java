package com.ivanvinski.kunvertuh.util;

public interface Converter<I, O> {

  I format(O value);

  O parse(I value);
}
