// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Boron;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.*;
import com.github.egonw.odk.model.orbitals.*;

public class B implements IAtomType {

	private static IAtomType type;

	private B() {}

	public static IAtomType getInstance() {
		if (type == null) type = new B();
		return type;
	}

	@Override
	public IElement getElement() {
		return Boron.getInstance();
	}

	@Override
	public String getName() {
		return "B";
	}

	@Override
	public short getOxidationState() {
		return 4;
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(SingleElectron.getInstance(Sp3.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp3.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp3.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp3.getInstance()));
		return orbitals;
	}

}
