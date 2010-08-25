package com.github.egonw.odk.compounds;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.atomtypes.Osp3;
import com.github.egonw.odk.elements.Hydrogen;
import com.github.egonw.odk.elements.Oxygen;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.io.ODKReader;
import com.github.egonw.odk.io.ODKWriter;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp3;
import com.github.egonw.odk.properties.AtomProperties;
import com.github.egonw.odk.properties.MoleculeProperties;

@RunWith(JExample.class)
public class WaterTest {

	@Test
	public MoleculeFactory testNewMoleculeFactory() {
		return new MoleculeFactory();
	}

	@Given("#testNewMoleculeFactory()")
	public IMolecule testWater(MoleculeFactory factory) {
		IAtom oxygen = factory.addAtom(Osp3.getInstance());
		for (int i=1; i<=2; i++) {
			IAtom hydrogen = factory.addAtom(Hs.getInstance());
			factory.bind(
				oxygen.getFreeSingleElectron(Sp3.getInstance()),
				hydrogen.getFreeSingleElectron(S.getInstance())
			);
		}
		IMolecule immutable = factory.getImmutable();
		Assert.assertNotNull(immutable);
		return immutable;
	}

	@Given("#testWater(com.github.egonw.odk.model.MoleculeFactory)")
	public void testWaterProperties(IMolecule water) {
		testProperties(water);
	}
	
	@Given("#testWater(com.github.egonw.odk.model.MoleculeFactory)")
	public String testWrite(IMolecule salt) throws IOException {
		StringWriter stringWriter = new StringWriter();
		ODKWriter odkWriter = new ODKWriter(stringWriter);
		odkWriter.writeMolecule(salt);
		odkWriter.close();
		String notation3 = stringWriter.toString();
		Assert.assertNotNull(notation3);
		Assert.assertNotSame(0, notation3.length());
		System.out.println(notation3);
		return notation3;
	}

	@Given("#testWrite(com.github.egonw.odk.interfaces.IMolecule)")
	public IMolecule testRead(String notation3) throws IOException {
		ODKReader reader = new ODKReader(new StringReader(notation3));
		IMolecule salt = reader.read();
		Assert.assertNotNull(salt);
		return salt;
	}

	@Given("#testRead(java.lang.String)")
	public void testRoundtrippedProperties(IMolecule molecule) {
		testProperties(molecule);
	}

	public void testProperties(IMolecule water) {
		Assert.assertEquals(0, MoleculeProperties.getFormalCharge(water));
		List<IAtom> atoms = water.getAtoms();
		Assert.assertEquals(3, atoms.size());
		Assert.assertEquals(2, water.getOverlaps().size());
		for (IAtom atom : atoms) {
			if (atom.getAtomType().getElement() == Oxygen.getInstance()) {
				Assert.assertEquals(2, AtomProperties.getLonePairCount(atom));
				Assert.assertEquals(
					2, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					6, AtomProperties.getElectronCount(atom)
				);
				Assert.assertEquals(
					8, AtomProperties.getShellElectronCount(atom) // octet rule
				);
			} else if (atom.getAtomType().getElement() == Hydrogen.getInstance()) {
				Assert.assertEquals(0, AtomProperties.getLonePairCount(atom));
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
				Assert.fail("Unexpected element in water");
			}
		}
	}

}
