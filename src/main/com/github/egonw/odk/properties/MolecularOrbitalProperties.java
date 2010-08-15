package com.github.egonw.odk.properties;

import java.util.List;

import com.github.egonw.odk.interfaces.IFilledOrbitalType;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class MolecularOrbitalProperties {

	public static int getElectronCount(IMolecularOrbital molOrbital) {
		int count = 0;
		List<IOrbital> atomicOrbitals = molOrbital.getOrbitals();
		for (IOrbital orbital : atomicOrbitals) {
			IOrbitalType type = orbital.getOrbitalType();
			if (type instanceof IFilledOrbitalType) {
				count += ((IFilledOrbitalType)type).getElectronCount();
			} else {
				count += 0; // no clue
			}
		}
		return count;
	}
}
