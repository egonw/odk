// autogenerated
package com.github.egonw.odk.atomtypes;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.Injection;
import ch.unibe.jexample.InjectionPolicy;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.elements.Nitrogen;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.properties.AtomTypeProperties;

@RunWith(JExample.class)
@Injection(InjectionPolicy.NONE)
public class NthioamideTest {

	@Test
	public IAtomType createAtomType() {
		IAtomType type = Nthioamide.getInstance();
		Assert.assertNotNull(type);
		return type;
	}

	@Given("createAtomType()")
	public void testLonePairCount(IAtomType type) {
		Assert.assertEquals(1, AtomTypeProperties.getLonePairCount(type));
	}

	@Given("createAtomType()")
	public void testElement(IAtomType type) {
		Assert.assertEquals(
			Nitrogen.getInstance(),
			type.getElement()
		);
	}

	@Given("createAtomType()")
	public void testFormalCharge(IAtomType type) {
		Assert.assertEquals(
			0,
			AtomTypeProperties.getFormalCharge(type)
		);
	}

	@Given("createAtomType()")
	public void testName(IAtomType type) {
		Assert.assertEquals(
			"N.thioamide", type.getName()
		);
	}

}
