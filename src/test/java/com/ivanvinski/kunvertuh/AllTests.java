package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.model.TestAbstractUnitsModel;
import com.ivanvinski.kunvertuh.model.TestLengthUnitsModelImpl;
import com.ivanvinski.kunvertuh.model.TestMassUnitModelImpl;
import com.ivanvinski.kunvertuh.model.TestVolumeUnitsModelImpl;
import com.ivanvinski.kunvertuh.presenter.TestLengthUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestMassUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestVolumeUnitsPresenter;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestAbstractUnitsModel.class,
    TestLengthUnitsModelImpl.class,
    TestLengthUnitsPresenter.class,
    TestMassUnitModelImpl.class,
    TestMassUnitsPresenter.class,
    TestVolumeUnitsModelImpl.class,
    TestVolumeUnitsPresenter.class,
})
public class AllTests {

}
