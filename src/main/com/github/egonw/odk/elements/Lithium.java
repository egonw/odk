// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Lithium implements IElement {

	private final static String SYMBOL = "Li";
	private static IElement instance;

	private Lithium() {};

	public static IElement getInstance() {
		if (Lithium.instance == null)
			Lithium.instance = new Lithium();
		return Lithium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 3;
	}

}
