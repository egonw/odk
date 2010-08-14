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
 * Used to store and retrieve data of a particular isotope.
 *
 * @cdk.module interfaces
 * @cdk.svnrev  $Revision: 9168 $
 *
 * @author      egonw
 * @cdk.created 2005-08-24
 * @cdk.keyword isotope
 */
public interface IIsotope extends IElement {

	/**
	 * Sets the NaturalAbundance attribute of the Isotope object.
	 *
	 * @param  naturalAbundance  The new NaturalAbundance value
     *
     * @see    #getNaturalAbundance
	 */
	public void setNaturalAbundance(double naturalAbundance);

	/**
	 * Sets the ExactMass attribute of the Isotope object.
	 *
	 * @param  exactMass  The new ExactMass value
     *
     * @see    #getExactMass
	 */
	public void setExactMass(double exactMass);

	/**
	 * Gets the NaturalAbundance attribute of the Isotope object.
	 * Returns null when unconfigured.
	 *
	 * @return    The NaturalAbundance value
     *
     * @see       #setNaturalAbundance
	 */
	public double getNaturalAbundance();

	/**
	 * Gets the ExactMass attribute of the Isotope object.
	 * Returns null when unconfigured.
	 *
	 * @return    The ExactMass value
     *
     * @see       #setExactMass
	 */
	public double getExactMass();

    /**
     * Returns the atomic mass of this element.
	 * Returns null when unconfigured.
     *
     * @return The atomic mass of this element
     *
     * @see    #setMassNumber(int)
     */
    public int getMassNumber();
    
    /**
     * Sets the atomic mass of this element.
     *
     * @param   massNumber The atomic mass to be assigned to this element
     *
     * @see    #getMassNumber
     */
    public void setMassNumber(int massNumber);
    
}

