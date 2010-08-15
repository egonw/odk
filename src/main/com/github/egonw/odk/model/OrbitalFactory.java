package com.github.egonw.odk.model;

import com.github.egonw.odk.interfaces.IFactory;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class OrbitalFactory implements IFactory<IOrbital> {

	Orbital immutable;

	public OrbitalFactory() {
		immutable = new Orbital();
	}

	@Override
	public IOrbital getImmutable() {
		return immutable;
	}

	public void setOrbitalType(IOrbitalType type) {
		if (type == null)
			throw new NullPointerException(
				"Orbital type cannot be null"
			);
		immutable.type = type;
	}

}
