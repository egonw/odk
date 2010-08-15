// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Thallium implements IElement {

	private final static String SYMBOL = "Tl";
	private static IElement instance;

	private Thallium() {};

	public static IElement getInstance() {
			Thallium.instance = new Thallium();
		return Thallium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 81;
	}

}
