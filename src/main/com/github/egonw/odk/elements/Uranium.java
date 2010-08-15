// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Uranium implements IElement {

	private final static String SYMBOL = "U";
	private static IElement instance;

	private Uranium() {};

	public static IElement getInstance() {
			Uranium.instance = new Uranium();
		return Uranium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 92;
	}

}
