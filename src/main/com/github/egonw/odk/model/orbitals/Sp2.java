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
	public short getElectronCount() {
		return 1;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
