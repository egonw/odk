package com.github.egonw.odk.model.orbitals;

import com.github.egonw.odk.interfaces.ILonePair;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Sp3LonePair implements ILonePair {

	private final static String NAME = "sp3 lone pair";
	private static IOrbitalType type;
	
	private Sp3LonePair() {};
	
	public static IOrbitalType getInstance() {
		if (type == null) type = new Sp3LonePair();
		return type;
	}
	
	@Override
	public short getElectronCount() {
		return 2;
	}

	@Override
	public String getName() {
		return NAME;
	}

}
