package com.github.egonw.odk.compounds;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.atomtypes.Csp2;
import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.elements.Carbon;
import com.github.egonw.odk.elements.Hydrogen;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.Pz;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp2;
import com.github.egonw.odk.properties.AtomProperties;

@RunWith(JExample.class)
public class EthaneTest {

	@Test
	public MoleculeFactory testNewMoleculeFactory() {
		return new MoleculeFactory();
	}

	@Given("#testNewMoleculeFactory()")
	public IMolecule testMoleculeCreation(MoleculeFactory factory) {
		IAtom[] carbons = new IAtom[2];
		carbons[0] = factory.addAtom(Csp2.getInstance());
		carbons[1] = factory.addAtom(Csp2.getInstance());
		for (int j=0; j<2; j++) {
			for (int i=1; i<=2; i++) {
				IAtom hydrogen = factory.addAtom(Hs.getInstance());
				factory.bind(
					carbons[j].getFreeSingleElectron(Sp2.getInstance()),
					hydrogen.getFreeSingleElectron(S.getInstance())
				);
			}
		}
		factory.bind(
			carbons[0].getFreeSingleElectron(Sp2.getInstance()),
			carbons[1].getFreeSingleElectron(Sp2.getInstance())
		);
		factory.bind(
			carbons[0].getFreeSingleElectron(Pz.getInstance()),
			carbons[1].getFreeSingleElectron(Pz.getInstance())
		);
		IMolecule immutable = factory.getImmutable();
		Assert.assertNotNull(immutable);
		return immutable;
	}

	@Given("#testMoleculeCreation(com.github.egonw.odk.model.MoleculeFactory)")
	public void testMoleculeProperties(IMolecule molecule) {
		List<IAtom> atoms = molecule.getAtoms();
		Assert.assertEquals(6, atoms.size());
		Assert.assertEquals(6, molecule.getOverlaps().size());
		for (IAtom atom : atoms) {
			Assert.assertEquals(0, AtomProperties.getLonePairCount(atom));
			if (atom.getAtomType().getElement() == Carbon.getInstance()) {
				Assert.assertEquals(
					4, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					4, AtomProperties.getElectronCount(atom)
				);
				Assert.assertEquals(
					8, AtomProperties.getShellElectronCount(atom) // octet rule
				);
			} else if (atom.getAtomType().getElement() == Hydrogen.getInstance()) {
				Assert.assertEquals(
					1, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					1, AtomProperties.getElectronCount(atom)
				);
				Assert.assertEquals(
					2, AtomProperties.getShellElectronCount(atom)
				);
			} else {
				Assert.fail("Unexpected element in molecule");
			}
		}
	}
}
