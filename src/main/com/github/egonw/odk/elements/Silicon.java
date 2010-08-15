// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Silicon implements IElement {

	private final static String SYMBOL = "Si";
	private static IElement instance;

	private Silicon() {};

	public static IElement getInstance() {
			Silicon.instance = new Silicon();
		return Silicon.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 14;
	}

}