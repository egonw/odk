// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Potassium implements IElement {

	private final static String SYMBOL = "K";
	private static IElement instance;

	private Potassium() {};

	public static IElement getInstance() {
		if (Potassium.instance == null)
			Potassium.instance = new Potassium();
		return Potassium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 19;
	}

}
