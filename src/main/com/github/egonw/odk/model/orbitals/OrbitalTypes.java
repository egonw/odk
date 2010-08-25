package com.github.egonw.odk.model.orbitals;

import java.util.ArrayList;
import java.util.List;

import com.github.egonw.odk.interfaces.IOrbitalType;

public class OrbitalTypes {

	public static List<IOrbitalType> getOrbitalTypes() {
		List<IOrbitalType> types = new ArrayList<IOrbitalType>();
		types.add(Dsp.getInstance());
		types.add(Pz.getInstance());
		types.add(S.getInstance());
		types.add(Sp2.getInstance());
		types.add(Sp3.getInstance());
		return types;
	}
}
