/*
 * Kunvertuh - simple and beautiful unit converter
 * Copyright (C) 2018  Ivan Vinski
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ivanvinski.kunvertuh;

import com.ivanvinski.kunvertuh.measurement.AngleConverterTest;
import com.ivanvinski.kunvertuh.measurement.AreaConverterTest;
import com.ivanvinski.kunvertuh.measurement.DataTransferRateConverterTest;
import com.ivanvinski.kunvertuh.measurement.DigitalStorageConverterTest;
import com.ivanvinski.kunvertuh.measurement.LengthConverterTest;
import com.ivanvinski.kunvertuh.measurement.MassConverterTest;
import com.ivanvinski.kunvertuh.measurement.PressureConverterTest;
import com.ivanvinski.kunvertuh.measurement.SpeedConverterTest;
import com.ivanvinski.kunvertuh.measurement.TemperatureConverterTest;
import com.ivanvinski.kunvertuh.measurement.TimeConverterTest;
import com.ivanvinski.kunvertuh.measurement.UnitConverterTest;
import com.ivanvinski.kunvertuh.measurement.VolumeConverterTest;
import com.ivanvinski.kunvertuh.mvp.presenter.AboutPresenterTest;
import com.ivanvinski.kunvertuh.mvp.presenter.ConverterPresenterTest;
import com.ivanvinski.kunvertuh.mvp.presenter.MainPresenterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    UnitConverterTest.class,
    LengthConverterTest.class,
    MassConverterTest.class,
    VolumeConverterTest.class,
    AreaConverterTest.class,
    TemperatureConverterTest.class,
    SpeedConverterTest.class,
    TimeConverterTest.class,
    PressureConverterTest.class,
    AngleConverterTest.class,
    DataTransferRateConverterTest.class,
    DigitalStorageConverterTest.class,
    MainPresenterTest.class,
    ConverterPresenterTest.class,
    AboutPresenterTest.class,
})
public class AllTests {

}

