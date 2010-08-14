package com.github.egonw.odk.interfaces;

public interface IOrbital {

	public IOrbitalType getOrbitalType();
	public IAtom getAtom();
	public IBond getBond();
	public short getElectronCount();
	
}
