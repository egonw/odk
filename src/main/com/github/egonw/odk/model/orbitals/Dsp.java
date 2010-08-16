package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.IHybridizedOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

/**
 * A hybridized combination of d orbitals, resulted in a
 * square planar orientation.
 *
 * @author egonw
 */
public class Dsp implements IHybridizedOrbital {

	private final static String NAME = "dsp";
	protected static IOrbitalType type;

	private Dsp() {};

	public static IOrbitalType getInstance() {
		if (type == null) type = new Dsp();
		return type;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return Dsp.type == type;
	}

}
