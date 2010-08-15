package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.IHybridizedOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Sp3 implements IHybridizedOrbital {

	private final static String NAME = "sp3";
	protected static IOrbitalType type;
	
	private Sp3() {};
	
	public static IOrbitalType getInstance() {
		if (type == null) type = new Sp3();
		return type;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return Sp3.type == type;
	}

}
