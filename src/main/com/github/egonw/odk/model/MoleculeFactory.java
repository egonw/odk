package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IBond;
import com.github.egonw.odk.interfaces.IFactory;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.interfaces.IOrbital;

public class MoleculeFactory implements IFactory<IMolecule> {

	Molecule immutable;

	public MoleculeFactory() {
		immutable = new Molecule();
	}

	public IAtom addAtom(IAtomType type) {
		if (type == null)
			throw new NullPointerException("Atom type cannot be null.");
		Atom atom = new Atom(type);
		atom.molecule = immutable;
		immutable.atoms.add(atom);
		return atom;
	}

	@Override
	public IMolecule getImmutable() {
		return immutable;
	}

	public IBond bind(IOrbital... orbitals) {
		Bond bond = new Bond(orbitals);
		immutable.bonds.add(bond);
		return bond;
	}

}
