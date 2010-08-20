// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Chlorine;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.*;
import com.github.egonw.odk.model.orbitals.*;

public class Clminus implements IAtomType {

	private static IAtomType type;

	private Clminus() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Clminus();
		return type;
	}

	@Override
	public IElement getElement() {
		return Chlorine.getInstance();
	}

	@Override
	public String getName() {
		return "Cl.minus";
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		return orbitals;
	}

	@Override
	public short getOxidationState() {
		return 3;
	}

}
