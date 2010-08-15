package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class MolecularOrbital implements IMolecularOrbital {

	protected List<IOrbital> orbitals;

	protected MolecularOrbital(IOrbital... orbitals) {
		this.orbitals = new ArrayList<IOrbital>();
		for (IOrbital orbital : orbitals) {
			if (orbital == null)
				throw new NullPointerException("Orbital cannot be null");
			this.orbitals.add(orbital);
			((Orbital)orbital).overlap = this;
		}
	}

	@Override
	public List<IOrbital> getOrbitals() {
		List<IOrbital> orbitals = new ArrayList<IOrbital>();
		orbitals.addAll(this.orbitals);
		return orbitals;
	}

	@Override
	public IOrbitalType getOrbitalType() {
		return null;
	}

}
