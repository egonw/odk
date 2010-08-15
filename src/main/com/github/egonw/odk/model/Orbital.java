package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Orbital implements IAtomicOrbital {

	protected IOrbitalType type;
	protected IAtom atom;
	protected IMolecularOrbital overlap;

	protected Orbital(IOrbitalType type) {
		this.type = type;
	}

	@Override
	public IAtom getAtom() {
		return this.atom;
	}

	@Override
	public IMolecularOrbital getOverlap() {
		return this.overlap;
	}

	@Override
	public IOrbitalType getOrbitalType() {
		return this.type;
	}

}
