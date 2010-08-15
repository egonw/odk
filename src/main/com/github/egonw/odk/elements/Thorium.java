// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Thorium implements IElement {

	private final static String SYMBOL = "Th";
	private static IElement instance;

	private Thorium() {};

	public static IElement getInstance() {
		if (Thorium.instance == null)
			Thorium.instance = new Thorium();
		return Thorium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 90;
	}

}
