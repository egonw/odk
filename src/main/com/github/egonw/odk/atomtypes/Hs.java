// autogenerated

package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Hydrogen;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.SingleElectron;
import com.github.egonw.odk.model.orbitals.S;

public class Hs implements IAtomType {

	private static IAtomType type;

	private Hs() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Hs();
		return type;
	}

	@Override
	public String getName() {
		return "H";
	}

	@Override
	public IElement getElement() {
		return Hydrogen.getInstance();
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>(1);
		orbitals.add(SingleElectron.getInstance(S.getInstance()));
		return orbitals;
	}

}
