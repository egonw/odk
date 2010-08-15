// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Praseodymium implements IElement {

	private final static String SYMBOL = "Pr";
	private static IElement instance;

	private Praseodymium() {};

	public static IElement getInstance() {
		if (Praseodymium.instance == null)
			Praseodymium.instance = new Praseodymium();
		return Praseodymium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 59;
	}

}
