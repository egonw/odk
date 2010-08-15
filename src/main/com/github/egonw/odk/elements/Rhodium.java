// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Rhodium implements IElement {

	private final static String SYMBOL = "Rh";
	private static IElement instance;

	private Rhodium() {};

	public static IElement getInstance() {
			Rhodium.instance = new Rhodium();
		return Rhodium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 45;
	}

}
