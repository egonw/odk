// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Cesium implements IElement {

	private final static String SYMBOL = "Cs";
	private static IElement instance;

	private Cesium() {};

	public static IElement getInstance() {
		if (Cesium.instance == null)
			Cesium.instance = new Cesium();
		return Cesium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 55;
	}

}
