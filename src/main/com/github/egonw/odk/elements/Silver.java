// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Silver implements IElement {

	private final static String SYMBOL = "Ag";
	private static IElement instance;

	private Silver() {};

	public static IElement getInstance() {
		if (Silver.instance == null)
			Silver.instance = new Silver();
		return Silver.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 47;
	}

}
