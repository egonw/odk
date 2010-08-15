// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Manganese implements IElement {

	private final static String SYMBOL = "Mn";
	private static IElement instance;

	private Manganese() {};

	public static IElement getInstance() {
			Manganese.instance = new Manganese();
		return Manganese.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 25;
	}

}