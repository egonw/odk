package com.github.egonw.odk.properties;

import com.github.egonw.odk.interfaces.IAtomType;
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

}
