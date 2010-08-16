package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Orbital extends AbstractOrbital implements IAtomicOrbital {

	protected IOrbitalType type;
	protected IAtom atom;

	protected Orbital() {}

	@Override
	public IAtom getAtom() {
		return this.atom;
	}

	@Override
	public IOrbitalType getOrbitalType() {
		return this.type;
	}

}
