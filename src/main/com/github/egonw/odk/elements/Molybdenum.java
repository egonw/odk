// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Molybdenum implements IElement {

	private final static String SYMBOL = "Mo";
	private static IElement instance;

	private Molybdenum() {};

	public static IElement getInstance() {
			Molybdenum.instance = new Molybdenum();
		return Molybdenum.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 42;
	}

}