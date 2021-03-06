// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Sodium implements IElement {

	private final static String SYMBOL = "Na";
	private static IElement instance;

	private Sodium() {};

	public static IElement getInstance() {
		if (Sodium.instance == null)
			Sodium.instance = new Sodium();
		return Sodium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 11;
	}

}
