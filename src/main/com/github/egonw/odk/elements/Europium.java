// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Europium implements IElement {

	private final static String SYMBOL = "Eu";
	private static IElement instance;

	private Europium() {};

	public static IElement getInstance() {
		if (Europium.instance == null)
			Europium.instance = new Europium();
		return Europium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 63;
	}

}
