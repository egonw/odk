package com.github.egonw.odk.properties;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;

public class MoleculeProperties {

	public static short getFormalCharge(IMolecule molecule) {
		short formalCharge = 0;
		for (IAtom atom : molecule.getAtoms()) {
			formalCharge += AtomProperties.getFormalCharge(atom);
		}
		return formalCharge;
	}

}
