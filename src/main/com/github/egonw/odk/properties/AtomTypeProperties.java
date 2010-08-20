package com.github.egonw.odk.properties;

import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IFilledOrbitalType;
import com.github.egonw.odk.interfaces.ILonePair;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class AtomTypeProperties {

	public static int getLonePairCount(IAtomType type) {
		int count = 0;
		for (IOrbitalType orbital : type.getOrbitalTypes()) {
			if (orbital instanceof ILonePair) {
				count++;
			}
		}
		return count;
	}

	public static int getElectronCount(IAtomType atomType) {
		int count = 0;
		for (IOrbitalType type : atomType.getOrbitalTypes()) {
			if (type instanceof IFilledOrbitalType) {
				count += ((IFilledOrbitalType)type).getElectronCount();
			} else {
				count += 0; // no clue
			}
		}
		return count;
	}

	public static short getFormalCharge(IAtomType atomType) {
		short electronCount = (short)getElectronCount(atomType);
		return (short)(atomType.getOxidationState() - electronCount);
	}
}
