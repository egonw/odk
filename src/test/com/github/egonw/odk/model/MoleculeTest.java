package com.github.egonw.odk.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.interfaces.IMolecule;

@RunWith(JExample.class)
public class MoleculeTest {

	@Test
	public MoleculeFactory testNewMoleculeFactory() {
		return new MoleculeFactory();
	}

	@Given("#testNewMoleculeFactory()")
	public IMolecule testNewMolecule(MoleculeFactory factory) {
		return factory.getImmutable();
	}

	@Given("#testNewMoleculeFactory()")
	public IMolecule testNewMolecule2(MoleculeFactory factory) {
		return factory.getImmutable();
	}
}
