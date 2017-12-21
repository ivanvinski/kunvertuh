/*
 * Kunvertuh
 * Copyright (C) 2017  Ivan Vinski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

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
import com.ivanvinski.kunvertuh.unit.converter.LengthUnitConverterTest;
import com.ivanvinski.kunvertuh.unit.converter.MassUnitConverterTest;
import com.ivanvinski.kunvertuh.unit.converter.MeasurementUnitConverterTest;
import com.ivanvinski.kunvertuh.unit.converter.VolumeUnitConverterTest;
import com.ivanvinski.kunvertuh.util.DoubleStringConverterTest;
import com.ivanvinski.kunvertuh.view.ViewCatalogTest;
import com.ivanvinski.kunvertuh.view.javafx.ViewAssemblerTest;
import com.ivanvinski.kunvertuh.view.javafx.ViewLoaderImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    LengthUnitTest.class,
    MassUnitTest.class,
    VolumeUnitTest.class,
    MeasurementUnitConverterTest.class,
    LengthUnitConverterTest.class,
    MassUnitConverterTest.class,
    VolumeUnitConverterTest.class,
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
