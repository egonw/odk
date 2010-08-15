// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Nitrogen;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.LonePair;
import com.github.egonw.odk.model.orbitals.*;

public class Nsp3 implements IAtomType {

	private static IAtomType type;

	private Nsp3() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Nsp3();
		return type;
	}

	@Override
	public IElement getElement() {
		return Nitrogen.getInstance();
	}

	@Override
	public String getName() {
		return "N.sp3";
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
