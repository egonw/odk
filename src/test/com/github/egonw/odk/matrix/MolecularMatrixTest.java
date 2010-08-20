package com.github.egonw.odk.matrix;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.atomtypes.Osp3;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp3;

@RunWith(JExample.class)
public class MolecularMatrixTest {

	@Test
	public IMolecularMatrix testConstructor() {
		IMolecule water = createWater();
		IMolecularMatrix matrix = new MolecularMatrix(water.getAtoms().size());
		Assert.assertEquals(water.getAtoms().size(), matrix.getDimension());
		return matrix;
	}

	@Given("#testConstructor()")
	public void testAtomPositions(IMolecularMatrix matrix) {
		IMolecule water = createWater();

		List<IAtom> atoms = water.getAtoms();
		int position = 0;
		for (IAtom atom : atoms) {
			matrix.setAtomPosition(atom, position);
			position++;
		}
		position = 0;
		for (IAtom atom : atoms) {
			Assert.assertEquals((int)position, (int)matrix.getAtomPosition(atom));
			position++;
		}
	}

	private IMolecule createWater() {
		MoleculeFactory factory = new MoleculeFactory();
		IAtom oxygen = factory.addAtom(Osp3.getInstance());
		for (int i=1; i<=2; i++) {
			IAtom hydrogen = factory.addAtom(Hs.getInstance());
			factory.bind(
				oxygen.getFreeSingleElectron(Sp3.getInstance()),
				hydrogen.getFreeSingleElectron(S.getInstance())
			);
		}
		IMolecule water = factory.getImmutable();
		return water;
	}

	@Given("#testConstructor()")
	public void testDefaultValues(IMolecularMatrix matrix) {
		for (int i=0; i<matrix.getDimension(); i++) {
			for (int j=0; j<matrix.getDimension(); j++) {
				Assert.assertEquals(0, (int)matrix.getValue(i, j));				
				Assert.assertEquals(0, (int)matrix.getValue(j, i));				
			}
		}
	}	

	@Given("#testConstructor()")
	public void testValues(IMolecularMatrix matrix) {
		matrix.setValue(1, 2, 3);
		Assert.assertEquals(3, (int)matrix.getValue(1,2));
		Assert.assertEquals(3, (int)matrix.getValue(2,1));
	}	
	
}
