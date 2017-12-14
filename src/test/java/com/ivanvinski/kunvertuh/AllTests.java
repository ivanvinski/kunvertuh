package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.model.TestLengthUnitsModel;
import com.ivanvinski.kunvertuh.model.TestMainModel;
import com.ivanvinski.kunvertuh.model.TestMassUnitModel;
import com.ivanvinski.kunvertuh.model.TestVolumeUnitsModel;
import com.ivanvinski.kunvertuh.presenter.TestLengthUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestMainPresenter;
import com.ivanvinski.kunvertuh.presenter.TestMassUnitsPresenter;
import com.ivanvinski.kunvertuh.presenter.TestVolumeUnitsPresenter;
import com.ivanvinski.kunvertuh.unit.TestLengthUnit;
import com.ivanvinski.kunvertuh.unit.TestMassUnit;
import com.ivanvinski.kunvertuh.unit.TestVolumeUnit;
import com.ivanvinski.kunvertuh.util.TestDoubleStringConverter;
import com.ivanvinski.kunvertuh.util.TestSimpleUnitConverter;
import com.ivanvinski.kunvertuh.view.TestViewAssembler;
import com.ivanvinski.kunvertuh.view.TestViewCatalog;
import com.ivanvinski.kunvertuh.view.TestViewLoader;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    TestLengthUnit.class,
    TestMassUnit.class,
    TestVolumeUnit.class,
    TestLengthUnitsModel.class,
    TestLengthUnitsPresenter.class,
    TestMassUnitModel.class,
    TestMassUnitsPresenter.class,
    TestVolumeUnitsModel.class,
    TestVolumeUnitsPresenter.class,
    TestMainModel.class,
    TestMainPresenter.class,
    TestDoubleStringConverter.class,
    TestSimpleUnitConverter.class,
    TestViewAssembler.class,
    TestViewCatalog.class,
    TestViewLoader.class,
})
public class AllTests {

}
