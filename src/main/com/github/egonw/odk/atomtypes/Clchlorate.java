// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Chlorine;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.LonePair;
import com.github.egonw.odk.model.orbitals.*;

public class Clchlorate implements IAtomType {

	private static IAtomType type;

	private Clchlorate() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Clchlorate();
		return type;
	}

	@Override
	public IElement getElement() {
		return Chlorine.getInstance();
	}

	@Override
	public String getName() {
		return "Cl.chlorate";
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		orbitals.add(Pz.getInstance());
		return orbitals;
	}

}
