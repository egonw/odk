// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Technetium implements IElement {

	private final static String SYMBOL = "Tc";
	private static IElement instance;

	private Technetium() {};

	public static IElement getInstance() {
			Technetium.instance = new Technetium();
		return Technetium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 43;
	}

}
