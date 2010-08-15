package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Atom implements IAtom {

	protected IAtomType type;
	protected IMolecule molecule;
	protected List<IOrbital> orbitals;

	protected Atom(IAtomType type) {
		this.type = type;
		orbitals = new ArrayList<IOrbital>();
		for (IOrbitalType orbitalType : type.getOrbitalTypes()) {
			Orbital orbital = new Orbital(orbitalType);
			orbital.atom = this;
			orbitals.add(orbital);
		}
	}

	@Override
	public List<IOrbital> getOrbitals() {
		List<IOrbital> orbitals = new ArrayList<IOrbital>();
		orbitals.addAll(this.orbitals);
		return orbitals;
	}

	@Override
	public IMolecule getMolecule() {
		return this.molecule;
	}

	@Override
	public IAtomType getAtomType() {
		return this.type;
	}

	@Override
	public IOrbital getFreeOrbital(IOrbitalType type) {
		for (IOrbital orbital : this.orbitals) {
			if (orbital.getOrbitalType() == type &&
				orbital.getOverlap() == null) {
				return orbital;
			}
		}
		throw new IllegalAccessError(
			"There is no free orbital of type " + type.getName()
		);
	}

}
