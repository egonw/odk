// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Chromium implements IElement {

	private final static String SYMBOL = "Cr";
	private static IElement instance;

	private Chromium() {};

	public static IElement getInstance() {
		if (Chromium.instance == null)
			Chromium.instance = new Chromium();
		return Chromium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 24;
	}

}
