/* $RCSfile$
 * $Author: rajarshi $
 * $Date: 2007-10-22 01:37:38 +0200 (Mon, 22 Oct 2007) $
 * $Revision: 9168 $
 *
 * Copyright (C) 2006-2007  Egon Willighagen <egonw@users.sf.net>
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
package net.launchpad.code.odk.interfaces;

/**
 * Base class for entities containing electrons, like bonds, orbitals, lone-pairs.
 *
 * @cdk.module interfaces
 * @cdk.svnrev  $Revision: 9168 $
 *
 * @cdk.keyword electron
 */
public interface IElectronContainer extends IChemObject {

	/**
	 * Returns the number of electrons in this electron container.
	 *
	 * @return The number of electrons in this electron container.
     * @see     #setElectronCount
	 */
	public int getElectronCount();

	/**
	 * Sets the number of electorn in this electron container.
	 *
	 * @param   electronCount The number of electrons in this electron container.
     * @see     #getElectronCount
	 */
	public void setElectronCount(int electronCount);

}


