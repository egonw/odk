package com.github.egonw.odk.model;

import java.util.HashMap;
import java.util.Map;

import com.github.egonw.odk.interfaces.ILonePair;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class LonePair implements ILonePair {

	private static Map<IOrbitalType,LonePair> lonepairs= new HashMap<IOrbitalType, LonePair>();

	private IOrbitalType type;

	private LonePair(IOrbitalType type) {
		this.type = type;
	};

	public static ILonePair getInstance(IOrbitalType type) {
		if (!lonepairs.containsKey(type)) {
			LonePair lonepair = new LonePair(type);
			lonepairs.put(type, lonepair);
			return lonepair;
		}
		return lonepairs.get(type);
	}

	@Override
	public String getName() {
		return "lone pair (" + type.getName() + ")";
	}

	@Override
	public short getElectronCount() {
		return 2;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return this.type.isType(type);
	}
}
