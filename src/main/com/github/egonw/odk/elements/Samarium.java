// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Samarium implements IElement {

	private final static String SYMBOL = "Sm";
	private static IElement instance;

	private Samarium() {};

	public static IElement getInstance() {
		if (Samarium.instance == null)
			Samarium.instance = new Samarium();
		return Samarium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 62;
	}

}
