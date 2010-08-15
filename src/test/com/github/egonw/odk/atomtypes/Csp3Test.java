package com.github.egonw.odk.atomtypes;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.Injection;
import ch.unibe.jexample.InjectionPolicy;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.elements.Carbon;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.properties.AtomTypeProperties;

@RunWith(JExample.class)
@Injection(InjectionPolicy.NONE)
public class Csp3Test {

	@Test
	public IAtomType createAtomType() {
		IAtomType type = Csp3.getInstance();
		Assert.assertNotNull(type);
		return type;
	}

	@Given("createAtomType()")
	public void testLonePairCount(IAtomType type) {
		Assert.assertEquals(0, AtomTypeProperties.getLonePairCount(type));
	}
	
	@Given("createAtomType()")
	public void testElement(IAtomType type) {
		Assert.assertEquals(
			Carbon.getInstance(),
			type.getElement()
		);
	}
	
}
