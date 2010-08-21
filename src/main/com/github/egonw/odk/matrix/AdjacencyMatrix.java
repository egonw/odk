package com.github.egonw.odk.matrix;

import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.interfaces.IOrbital;

public class AdjacencyMatrix {

	public static IMolecularMatrix getMatrix(IMolecule molecule) {
		List<IAtom> atoms = molecule.getAtoms();
		int atomCount = atoms.size();
		IMolecularMatrix matrix = new MolecularMatrix(atomCount);
		int position = 0;
		for (IAtom atom : atoms) {
			matrix.setAtomPosition(atom, position);
			position++;
		}
		for (IMolecularOrbital overlap : molecule.getOverlaps()) {
			List<IOrbital> orbitals = overlap.getOrbitals();
			if (orbitals.size() == 2) {
				// only consider localized bonds
				IOrbital orb1 = orbitals.get(0);
				IOrbital orb2 = orbitals.get(1);
				if (orb1 instanceof IAtomicOrbital &&
					orb2 instanceof IAtomicOrbital) {
					IAtom atom1 = ((IAtomicOrbital)orb1).getAtom();
					IAtom atom2 = ((IAtomicOrbital)orb2).getAtom();
					int atomPos1 = matrix.getAtomPosition(atom1);
					int atomPos2 = matrix.getAtomPosition(atom2);
					matrix.setValue(atomPos1, atomPos2, 1);
				}
			}
		}
		return matrix;
	}

}
