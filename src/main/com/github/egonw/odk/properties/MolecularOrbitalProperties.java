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
			if (orbital instanceof IMolecularOrbital) {
				count += getElectronCount((IMolecularOrbital)orbital);
			} else {
				IOrbitalType type = orbital.getOrbitalType();
				if (type instanceof IFilledOrbitalType) {
					count += ((IFilledOrbitalType)type).getElectronCount();
				} else {
					System.out.println(orbital);
					throw new IllegalArgumentException(
							"Cannot count electrons with unfilled orbital " + type.getName()
					);
				}
			}
		}
		return count;
	}
}
