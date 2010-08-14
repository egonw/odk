// autogenerated

package com.github.egonw.odk.elements;

import com.github.egonw.odk.interfaces.IElement;

public final class Oxygen implements IElement {

	private final static String SYMBOL = "O"; 
	private static IElement instance;

	private Oxygen() {};

	public static IElement getInstance() {
		if (Oxygen.instance == null)
			Oxygen.instance = new Oxygen();
		return Oxygen.instance;
	}
	
	@Override
	public String getSymbol() {
		return SYMBOL;
	}

	@Override
	public short getAtomicNumber() {
		return 8;
	}

}