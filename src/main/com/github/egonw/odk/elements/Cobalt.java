// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Cobalt implements IElement {

	private final static String SYMBOL = "Co";
	private static IElement instance;

	private Cobalt() {};

	public static IElement getInstance() {
		if (Cobalt.instance == null)
			Cobalt.instance = new Cobalt();
		return Cobalt.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 27;
	}

}
