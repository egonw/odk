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

import com.github.egonw.odk.atomtypes.Clminus;
import com.github.egonw.odk.atomtypes.Csp2;
import com.github.egonw.odk.atomtypes.Hs;
import com.github.egonw.odk.atomtypes.Ptsp;
import com.github.egonw.odk.elements.Carbon;
import com.github.egonw.odk.elements.Chlorine;
import com.github.egonw.odk.elements.Hydrogen;
import com.github.egonw.odk.elements.Platinum;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.io.ODKReader;
import com.github.egonw.odk.io.ODKWriter;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.Dsp;
import com.github.egonw.odk.model.orbitals.Pz;
import com.github.egonw.odk.model.orbitals.S;
import com.github.egonw.odk.model.orbitals.Sp2;
import com.github.egonw.odk.model.orbitals.Sp3;
import com.github.egonw.odk.properties.AtomProperties;
import com.github.egonw.odk.properties.MoleculeProperties;

@RunWith(JExample.class)
public class ZeisesSaltTest {

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
		IMolecularOrbital piBond = factory.bind(
			carbons[0].getFreeSingleElectron(Pz.getInstance()),
			carbons[1].getFreeSingleElectron(Pz.getInstance())
		);
		IAtom platinum = factory.addAtom(Ptsp.getInstance());
		// surround it with three chlorides
		for (int i=1; i<=3; i++) {
			IAtom chloride = factory.addAtom(Clminus.getInstance());
			factory.bind(
				platinum.getFreeEmpty(Dsp.getInstance()),
				chloride.getFreeLonePair(Sp3.getInstance())
			);
		}
		// and an ethene
		factory.bind(
			platinum.getFreeEmpty(Dsp.getInstance()),
			piBond
		);

		IMolecule immutable = factory.getImmutable();
		Assert.assertNotNull(immutable);
		return immutable;
	}

	@Given("#testMoleculeCreation(com.github.egonw.odk.model.MoleculeFactory)")
	public void testMoleculeProperties(IMolecule molecule) {
		testProperties(molecule);
	}

	@Given("#testMoleculeCreation(com.github.egonw.odk.model.MoleculeFactory)")
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

	private void testProperties(IMolecule molecule) {
		Assert.assertEquals(-1, MoleculeProperties.getFormalCharge(molecule));
		List<IAtom> atoms = molecule.getAtoms();
		Assert.assertEquals(10, atoms.size());
		Assert.assertEquals(10, molecule.getOverlaps().size());
		for (IAtom atom : atoms) {
			if (atom.getAtomType().getElement() == Carbon.getInstance()) {
				Assert.assertEquals(0, AtomProperties.getLonePairCount(atom));
				Assert.assertEquals(
					4, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					4, AtomProperties.getElectronCount(atom)
				);
				Assert.assertEquals(
					8, AtomProperties.getShellElectronCount(atom) // octet rule
				);
				Assert.assertEquals(
					0, AtomProperties.getFormalCharge(atom)
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
				Assert.assertEquals(
					0, AtomProperties.getFormalCharge(atom)
				);
			} else if (atom.getAtomType().getElement() == Platinum.getInstance()) {
				Assert.assertEquals(0, AtomProperties.getLonePairCount(atom));
				Assert.assertEquals(
					4, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					0, AtomProperties.getElectronCount(atom)
				);
				Assert.assertEquals(
					8, AtomProperties.getShellElectronCount(atom)
				);
				Assert.assertEquals(
					2, AtomProperties.getFormalCharge(atom)
				);
			} else if (atom.getAtomType().getElement() == Chlorine.getInstance()) {
				Assert.assertEquals(4, AtomProperties.getLonePairCount(atom));
				Assert.assertEquals(
					1, AtomProperties.getOverlaps(atom).size()
				);
				Assert.assertEquals(
					8, AtomProperties.getElectronCount(atom)
				);
				Assert.assertEquals(
					8, AtomProperties.getShellElectronCount(atom)
				);
				Assert.assertEquals(
					-1, AtomProperties.getFormalCharge(atom)
				);
			} else {
				Assert.fail("Unexpected element in molecule");
			}
		}
	}
}
