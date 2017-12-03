package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.unit.LengthUnitTest;
import com.ivanvinski.kunvertuh.unit.MassUnitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    LengthUnitTest.class,
    MassUnitTest.class,
})
public class AllTests {

}
