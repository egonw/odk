package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IMolecule;

public class Molecule implements IMolecule {

	protected List<IAtom> atoms;
	protected List<IMolecularOrbital> overlaps;

	protected Molecule() {
		atoms = new ArrayList<IAtom>();
		overlaps = new ArrayList<IMolecularOrbital>();
	}

	@Override
	public List<IAtom> getAtoms() {
		List<IAtom> atoms = new ArrayList<IAtom>();
		atoms.addAll(this.atoms);
		return atoms;
	}

	@Override
	public List<IMolecularOrbital> getOverlaps() {
		List<IMolecularOrbital> overlaps = new ArrayList<IMolecularOrbital>();
		overlaps.addAll(this.overlaps);
		return overlaps;
	}

}
