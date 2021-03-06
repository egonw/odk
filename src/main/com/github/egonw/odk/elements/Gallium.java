// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Gallium implements IElement {

	private final static String SYMBOL = "Ga";
	private static IElement instance;

	private Gallium() {};

	public static IElement getInstance() {
		if (Gallium.instance == null)
			Gallium.instance = new Gallium();
		return Gallium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 31;
	}

}
