package com.github.egonw.odk.model;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.atomtypes.Csp3;
import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.atomtypes.Osp3;
import com.github.egonw.odk.elements.Carbon;
import com.github.egonw.odk.elements.Hydrogen;
import com.github.egonw.odk.elements.Oxygen;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp3;
import com.github.egonw.odk.properties.AtomProperties;

@RunWith(JExample.class)
public class MoleculeTest {

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
	
	@Given("#testNewMoleculeFactory()")
	public IMolecule testWater(MoleculeFactory factory) {
		IAtom oxygen = factory.addAtom(Osp3.getInstance());
		for (int i=1; i<=2; i++) {
			IAtom hydrogen = factory.addAtom(Hs.getInstance());
			factory.bind(
				oxygen.getFreeOrbital(Sp3.getInstance()),
				hydrogen.getFreeOrbital(S.getInstance())
			);
		}
		return factory.getImmutable();
	}

	@Given("#testWater(com.github.egonw.odk.model.MoleculeFactory)")
	public void testWaterProperties(IMolecule water) {
		List<IAtom> atoms = water.getAtoms();
		Assert.assertEquals(3, atoms.size());
		Assert.assertEquals(2, water.getOverlaps().size());
		for (IAtom atom : atoms) {
			if (atom.getAtomType().getElement() == Oxygen.getInstance()) {
				Assert.assertEquals(
					2, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					6, AtomProperties.getElectronCount(atom)
				);
			} else if (atom.getAtomType().getElement() == Hydrogen.getInstance()) {
				Assert.assertEquals(
					1, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					1, AtomProperties.getElectronCount(atom)
				);
			} else {
				Assert.fail("Unexpected element in water");
			}
		}
	}

	@Test(expected=IllegalAccessError.class)
	@Given("#testNewMoleculeFactory()")
	public void testTooManyHydrogens(MoleculeFactory factory) {
		IAtom carbon = factory.addAtom(Csp3.getInstance());
		for (int i=1; i<=5; i++) {
			IAtom hydrogen = factory.addAtom(Hs.getInstance());
			factory.bind(
				carbon.getFreeOrbital(Sp3.getInstance()), // this throws the Error
				hydrogen.getFreeOrbital(S.getInstance())
			);
		}
	}
}
