package com.github.egonw.odk.properties;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.ILonePair;
import com.github.egonw.odk.interfaces.IMolecularOrbital;

public class AtomProperties {

	public static int getElectronCount(IAtom atom) {
		int count = 0;
		System.out.println(atom.getAtomType().getElement().getSymbol());
		for (IAtomicOrbital orbital : atom.getOrbitals()) {
			System.out.println("  " + orbital.getOrbitalType().getName());
			count += orbital.getOrbitalType().getElectronCount();
		}
		return count;
	}

	public static int getLonePairCount(IAtom atom) {
		int count = 0;
		for (IAtomicOrbital orbital : atom.getOrbitals()) {
			if (orbital.getOrbitalType() instanceof ILonePair) {
				count++;
			}
		}
		return count;
	}

	public static List<IMolecularOrbital> getOverlaps(IAtom atom) {
		List<IMolecularOrbital> overlaps = new ArrayList<IMolecularOrbital>();
		for (IAtomicOrbital orbital : atom.getOrbitals()) {
			if (orbital.getOverlap() != null) {
				overlaps.add(orbital.getOverlap());
			}
		}
		return overlaps;
	}

}
