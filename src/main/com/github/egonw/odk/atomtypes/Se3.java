// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Selenium;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.*;
import com.github.egonw.odk.model.orbitals.*;

public class Se3 implements IAtomType {

	private static IAtomType type;

	private Se3() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Se3();
		return type;
	}

	@Override
	public IElement getElement() {
		return Selenium.getInstance();
	}

	@Override
	public String getName() {
		return "Se.3";
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		orbitals.add(LonePair.getInstance(Sp3.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp3.getInstance()));
		orbitals.add(SingleElectron.getInstance(Sp3.getInstance()));
		return orbitals;
	}

}
