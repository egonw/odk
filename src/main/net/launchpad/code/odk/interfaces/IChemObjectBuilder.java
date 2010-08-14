/* $Revision: 9967 $ $Author: egonw $ $Date: 2008-01-29 18:44:59 +0100 (Tue, 29 Jan 2008) $
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

import net.launchpad.code.odk.interfaces.IBond.Order;

/**
 * A helper class to instantiate a IChemObject for a specific implementation.
 *
 * @author        egonw
 * @cdk.module    interfaces
 * @cdk.svnrev  $Revision: 9967 $
 */
public interface IChemObjectBuilder {

    /**
     * Constructs an completely unset IAtom.
     * 
     * @return IAtom implementation defined for this IChemObjectBuilder
     */
	public IAtom newAtom();
	
    /**
     * Constructs an IAtom from a String containing an element symbol.
     *
     * @param   element  The IElement from which the Atom should be constructed
     * @return           IAtom implementation defined for this IChemObjectBuilder
     */
    public IAtom newAtom(IElement element);
    
    /**
     * Constructs an IAtom from a String containing an element symbol.
     *
     * @param   elementSymbol  The String describing the element for the Atom
     * @return                 IAtom implementation defined for this IChemObjectBuilder
     */
    public IAtom newAtom(String elementSymbol);
    
    /**
     * Constructs an IAtom from an Element and a Point2d.
     *
     * @param   elementSymbol   The Element
     * @param   point2d         The Point
     * @return                  IAtom implementation defined for this IChemObjectBuilder
     */
    public IAtom newAtom(String elementSymbol, javax.vecmath.Point2d point2d);

    /**
     * Constructs an IAtom from an Element and a Point3d.
     *
     * @param   elementSymbol   The symbol of the atom
     * @param   point3d         The 3D coordinates of the atom
     * @return                  IAtom implementation defined for this IChemObjectBuilder
     */
    public IAtom newAtom(String elementSymbol, javax.vecmath.Point3d point3d);

	/**
	 * Constructs an empty IAtomContainer.
	 * 
     * @return IAtomContainer implementation defined for this IChemObjectBuilder
	 */
	public IAtomContainer newAtomContainer();
    
	/**
	 * Constructs an empty IAtomContainer that will contain a certain number of
	 * atoms and electronContainers. It will set the starting array lengths to the
	 * defined values, but will not create any IAtom or IElectronContainer's.
	 *
	 * @param  atomCount               Number of atoms to be in this container
	 * @param  bondCount               Number of bonds to be in this container
	 * @param  lonePairCount           Number of lone pairs to be in this container
	 * @param  singleElectronCount     Number of single electrons to be in this
	 *                                 container
	 *                                                               
     * @return                         IAtomContainer implementation defined for
     *                                 this IChemObjectBuilder
	 */
	public IAtomContainer newAtomContainer(int atomCount, int bondCount, int lonePairCount, int singleElectronCount);
    
	/**
	 * Constructs an IAtomContainer with a copy of the atoms and electronContainers
	 * of another IAtomContainer (A shallow copy, i.e., with the same objects as in
	 * the original IAtomContainer).
	 *
	 * @param  container  An AtomContainer to copy the atoms and electronContainers from
     * @return            IAtomContainer implementation defined for this IChemObjectBuilder
	 */
	public IAtomContainer newAtomContainer(IAtomContainer container);

    /**
	 * Constructor for the IAtomType object.
     *
     * @param elementSymbol  Symbol of the atom
     * @return               IAtomType implementation defined for this IChemObjectBuilder
	 */
	public IAtomType newAtomType(String elementSymbol);

	/**
	 * Constructor for the IAtomType object.
	 *
	 * @param  identifier     An id for this atom type, like C3 for sp3 carbon
	 * @param  elementSymbol  The element symbol identifying the element to which this atom type applies
     * @return                IAtomType implementation defined for this IChemObjectBuilder
	 */
	public IAtomType newAtomType(String identifier, String elementSymbol);
	
    /**
     * Constructs an IAtomType from a String containing an element symbol.
     *
     * @param   element  The IElement from which the AtomType should be constructed
     * @return           IAtomType implementation defined for this IChemObjectBuilder
     */
    public IAtomType newAtomType(IElement element);
    /**
	 * Constructs an empty IBond.
	 * 
     * @return IBond implementation defined for this IChemObjectBuilder
	 */
	public IBond newBond();
	
	/**
	 * Constructs a IBond with a single bond order..
	 *
	 * @param  atom1  the first IAtom in the bond
	 * @param  atom2  the second IAtom in the bond
     * @return IBond  implementation defined for this IChemObjectBuilder
	 */
	public IBond newBond(IAtom atom1, IAtom atom2);
	
	/**
	 * Constructs a IBond with a given order.
	 *
	 * @param  atom1  the first IAtom in the bond
	 * @param  atom2  the second IAtom in the bond
	 * @param  order  the bond order
     * @return IBond  implementation defined for this IChemObjectBuilder
	 */
	public IBond newBond(IAtom atom1, IAtom atom2, Order order);
	
	/**
	 * Constructs a IBond with a given order and stereo orientation from an array
	 * of atoms.
	 *
	 * @param  atom1   the first Atom in the bond
	 * @param  atom2   the second Atom in the bond
	 * @param  order   the bond order
	 * @param  stereo  a descriptor the stereochemical orientation of this bond
     * @return IBond   implementation defined for this IChemObjectBuilder
	 */
	public IBond newBond(IAtom atom1, IAtom atom2, Order order, int stereo);

    /**
     * Constructs an empty IElectronContainer.
     * 
     * @return IElectronContainer implementation defined for this IChemObjectBuilder
     */
    public IElectronContainer newElectronContainer();

    /**
     * Constructs an empty IElement.
     * 
     * @return IElement implementation defined for this IChemObjectBuilder
     */
    public IElement newElement();

    /**
     * Constructs an empty IElement from an existing IElement.
     * 
     * @param   element  The IElement from which the Element should be constructed
     * @return IElement implementation defined for this IChemObjectBuilder
     */
    public IElement newElement(IElement element);

    /**
     * Constructs an IElement with a given element symbol.
     *
     * @param  symbol The element symbol that this element should have.
     * @return        IElement implementation defined for this IChemObjectBuilder
     */
    public IElement newElement(String symbol);

    /**
     * Constructs an IElement with a given element symbol, 
     * atomic number and atomic mass.
     *
     * @param   symbol       The element symbol of this element.
     * @param   atomicNumber The atomicNumber of this element.
     * @return               IElement implementation defined for this IChemObjectBuilder
     */
    public IElement newElement(String symbol, int atomicNumber);

	/**
	 * Constructor for the IIsotope object.
	 *
	 * @param  elementSymbol  The element symbol, "O" for oxygen, etc.
     * @return                IIsotope implementation defined for this IChemObjectBuilder
	 */
	public IIsotope newIsotope(String elementSymbol);
	
	/**
	 * Constructs an IIsotope object from an existing IIsotope.
	 *
     * @param   element  The IElement from which the Isotope should be constructed
     * @return          IIsotope implementation defined for this IChemObjectBuilder
	 */
	public IIsotope newIsotope(IElement element);
	
	/**
	 * Constructor for the IIsotope object.
	 *
	 * @param  atomicNumber   The atomic number of the isotope
	 * @param  elementSymbol  The element symbol, "O" for oxygen, etc.
	 * @param  massNumber     The atomic mass of the isotope, 16 for oxygen, e.g.
	 * @param  exactMass      The exact mass of the isotope, be a little more explicit here :-)
	 * @param  abundance      The natural abundance of the isotope
     * @return                IIsotope implementation defined for this IChemObjectBuilder
	 */
	public IIsotope newIsotope(int atomicNumber, String elementSymbol, 
			int massNumber, double exactMass, double abundance);

	/**
	 * Constructor for the IIsotope object.
	 *
	 * @param  atomicNumber   The atomic number of the isotope, 8 for oxygen
	 * @param  elementSymbol  The element symbol, "O" for oxygen, etc.
	 * @param  exactMass      The exact mass of the isotope, be a little more explicit here :-)
	 * @param  abundance      The natural abundance of the isotope
     * @return                IIsotope implementation defined for this IChemObjectBuilder
	 */
	public IIsotope newIsotope(int atomicNumber, String elementSymbol, 
			double exactMass, double abundance);

	/**
	 * Constructor for the IIsotope object.
	 *
	 * @param  elementSymbol  The element symbol, "O" for oxygen, etc.
	 * @param  massNumber     The atomic mass of the isotope, 16 for oxygen, e.g.
     * @return                IIsotope implementation defined for this IChemObjectBuilder
	 */
	public IIsotope newIsotope(String elementSymbol, int massNumber);
	
    /**
     * Constructs an unconnected ILonePair.
     * 
     * @return  ILonePair implementation defined for this IChemObjectBuilder
     */
    public ILonePair newLonePair();

    /**
     * Constructs an ILonePair on an IAtom.
     *
     * @param atom  IAtom to which this lone pair is connected
     * @return      ILonePair implementation defined for this IChemObjectBuilder
     */
    public ILonePair newLonePair(IAtom atom);
	
    /**
     * Constructs an single electron orbital with an associated IAtom.
     * 
     * @return ISingleElectron implementation defined for this IChemObjectBuilder
     */
    public ISingleElectron newSingleElectron();
    
    /**
     * Constructs an single electron orbital on an IAtom.
     *
     * @param atom The atom to which the single electron belongs.
     * @return     ISingleElectron implementation defined for this IChemObjectBuilder
     */
    public ISingleElectron newSingleElectron(IAtom atom);   

}


