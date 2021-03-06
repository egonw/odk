// autogenerated
package com.github.egonw.odk.atomtypes;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.elements.Platinum;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.Empty;
import com.github.egonw.odk.model.orbitals.Dsp;

public class Ptsp implements IAtomType {

	private static IAtomType type;

	private Ptsp() {}

	public static IAtomType getInstance() {
		if (type == null) type = new Ptsp();
		return type;
	}

	@Override
	public IElement getElement() {
		return Platinum.getInstance();
	}

	@Override
	public String getName() {
		return "Pt.sp";
	}

	@Override
	public List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();
		orbitals.add(Empty.getInstance(Dsp.getInstance()));
		orbitals.add(Empty.getInstance(Dsp.getInstance()));
		orbitals.add(Empty.getInstance(Dsp.getInstance()));
		orbitals.add(Empty.getInstance(Dsp.getInstance()));
		return orbitals;
	}

	@Override
	public short getOxidationState() {
		return 2;
	}

}
