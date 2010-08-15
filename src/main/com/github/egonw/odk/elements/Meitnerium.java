// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Meitnerium implements IElement {

	private final static String SYMBOL = "Mt";
	private static IElement instance;

	private Meitnerium() {};

	public static IElement getInstance() {
		if (Meitnerium.instance == null)
			Meitnerium.instance = new Meitnerium();
		return Meitnerium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 109;
	}

}
