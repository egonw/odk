// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Arsenic;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.LonePair;
import com.github.egonw.odk.model.orbitals.*;

public class As implements IAtomType {

	private static IAtomType type;

	private As() {}

	public static IAtomType getInstance() {
		if (type == null) type = new As();
		return type;
	}

	@Override
	public IElement getElement() {
		return Arsenic.getInstance();
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