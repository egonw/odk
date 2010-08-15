// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Zirconium implements IElement {

	private final static String SYMBOL = "Zr";
	private static IElement instance;

	private Zirconium() {};

	public static IElement getInstance() {
			Zirconium.instance = new Zirconium();
		return Zirconium.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 40;
	}

}
