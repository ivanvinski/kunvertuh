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

import com.ivanvinski.kunvertuh.measurement.AreaConverterTest;
import com.ivanvinski.kunvertuh.measurement.LengthConverterTest;
import com.ivanvinski.kunvertuh.measurement.MassConverterTest;
import com.ivanvinski.kunvertuh.measurement.UnitConverterTest;
import com.ivanvinski.kunvertuh.measurement.VolumeConverterTest;
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
})
public class AllTests {

}
