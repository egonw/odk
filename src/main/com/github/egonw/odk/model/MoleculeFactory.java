package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IFactory;
import com.github.egonw.odk.interfaces.IMolecule;

public class MoleculeFactory implements IFactory<IMolecule> {

	Molecule immutable;

	public MoleculeFactory() {
		immutable = new Molecule();
	}

	@Override
	public IMolecule getImmutable() {
		return immutable;
	}

}
