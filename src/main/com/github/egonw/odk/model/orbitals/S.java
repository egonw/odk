package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.IOrbitalType;

public class S implements IOrbitalType {

	private final static String NAME = "1s";
	private static IOrbitalType type;
	
	private S() {};
	
	public static IOrbitalType getInstance() {
		if (type == null) type = new S();
		return type;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return S.type == type;
	}

}
