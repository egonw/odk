// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Gold implements IElement {

	private final static String SYMBOL = "Au";
	private static IElement instance;

	private Gold() {};

	public static IElement getInstance() {
			Gold.instance = new Gold();
		return Gold.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 79;
	}

}
