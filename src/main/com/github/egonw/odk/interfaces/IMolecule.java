package com.github.egonw.odk.interfaces;

import java.util.List;

public interface IMolecule {

	public List<IAtom> getAtoms();
	public List<IOverlap> getOverlaps();

}
