package com.github.egonw.odk.model;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IBond;
import com.github.egonw.odk.interfaces.IOrbital;

public class Bond implements IBond {

	protected List<IOrbital> orbitals;

	protected Bond(IOrbital... orbitals) {
		this.orbitals = new ArrayList<IOrbital>();
		for (IOrbital orbital : orbitals) {
			if (orbital == null)
				throw new NullPointerException("Orbital cannot be null");
			this.orbitals.add(orbital);
			((Orbital)orbital).bond = this;
		}
	}

	@Override
	public List<IOrbital> getOrbitals() {
		List<IOrbital> orbitals = new ArrayList<IOrbital>();
		orbitals.addAll(this.orbitals);
		return orbitals;
	}

	@Override
	public int getElectronCount() {
		int count = 0;
		for (IOrbital orbital : this.orbitals) {
			count += orbital.getElectronCount();
		}
		return count;
	}

}
