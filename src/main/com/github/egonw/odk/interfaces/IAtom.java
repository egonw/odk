package com.github.egonw.odk.interfaces;

import java.util.List;

public interface IAtom {
	
	public IAtomType getAtomType();

	public List<IOrbital> getOrbitals();

	public IMolecule getMolecule();
	
	public IOrbital getFreeOrbital(IOrbitalType type);

}
