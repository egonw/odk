// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Arsenic implements IElement {

	private final static String SYMBOL = "As";
	private static IElement instance;

	private Arsenic() {};

	public static IElement getInstance() {
			Arsenic.instance = new Arsenic();
		return Arsenic.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 33;
	}

}
