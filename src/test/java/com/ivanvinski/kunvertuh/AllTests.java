package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.model.TestLengthUnitsModelImpl;
import com.ivanvinski.kunvertuh.model.TestMassUnitModelImpl;
import com.ivanvinski.kunvertuh.presenter.TestLengthUnitsPresenter;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestLengthUnitsModelImpl.class,
    TestLengthUnitsPresenter.class,
    TestMassUnitModelImpl.class,
})
public class AllTests {

}
