package com.github.egonw.odk.matrix;

import com.github.egonw.odk.interfaces.IAtom;

public interface IMolecularMatrix {

	public int getDimension();

	public void setAtomPosition(IAtom atom, Integer position);
	public Integer getAtomPosition(IAtom atom);

	public void setValue(Integer xPos, Integer yPos, Integer value);
	public Integer getValue(Integer xPos, Integer yPos);

}
