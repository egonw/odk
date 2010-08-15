// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Lead implements IElement {

	private final static String SYMBOL = "Pb";
	private static IElement instance;

	private Lead() {};

	public static IElement getInstance() {
			Lead.instance = new Lead();
		return Lead.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 82;
	}

}
