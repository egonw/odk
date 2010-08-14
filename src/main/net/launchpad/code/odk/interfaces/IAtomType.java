/* $Revision: 9685 $ $Author: egonw $ $Date: 2007-12-28 22:50:41 +0100 (Fri, 28 Dec 2007) $
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
 * The base class for atom types. Atom types are typically used to describe the
 * behaviour of an atom of a particular element in different environment like 
 * sp<sup>3</sup> hybridized carbon C3, etc., in some molecular modelling 
 * applications.
 *
 * @cdk.module  interfaces
 * @cdk.svnrev  $Revision: 9685 $
 *
 * @author      egonw
 * @cdk.created 2005-08-24
 *
 * @cdk.keyword atom, type
 */
public interface IAtomType extends IIsotope {

	public enum Hybridization {
	    SP1,
	    SP2,
	    SP3,
	    PLANAR3,
	    SP3D1,
	    SP3D2,
	    SP3D3,
	    SP3D4,
	    SP3D5
	}
	
	/**
	 * Sets the if attribute of the AtomType object.
	 *
	 * @param  identifier  The new AtomTypeID value. Null if unset.
     * @see    #getAtomTypeName
	 */
	public void setAtomTypeName(String identifier);

	/**
	 * Sets the MaxBondOrder attribute of the AtomType object.
	 *
	 * @param  maxBondOrder  The new MaxBondOrder value
     * @see    #getMaxBondOrder
	 */
	public void setMaxBondOrder(IBond.Order maxBondOrder);

	/**
	 * Sets the the exact bond order sum attribute of the AtomType object.
	 *
	 * @param  bondOrderSum  The new bondOrderSum value
     * @see    #getBondOrderSum
	 */
	public void setBondOrderSum(Double bondOrderSum);

	/**
	 * Gets the id attribute of the AtomType object.
	 *
	 * @return    The id value
     * @see       #setAtomTypeName
	 */
	public String getAtomTypeName();

	/**
	 * Gets the MaxBondOrder attribute of the AtomType object.
	 *
	 * @return    The MaxBondOrder value
     * @see       #setMaxBondOrder
	 */
	public IBond.Order getMaxBondOrder();

	/**
	 * Gets the bondOrderSum attribute of the AtomType object.
	 *
	 * @return    The bondOrderSum value
     * @see       #setBondOrderSum
	 */
	public Double getBondOrderSum();
	
    /**
     * Sets the formal charge of this atom.
     *
     * @param  charge  The formal charge
     * @see    #getFormalCharge
     */
    public void setFormalCharge(Integer charge);
    
    /**
     * Returns the formal charge of this atom.
     *
     * @return the formal charge of this atom
     * @see    #setFormalCharge
     */
    public Integer getFormalCharge();
    
    /**
     * Sets the formal neighbour count of this atom.
     *
     * @param  count  The neighbour count
     * @see    #getFormalNeighbourCount
     */
    public void setFormalNeighbourCount(Integer count);
    
    /**
     * Returns the formal neighbour count of this atom.
     *
     * @return the formal neighbour count of this atom
     * @see    #setFormalNeighbourCount
     */
    public Integer getFormalNeighbourCount();
    
    /**
     * Sets the hybridization of this atom.
     *
     * @param  hybridization  The hybridization
     * @see    #getHybridization
     */
    public void setHybridization(Hybridization hybridization);
    
    /**
     * Returns the hybridization of this atom.
     *
     * @return the hybridization of this atom
     * @see    #setHybridization
     */
    public Hybridization getHybridization();
    
    /**
     * Sets the Vanderwaals radius for this AtomType.
     *
     * @param radius The Vanderwaals radius for this AtomType
     * @see   #getVanderwaalsRadius
     */
    public void setVanderwaalsRadius(Double radius);
    
    /**
     * Returns the Vanderwaals radius for this AtomType.
     * 
     * <p>Vanderwaals radii can be set by using the Jmol atom type list:
     * <pre>
     * AtomTypeFactory factory = AtomTypeFactory.getInstance("org/openscience/cdk/config/data/jmol_atomtypes.txt",
     * new ChemObject().getBuilder());
     * IAtomType atomType = factory.getAtomType("H");
     * double radius = atomType.getVanderwaalsRadius();
     * </pre>        
     *
     * @return      The Vanderwaals radius for this AtomType
     * @see         #setVanderwaalsRadius
     * @cdk.keyword radius, vanderwaals
     */
    public Double getVanderwaalsRadius();
    
    /**
     * Sets the covalent radius for this AtomType.
     *
     * @param radius The covalent radius for this AtomType
     * @see    #getCovalentRadius
     */
    public void setCovalentRadius(Double radius);
    
    /**
     * Returns the covalent radius for this AtomType.
     *
     * @return The covalent radius for this AtomType
     * @see    #setCovalentRadius
     */
    public Double getCovalentRadius();
    
	/**
	 * Sets the the exact electron valency of the AtomType object.
	 *
	 * @param  valency  The new valency value
	 * @see    #getValency()
	 */
	public void setValency(Integer valency);

	/**
	 * Gets the the exact electron valency of the AtomType object.
	 *
	 * @return The valency value
	 * @see    #setValency(Integer)
	 */
	public Integer getValency();

}

