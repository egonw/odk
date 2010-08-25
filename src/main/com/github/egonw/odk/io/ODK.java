package com.github.egonw.odk.io;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public class ODK {

    public static final String URI = "http://egonw.github.com/odk/model.owl#";

    private static final Resource resource(String local) {
        return ResourceFactory.createResource(URI + local);
    }

    private static final Property property(String local) {
        return ResourceFactory.createProperty(URI, local);
    }

    public static final Resource MOLECULE = resource("Molecule");
    public static final Resource ATOM = resource("Atom");
    public static final Resource OVERLAP = resource("Overlap");
    public static final Resource ELEMENT = resource("Element");
    public static final Resource ATOMTYPE = resource("AtomType");
    public static final Resource ORBITAL = resource("Orbital");
    public static final Resource ORBITALTYPE = resource("OrbitalType");
    
    public static final Property HASATOM = property("hasAtom");
    public static final Property HASATOMTYPE = property("hasAtomType");
    public static final Property HASELEMENT = property("hasElement");
    public static final Property HASORBITAL = property("hasOrbital");
    public static final Property HASORBITALTYPE = property("hasOrbitalType");
	public static final Property HASELECTRONCOUNT = property("hasElectronCount");
    public static final Property HASOVERLAP = property("hasOverlap");
    public static final Property BINDS = property("binds");

}