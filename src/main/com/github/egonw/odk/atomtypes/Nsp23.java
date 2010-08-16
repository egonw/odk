// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Nitrogen;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.*;
import com.github.egonw.odk.model.orbitals.*;

public class Nsp23 implements IAtomType {

	private static IAtomType type;

	private Nsp23() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Nsp23();
		return type;
	}

	@Override
	public IElement getElement() {
		return Nitrogen.getInstance();
	}

	@Override
	public String getName() {
		return "N.sp2.3";
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