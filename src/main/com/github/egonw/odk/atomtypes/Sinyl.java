// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Sulfur;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.LonePair;
import com.github.egonw.odk.model.orbitals.*;

public class Sinyl implements IAtomType {

	private static IAtomType type;

	private Sinyl() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Sinyl();
		return type;
	}

	@Override
	public IElement getElement() {
		return Sulfur.getInstance();
	}

	@Override
	public String getName() {
		return "S.inyl";
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
