package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.IHybridizedOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Pz implements IHybridizedOrbital {

	private final static String NAME = "pz";
	protected static IOrbitalType type;
	
	private Pz() {};
	
	public static IOrbitalType getInstance() {
		if (type == null) type = new Pz();
		return type;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return Pz.type == type;
	}

}
