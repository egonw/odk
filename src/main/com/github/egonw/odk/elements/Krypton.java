// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Krypton implements IElement {

	private final static String SYMBOL = "Kr";
	private static IElement instance;

	private Krypton() {};

	public static IElement getInstance() {
		if (Krypton.instance == null)
			Krypton.instance = new Krypton();
		return Krypton.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 36;
	}

}
