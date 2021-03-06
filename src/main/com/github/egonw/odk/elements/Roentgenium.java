// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Roentgenium implements IElement {

	private final static String SYMBOL = "Rg";
	private static IElement instance;

	private Roentgenium() {};

	public static IElement getInstance() {
		if (Roentgenium.instance == null)
			Roentgenium.instance = new Roentgenium();
		return Roentgenium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 111;
	}

}
