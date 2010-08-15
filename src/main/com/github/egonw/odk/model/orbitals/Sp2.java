package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.IHybridizedOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Sp2 implements IHybridizedOrbital {

	private final static String NAME = "sp2";
	protected static IOrbitalType type;
	
	private Sp2() {};
	
	public static IOrbitalType getInstance() {
		if (type == null) type = new Sp2();
		return type;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return Sp2.type == type;
	}

}
