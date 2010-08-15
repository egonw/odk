package com.github.egonw.odk.model;

import java.util.HashMap;
import java.util.Map;

import com.github.egonw.odk.interfaces.IEmpty;
import com.github.egonw.odk.interfaces.IOrbitalType;

public class Empty implements IEmpty {

	private static Map<IOrbitalType,Empty> empties = new HashMap<IOrbitalType,Empty>();

	private IOrbitalType type;

	private Empty(IOrbitalType type) {
		this.type = type;
	};

	public static IEmpty getInstance(IOrbitalType type) {
		if (!empties.containsKey(type)) {
			Empty empty = new Empty(type);
			empties.put(type, empty);
			return empty;
		}
		return empties.get(type);
	}

	@Override
	public String getName() {
		return "empty (" + type.getName() + ")";
	}

	@Override
	public short getElectronCount() {
		return 0;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return this.type.isType(type);
	}
}
