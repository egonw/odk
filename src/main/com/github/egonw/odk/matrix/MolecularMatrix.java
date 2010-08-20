package com.github.egonw.odk.matrix;

import java.util.HashMap;
import java.util.Map;

import com.github.egonw.odk.interfaces.IAtom;

public class MolecularMatrix implements IMolecularMatrix {

	private int atomCount;
	private Map<IAtom,Integer> positions;
	private Map<Integer,Integer> values;

	public MolecularMatrix(int atomCount) {
		this.atomCount = atomCount;
		positions = new HashMap<IAtom, Integer>();
		values = new HashMap<Integer,Integer>((int)(0.5*atomCount*atomCount)+1);
	}

	@Override
	public void setAtomPosition(IAtom atom, Integer position) {
		positions.put(atom, position);
	}

	@Override
	public Integer getAtomPosition(IAtom atom) {
		return positions.get(atom);
	}

	@Override
	public void setValue(Integer xPos, Integer yPos, Integer value) {
		int internalPos = (xPos > yPos)
			? xPos * (atomCount) + yPos
		    : yPos * (atomCount) + xPos;
		values.put(internalPos, value);
	}

	@Override
	public Integer getValue(Integer xPos, Integer yPos) {
		int internalPos = (xPos > yPos)
	     	? xPos * (atomCount) + yPos
	        : yPos * (atomCount) + xPos;
	    Integer value = values.get(internalPos);
	    return (value == null) ? 0 : value;
	}

	@Override
	public int getDimension() {
		return atomCount;
	}

}
