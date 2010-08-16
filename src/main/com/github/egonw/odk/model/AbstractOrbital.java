package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public abstract class AbstractOrbital implements IOrbital {

	protected IOrbitalType type;
	protected IMolecularOrbital overlap;

	@Override
	public IMolecularOrbital getOverlap() {
		return this.overlap;
	}

}
