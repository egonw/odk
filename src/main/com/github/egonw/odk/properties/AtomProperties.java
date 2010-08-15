package com.github.egonw.odk.properties;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IOverlap;
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

	public static List<IOverlap> getOverlaps(IAtom atom) {
		List<IOverlap> overlaps = new ArrayList<IOverlap>();
		for (IOrbital orbital : atom.getOrbitals()) {
			if (orbital.getOverlap() != null) {
				overlaps.add(orbital.getOverlap());
			}
		}
		return overlaps;
	}

}
