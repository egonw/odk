// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Indium implements IElement {

	private final static String SYMBOL = "In";
	private static IElement instance;

	private Indium() {};

	public static IElement getInstance() {
		if (Indium.instance == null)
			Indium.instance = new Indium();
		return Indium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 49;
	}

}
