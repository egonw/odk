// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Darmstadtium implements IElement {

	private final static String SYMBOL = "Ds";
	private static IElement instance;

	private Darmstadtium() {};

	public static IElement getInstance() {
			Darmstadtium.instance = new Darmstadtium();
		return Darmstadtium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 110;
	}

}