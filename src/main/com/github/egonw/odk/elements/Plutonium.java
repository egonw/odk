// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Plutonium implements IElement {

	private final static String SYMBOL = "Pu";
	private static IElement instance;

	private Plutonium() {};

	public static IElement getInstance() {
		if (Plutonium.instance == null)
			Plutonium.instance = new Plutonium();
		return Plutonium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 94;
	}

}
