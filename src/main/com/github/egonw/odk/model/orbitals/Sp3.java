package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.IOrbitalType;

public class Sp3 implements IOrbitalType {

	private final static String NAME = "sp3";
	protected static IOrbitalType type;
	
	private Sp3() {};
	
	public static IOrbitalType getInstance() {
		if (type == null) type = new Sp3();
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
