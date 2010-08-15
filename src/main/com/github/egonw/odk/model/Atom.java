package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.interfaces.ISingleElectron;

public class Atom implements IAtom {

	protected IAtomType type;
	protected IMolecule molecule;
	protected List<IAtomicOrbital> orbitals;

	protected Atom(IAtomType type) {
		this.type = type;
		orbitals = new ArrayList<IAtomicOrbital>();
		for (IOrbitalType orbitalType : type.getOrbitalTypes()) {
			Orbital orbital = new Orbital();
			orbital.type = orbitalType;
			orbital.atom = this;
			orbitals.add(orbital);
		}
	}

	@Override
	public List<IAtomicOrbital> getOrbitals() {
		List<IAtomicOrbital> orbitals = new ArrayList<IAtomicOrbital>();
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
	public IAtomicOrbital getFreeSingleElectron(IOrbitalType type) {
		for (IAtomicOrbital orbital : this.orbitals) {
			IOrbitalType atomOrbitalType = orbital.getOrbitalType();
			if (atomOrbitalType instanceof ISingleElectron &&
				atomOrbitalType.isType(type) &&
				orbital.getOverlap() == null) {
				return orbital;
			}
		}
		throw new IllegalAccessError(
			"There is no free orbital of type " + type.getName()
		);
	}

}
