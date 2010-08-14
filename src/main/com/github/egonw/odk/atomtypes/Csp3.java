// autogenerated

package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Carbon;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.orbitals.Sp3;

public class Csp3 implements IAtomType {

	private static IAtomType type;

	private Csp3() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Csp3();
		return type;
	}

	@Override
	public IElement getElement() {
		return Carbon.getInstance();
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>(4);
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		orbitals.add(Sp3.getInstance());
		return orbitals;
	}

}
