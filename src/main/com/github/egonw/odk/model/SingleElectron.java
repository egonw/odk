package com.github.egonw.odk.model;

import java.util.HashMap;
import java.util.Map;

import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.interfaces.ISingleElectron;

public class SingleElectron implements ISingleElectron {

	private static Map<IOrbitalType,SingleElectron> singleElectrons = new HashMap<IOrbitalType,SingleElectron>();

	private IOrbitalType type;

	private SingleElectron(IOrbitalType type) {
		this.type = type;
	};

	public static ISingleElectron getInstance(IOrbitalType type) {
		if (!singleElectrons.containsKey(type)) {
			SingleElectron singleElectron = new SingleElectron(type);
			singleElectrons.put(type, singleElectron);
			return singleElectron;
		}
		return singleElectrons.get(type);
	}

	@Override
	public String getName() {
		return "single electron (" + type.getName() + ")";
	}

	@Override
	public short getElectronCount() {
		return 1;
	}

	@Override
	public boolean isType(IOrbitalType type) {
		return this.type.isType(type);
	}
}
