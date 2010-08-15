package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IOverlap;
import com.github.egonw.odk.interfaces.IMolecule;

public class Molecule implements IMolecule {

	protected List<IAtom> atoms;
	protected List<IOverlap> overlaps;

	protected Molecule() {
		atoms = new ArrayList<IAtom>();
		overlaps = new ArrayList<IOverlap>();
	}

	@Override
	public List<IAtom> getAtoms() {
		List<IAtom> atoms = new ArrayList<IAtom>();
		atoms.addAll(this.atoms);
		return atoms;
	}

	@Override
	public List<IOverlap> getOverlaps() {
		List<IOverlap> overlaps = new ArrayList<IOverlap>();
		overlaps.addAll(this.overlaps);
		return overlaps;
	}

}
