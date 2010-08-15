// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Strontium implements IElement {

	private final static String SYMBOL = "Sr";
	private static IElement instance;

	private Strontium() {};

	public static IElement getInstance() {
			Strontium.instance = new Strontium();
		return Strontium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 38;
	}

}