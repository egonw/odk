// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Phosphorus;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.LonePair;
import com.github.egonw.odk.model.orbitals.*;

public class Pine implements IAtomType {

	private static IAtomType type;

	private Pine() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Pine();
		return type;
	}

	@Override
	public IElement getElement() {
		return Phosphorus.getInstance();
	}

	@Override
	public String getName() {
		return "P.ine";
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		return orbitals;
	}

}
