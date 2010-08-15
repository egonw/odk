// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Tellurium implements IElement {

	private final static String SYMBOL = "Te";
	private static IElement instance;

	private Tellurium() {};

	public static IElement getInstance() {
			Tellurium.instance = new Tellurium();
		return Tellurium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 52;
	}

}