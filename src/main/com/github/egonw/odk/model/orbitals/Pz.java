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
	public short getElectronCount() {
		return 1;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
