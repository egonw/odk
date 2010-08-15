package com.github.egonw.odk.model;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import ch.unibe.jexample.Given;
import ch.unibe.jexample.JExample;

import com.github.egonw.odk.interfaces.ILonePair;
import com.github.egonw.odk.model.orbitals.Sp3;

@RunWith(JExample.class)
public class LonePairTest {

	@Test
	public ILonePair testSp3LonePair() {
		ILonePair lonePair = LonePair.getInstance(Sp3.getInstance());
		Assert.assertNotNull(lonePair);
		return lonePair;
	}

	@Given("#testSp3LonePair()")
	public void testType(ILonePair lonePair) {
		Assert.assertTrue(lonePair.isType(Sp3.getInstance()));
	}

}
