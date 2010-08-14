package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IBond;
import com.github.egonw.odk.interfaces.IOrbital;

public abstract class AbstractOrbital implements IOrbital {

	private IAtom atom;
	private IBond bond;
	private short electronCount;
	
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
		return this.electronCount;
	}

}
