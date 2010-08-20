/* Copyright (C) 2010  Egon Willighagen <egonw@users.sf.net>
 *
 * Contact: cdk-devel@lists.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.github.egonw.odk.modulesuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.egonw.odk.atomtypes.AtomTypeTests;
import com.github.egonw.odk.compounds.ExampleCompoundTests;
import com.github.egonw.odk.matrix.MolecularMatrixTest;
import com.github.egonw.odk.model.LonePairTest;
import com.github.egonw.odk.model.MoleculeTest;

@RunWith(value=Suite.class)
@SuiteClasses(value={
	MoleculeTest.class,
	ExampleCompoundTests.class,
	AtomTypeTests.class,
	LonePairTest.class,
	MolecularMatrixTest.class
})
public class MinterfacesTests {}
