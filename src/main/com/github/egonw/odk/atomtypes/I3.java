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

public class I3 implements IAtomType {

	private static IAtomType type;

	private I3() {}

	public static IAtomType getInstance() {
		if (type == null) type = new I3();
		return type;
	}

	@Override
	public IElement getElement() {
		return Iodine.getInstance();
	}

	@Override
	public String getName() {
		return "I.3";
	}

	@Override
	public short getOxidationState() {
		return 5;
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(LonePair.getInstance(Sp2.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp2.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp2.getInstance()));
		orbitals.add(SingleElectron.getInstance(Pz.getInstance()));
		return orbitals;
	}

}
