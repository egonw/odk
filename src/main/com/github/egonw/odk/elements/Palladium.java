// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Palladium implements IElement {

	private final static String SYMBOL = "Pd";
	private static IElement instance;

	private Palladium() {};

	public static IElement getInstance() {
		if (Palladium.instance == null)
			Palladium.instance = new Palladium();
		return Palladium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 46;
	}

}
