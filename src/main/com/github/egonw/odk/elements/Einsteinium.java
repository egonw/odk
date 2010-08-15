// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Einsteinium implements IElement {

	private final static String SYMBOL = "Es";
	private static IElement instance;

	private Einsteinium() {};

	public static IElement getInstance() {
			Einsteinium.instance = new Einsteinium();
		return Einsteinium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 99;
	}

}
