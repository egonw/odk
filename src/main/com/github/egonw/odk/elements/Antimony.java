// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Antimony implements IElement {

	private final static String SYMBOL = "Sb";
	private static IElement instance;

	private Antimony() {};

	public static IElement getInstance() {
		if (Antimony.instance == null)
			Antimony.instance = new Antimony();
		return Antimony.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 51;
	}

}
