// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Iodine;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.*;
import com.github.egonw.odk.model.orbitals.*;

public class I5 implements IAtomType {

	private static IAtomType type;

	private I5() {}

	public static IAtomType getInstance() {
		if (type == null) type = new I5();
		return type;
	}

	@Override
	public IElement getElement() {
		return Iodine.getInstance();
	}

	@Override
	public String getName() {
		return "I.5";
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(SingleElectron.getInstance(Sp2.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp2.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp2.getInstance()));
		orbitals.add(SingleElectron.getInstance(Pz.getInstance()));
		return orbitals;
	}

}
