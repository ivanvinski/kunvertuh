package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.model.TestLengthUnitsModelImpl;
import com.ivanvinski.kunvertuh.model.TestMainModelImpl;
import com.ivanvinski.kunvertuh.model.TestMassUnitModelImpl;
import com.ivanvinski.kunvertuh.model.TestVolumeUnitsModelImpl;
import com.ivanvinski.kunvertuh.presenter.TestLengthUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestMainPresenter;
import com.ivanvinski.kunvertuh.presenter.TestMassUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestVolumeUnitsPresenter;
import com.ivanvinski.kunvertuh.unit.TestLengthUnit;
import com.ivanvinski.kunvertuh.util.TestBigDecimalStringConverter;
import com.ivanvinski.kunvertuh.util.TestSimpleUnitConverter;
import com.ivanvinski.kunvertuh.view.TestViewAssembler;
import com.ivanvinski.kunvertuh.view.TestViewLoader;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    TestLengthUnit.class,
    TestLengthUnitsModelImpl.class,
    TestLengthUnitsPresenter.class,
    TestMassUnitModelImpl.class,
    TestMassUnitsPresenter.class,
    TestVolumeUnitsModelImpl.class,
    TestVolumeUnitsPresenter.class,
    TestMainModelImpl.class,
    TestMainPresenter.class,
    TestBigDecimalStringConverter.class,
    TestSimpleUnitConverter.class,
    TestViewAssembler.class,
    TestViewLoader.class,
})
public class AllTests {

}
