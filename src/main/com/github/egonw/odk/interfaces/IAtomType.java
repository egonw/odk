package com.github.egonw.odk.interfaces;

import java.util.List;

public interface IAtomType {

	public String getName();
	public IElement getElement();
	public short getOxidationState();
	
	public List<IOrbitalType> getOrbitalTypes();

}
