package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.model.TestLengthUnitsModelImpl;
import com.ivanvinski.kunvertuh.model.TestMassUnitModelImpl;
import com.ivanvinski.kunvertuh.model.TestVolumeUnitsModelImpl;
import com.ivanvinski.kunvertuh.presenter.TestLengthUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestMassUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestVolumeUnitsPresenter;
import com.ivanvinski.kunvertuh.util.TestBigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.TestSimpleUnitConverter;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestLengthUnitsModelImpl.class,
    TestLengthUnitsPresenter.class,
    TestMassUnitModelImpl.class,
    TestMassUnitsPresenter.class,
    TestVolumeUnitsModelImpl.class,
    TestVolumeUnitsPresenter.class,
    TestBigDecimalStringConverter.class,
    TestSimpleUnitConverter.class,
})
public class AllTests {

}
