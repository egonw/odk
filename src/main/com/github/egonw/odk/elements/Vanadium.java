// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Vanadium implements IElement {

	private final static String SYMBOL = "V";
	private static IElement instance;

	private Vanadium() {};

	public static IElement getInstance() {
		if (Vanadium.instance == null)
			Vanadium.instance = new Vanadium();
		return Vanadium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 23;
	}

}
