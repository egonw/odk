package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IOverlap;
import com.github.egonw.odk.interfaces.IOrbital;

public abstract class AbstractOrbital implements IOrbital {

	private IAtom atom;
	private IOverlap overlap;
	private short electronCount;
	
	@Override
	public IAtom getAtom() {
		return this.atom;
	}

	@Override
	public IOverlap getOverlap() {
		return this.overlap;
	}

	@Override
	public short getElectronCount() {
		return this.electronCount;
	}

}
