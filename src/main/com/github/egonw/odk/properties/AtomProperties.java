package com.github.egonw.odk.properties;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IFilledOrbitalType;
import com.github.egonw.odk.interfaces.ILonePair;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class AtomProperties {

	public static int getElectronCount(IAtom atom) {
		int count = 0;
		for (IAtomicOrbital orbital : atom.getOrbitals()) {
			IOrbitalType type = orbital.getOrbitalType();
			if (type instanceof IFilledOrbitalType) {
				count += ((IFilledOrbitalType)type).getElectronCount();
			} else {
				throw new IllegalArgumentException(
					"Cannot count electrons with unfilled orbital " + type.getName()
				);
			}
		}
		return count;
	}

	public static int getShellElectronCount(IAtom atom) {
		int count = 0;
		for (IAtomicOrbital orbital : atom.getOrbitals()) {
			IMolecularOrbital molOrbital = orbital.getOverlap();
			if (molOrbital != null) {
				count += MolecularOrbitalProperties.getElectronCount(molOrbital);
			} else {
				IOrbitalType type = orbital.getOrbitalType();
				if (type instanceof IFilledOrbitalType) {
					count += ((IFilledOrbitalType)type).getElectronCount();
				} else {
					throw new IllegalArgumentException(
						"Cannot count electrons with unfilled orbital " + type.getName()
					);
				}
			}
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

	public static short getFormalCharge(IAtom atom) {
		short electronCount = (short)getElectronCount(atom);
		return (short)(atom.getAtomType().getOxidationState() - electronCount);
	}

}
