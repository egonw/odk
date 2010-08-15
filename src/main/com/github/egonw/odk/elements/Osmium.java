// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Osmium implements IElement {

	private final static String SYMBOL = "Os";
	private static IElement instance;

	private Osmium() {};

	public static IElement getInstance() {
			Osmium.instance = new Osmium();
		return Osmium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 76;
	}

}
