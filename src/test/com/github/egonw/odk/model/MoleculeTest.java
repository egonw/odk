package com.github.egonw.odk.model;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.atomtypes.Csp3;
import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp3;

@RunWith(JExample.class)
public class MoleculeTest {

	@Test
	public MoleculeFactory testNewMoleculeFactory() {
		return new MoleculeFactory();
	}

	@Test(expected=IllegalAccessError.class)
	@Given("#testNewMoleculeFactory()")
	public void testTooManyHydrogens(MoleculeFactory factory) {
		IAtom carbon = factory.addAtom(Csp3.getInstance());
		for (int i=1; i<=5; i++) {
			IAtom hydrogen = factory.addAtom(Hs.getInstance());
			factory.bind(
				carbon.getFreeSingleElectron(Sp3.getInstance()), // this throws the Error
				hydrogen.getFreeSingleElectron(S.getInstance())
			);
		}
	}
}
