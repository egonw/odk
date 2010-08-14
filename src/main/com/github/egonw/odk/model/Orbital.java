package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IBond;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Orbital implements IOrbital {

	protected IOrbitalType type;
	protected IAtom atom;
	protected IBond bond;

	protected Orbital(IOrbitalType type) {
		this.type = type;
	}

	@Override
	public IAtom getAtom() {
		return this.atom;
	}

	@Override
	public IBond getBond() {
		return this.bond;
	}

	@Override
	public short getElectronCount() {
		return type.getElectronCount();
	}

	@Override
	public IOrbitalType getOrbitalType() {
		return this.type;
	}

}
