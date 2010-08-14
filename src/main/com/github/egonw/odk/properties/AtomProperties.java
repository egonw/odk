package com.github.egonw.odk.properties;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IBond;
import com.github.egonw.odk.interfaces.IOrbital;

public class AtomProperties {

	public static int getElectronCount(IAtom atom) {
		int count = 0;
		System.out.println(atom.getAtomType().getElement().getSymbol());
		for (IOrbital orbital : atom.getOrbitals()) {
			System.out.println("  " + orbital.getOrbitalType().getName());
			count += orbital.getElectronCount();
		}
		return count;
	}

	public static List<IBond> getBonds(IAtom atom) {
		List<IBond> bonds = new ArrayList<IBond>();
		for (IOrbital orbital : atom.getOrbitals()) {
			if (orbital.getBond() != null) {
				bonds.add(orbital.getBond());
			}
		}
		return bonds;
	}

}
