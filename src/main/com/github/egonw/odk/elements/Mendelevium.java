// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Mendelevium implements IElement {

	private final static String SYMBOL = "Md";
	private static IElement instance;

	private Mendelevium() {};

	public static IElement getInstance() {
			Mendelevium.instance = new Mendelevium();
		return Mendelevium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 101;
	}

}