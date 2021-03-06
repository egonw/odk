// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Nitrogen implements IElement {

	private final static String SYMBOL = "N";
	private static IElement instance;

	private Nitrogen() {};

	public static IElement getInstance() {
		if (Nitrogen.instance == null)
			Nitrogen.instance = new Nitrogen();
		return Nitrogen.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 7;
	}

}
