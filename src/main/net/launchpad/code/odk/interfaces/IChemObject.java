/* $RCSfile$
 * $Author: egonw $
 * $Date: 2008-01-18 20:32:13 +0100 (Fri, 18 Jan 2008) $
 * $Revision: 9928 $
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

import java.util.Map;

/**
 * The base class for all chemical objects in this cdk. It provides methods for
 * adding listeners and for their notification of events, as well a a hash
 * table for administration of physical or chemical properties
 *
 *@author        egonw
 * @cdk.svnrev  $Revision: 9928 $
 *@cdk.module    interfaces
 */
public interface IChemObject extends Cloneable {

	/**
	 * Sets a property for a IChemObject.
	 *
	 * @param  description  An object description of the property (most likely a
	 *                      unique string)
	 * @param  property     An object with the property itself
	 * @see                 #getProperty
	 * @see                 #removeProperty
	 */
	public void setProperty(Object description, Object property);
	
	/**
	 * Removes a property for a IChemObject.
	 *
	 * @param  description  The object description of the property (most likely a
	 *                      unique string)
	 * @see                 #setProperty
	 * @see                 #getProperty
	 */
	public void removeProperty(Object description);

	/**
	 * Returns a property for the IChemObject.
	 *
	 * @param  description  An object description of the property (most likely a
	 *                      unique string)
	 * @return              The object containing the property. Returns null if
	 *                      propert is not set.
	 * @see                 #setProperty
	 * @see                 #removeProperty
	 */
	public Object getProperty(Object description);

	/**
	 *  Returns a Map with the IChemObject's properties.
	 *
	 *@return    The object's properties as an Map
	 *@see       #setProperties
	 */
	public Map<Object,Object> getProperties();

	/**
	 * Returns the identifier (ID) of this object.
	 *
	 * @return    a String representing the ID value
	 * @see       #setID
	 */
	public String getID();

	/**
	 * Sets the identifier (ID) of this object.
	 *
	 * @param  identifier  a String representing the ID value
	 * @see                #getID
	 */
	public void setID(String identifier);

	/**
	 * Sets the value of some flag.
	 *
	 * @param  flag_type   Flag to set
	 * @param  flag_value  Value to assign to flag
	 * @see                #getFlag
	 */
	public void setFlag(int flag_type, boolean flag_value);


	/**
	 * Returns the value of some flag.
	 *
	 * @param  flag_type  Flag to retrieve the value of
	 * @return            true if the flag <code>flag_type</code> is set
	 * @see               #setFlag
	 */
	public boolean getFlag(int flag_type);

	/**
	 * Sets the properties of this object.
	 *
	 * @param  properties  a Map specifying the property values
	 * @see                #getProperties
	 */
	public void setProperties(Map<Object,Object> properties);
    
	/**
	 * Sets the whole set of flags.
	 *
	 * @param  flagsNew    the new flags.
	 * @see                #getFlags
	 */
    public void setFlags(boolean[] flagsNew);

	/**
	 * Returns the whole set of flags.
	 *
	 * @return    the flags.
	 * @see       #setFlags
	 */
    public boolean[] getFlags();

    /**
     * Returns a one line description of this IChemObject.
     *
     * @return a String representation of this object
     */
    public String toString();
    
    /**
     * Returns a deep clone of this IChemObject.
     *
     * @return Object the clone of this IChemObject.
     * @throws CloneNotSupportedException if the IChemObject cannot be cloned
     */
    public Object clone() throws CloneNotSupportedException;
    
    /**
     * Returns a ChemObjectBuilder for the data classes that extend
     * this class.
     * 
     * @return The IChemObjectBuilder matching this IChemObject
     */
    public IChemObjectBuilder getBuilder();
}


