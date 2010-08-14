package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IBond;
import com.github.egonw.odk.interfaces.IMolecule;

public class Molecule implements IMolecule {

	protected List<IAtom> atoms;
	protected List<IBond> bonds;

	protected Molecule() {
		atoms = new ArrayList<IAtom>();
		bonds = new ArrayList<IBond>();
	}

	@Override
	public List<IAtom> getAtoms() {
		List<IAtom> atoms = new ArrayList<IAtom>();
		atoms.addAll(this.atoms);
		return atoms;
	}

	@Override
	public List<IBond> getBonds() {
		List<IBond> bonds = new ArrayList<IBond>();
		bonds.addAll(this.bonds);
		return bonds;
	}

}
