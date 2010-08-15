package com.github.egonw.odk.compounds;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.atomtypes.Csp3;
import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.elements.Carbon;
import com.github.egonw.odk.elements.Hydrogen;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp3;
import com.github.egonw.odk.properties.AtomProperties;

@RunWith(JExample.class)
public class MethaneTest {

	@Test
	public MoleculeFactory testNewMoleculeFactory() {
		return new MoleculeFactory();
	}

	@Given("#testNewMoleculeFactory()")
	public IMolecule testMethane(MoleculeFactory factory) {
		IAtom carbon = factory.addAtom(Csp3.getInstance());
		for (int i=1; i<=4; i++) {
			IAtom hydrogen = factory.addAtom(Hs.getInstance());
			factory.bind(
				carbon.getFreeOrbital(Sp3.getInstance()),
				hydrogen.getFreeOrbital(S.getInstance())
			);
		}
		return factory.getImmutable();
	}

	@Given("#testMethane(com.github.egonw.odk.model.MoleculeFactory)")
	public void testMethaneProperties(IMolecule methane) {
		List<IAtom> atoms = methane.getAtoms();
		Assert.assertEquals(5, atoms.size());
		Assert.assertEquals(4, methane.getOverlaps().size());
		for (IAtom atom : atoms) {
			Assert.assertEquals(0, AtomProperties.getLonePairCount(atom));
			if (atom.getAtomType().getElement() == Carbon.getInstance()) {
				Assert.assertEquals(
					4, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					4, AtomProperties.getElectronCount(atom)
				);
			} else if (atom.getAtomType().getElement() == Hydrogen.getInstance()) {
				Assert.assertEquals(
					1, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					1, AtomProperties.getElectronCount(atom)
				);
			} else {
				Assert.fail("Unexpected element in methane");
			}
		}
	}
	
}
