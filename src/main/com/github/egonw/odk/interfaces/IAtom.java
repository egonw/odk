package com.github.egonw.odk.interfaces;

import java.util.List;

public interface IAtom {
	
	public IAtomType getAtomType();

	public List<IAtomicOrbital> getOrbitals();

	public IMolecule getMolecule();
	
	public IOrbital getFreeSingleElectron(IOrbitalType type);

}
