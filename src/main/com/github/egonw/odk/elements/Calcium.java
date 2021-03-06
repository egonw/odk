// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Calcium implements IElement {

	private final static String SYMBOL = "Ca";
	private static IElement instance;

	private Calcium() {};

	public static IElement getInstance() {
		if (Calcium.instance == null)
			Calcium.instance = new Calcium();
		return Calcium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 20;
	}

}
