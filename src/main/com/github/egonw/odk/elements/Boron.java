// autogenerated
package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Boron implements IElement {

	private final static String SYMBOL = "B";
	private static IElement instance;

	private Boron() {};

	public static IElement getInstance() {
		if (Boron.instance == null)
			Boron.instance = new Boron();
		return Boron.instance;
	}

	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 5;
	}

}
