package com.github.egonw.odk.interfaces;

public interface IOrbital {

	public IOrbitalType getOrbitalType();
	public IAtom getAtom();
	public IOverlap getOverlap();
	public short getElectronCount();
	
}
