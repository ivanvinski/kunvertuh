package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.model.LengthUnitsModelTest;
import com.ivanvinski.kunvertuh.model.MainModelTest;
import com.ivanvinski.kunvertuh.model.MassUnitModelTest;
import com.ivanvinski.kunvertuh.model.VolumeUnitsModelTest;
import com.ivanvinski.kunvertuh.presenter.AboutPresenterTest;
import com.ivanvinski.kunvertuh.presenter.LengthUnitsPresenterTest;
import com.ivanvinski.kunvertuh.presenter.MainPresenterTest;
import com.ivanvinski.kunvertuh.presenter.MassUnitsPresenterTest;
import com.ivanvinski.kunvertuh.presenter.VolumeUnitsPresenterTest;
import com.ivanvinski.kunvertuh.unit.LengthUnitTest;
import com.ivanvinski.kunvertuh.unit.MassUnitTest;
import com.ivanvinski.kunvertuh.unit.VolumeUnitTest;
import com.ivanvinski.kunvertuh.util.DoubleStringConverterTest;
import com.ivanvinski.kunvertuh.view.javafx.ViewAssemblerTest;
import com.ivanvinski.kunvertuh.view.ViewCatalogTest;
import com.ivanvinski.kunvertuh.view.javafx.ViewLoaderImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    LengthUnitTest.class,
    MassUnitTest.class,
    VolumeUnitTest.class,
    LengthUnitsModelTest.class,
    LengthUnitsPresenterTest.class,
    MassUnitModelTest.class,
    MassUnitsPresenterTest.class,
    VolumeUnitsModelTest.class,
    VolumeUnitsPresenterTest.class,
    MainModelTest.class,
    MainPresenterTest.class,
    AboutPresenterTest.class,
    DoubleStringConverterTest.class,
    ViewAssemblerTest.class,
    ViewCatalogTest.class,
    ViewLoaderImplTest.class,
})
public class AllTests {

}
