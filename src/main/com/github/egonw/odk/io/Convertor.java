package com.github.egonw.odk.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IFilledOrbitalType;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.OrbitalTypes;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class Convertor {

	private final static String ELEM_URI = "http://egonw.github.com/odk/element#";
	private final static String AT_URI = "http://egonw.github.com/odk/atomtype#";
	private final static String OT_URI = "http://egonw.github.com/odk/orbitaltype#";
	
	public static Model molecule2Model(IMolecule molecule) {
		Model model = createODKModel();
        Resource molRes = model.createResource(
            "http://example.org/mol1"
        );
        model.add(molRes, RDF.type, ODK.MOLECULE);

        // convert the atoms
        List<IAtomType> rdfizedTypes = new ArrayList<IAtomType>();
        List<IElement> rdfizedElements = new ArrayList<IElement>();
        List<IOrbitalType> rdfizedOrbTypes = new ArrayList<IOrbitalType>();
        Map<IAtom,Integer> atomNumbers = new HashMap<IAtom, Integer>(); 
        Map<IAtomicOrbital,Integer> orbNumbers = new HashMap<IAtomicOrbital, Integer>(); 
        int atomCount = 0;
    	int orbCount = 0;

    	List<IAtom> atoms = molecule.getAtoms();
        for (IAtom atom : atoms) {
        	atomCount++;
        	atomNumbers.put(atom, Integer.valueOf(atomCount));
        	Resource atomRes = model.createResource(
                "http://example.org/atom" + atomCount
        	);
        	model.add(atomRes, RDF.type, ODK.ATOM);
        	IAtomType type = atom.getAtomType();
        	String typeResURI = AT_URI + cleanTypeName(type.getName());
    		Resource typeRes = model.createResource(typeResURI);
        	if (!rdfizedTypes.contains(type)) {
        		model.add(typeRes, RDF.type, ODK.ATOMTYPE);
        		rdfizedTypes.add(type);
            	IElement elem = type.getElement();
            	String elemResURI = ELEM_URI + elem.getSymbol();
        		Resource elemRes = model.createResource(elemResURI);
            	if (!rdfizedElements.contains(type)) {
            		model.add(elemRes, RDF.type, ODK.ELEMENT);
            		rdfizedElements.add(elem);
            	}
            	model.add(typeRes, ODK.HASELEMENT, elemRes);
        	}
        	model.add(atomRes, ODK.HASATOMTYPE, typeRes);
        	model.add(molRes, ODK.HASATOM, atomRes);
        	// convert the orbitals
        	List<IAtomicOrbital> orbitals = atom.getOrbitals();
        	for (IAtomicOrbital orbital : orbitals) {
        		orbCount++;
        		orbNumbers.put(orbital, Integer.valueOf(orbCount));
        		Resource orbRes = model.createResource(
                    "http://example.org/orbital" + orbCount
        		);
        		model.add(orbRes, RDF.type, ODK.ORBITAL);
        		model.add(atomRes, ODK.HASORBITAL, orbRes);
            	IOrbitalType ot = orbital.getOrbitalType();
            	if (ot instanceof IFilledOrbitalType) {
            		IFilledOrbitalType fot = (IFilledOrbitalType)ot;
            		List<IOrbitalType> types = OrbitalTypes.getOrbitalTypes();
            		for (IOrbitalType hybridType : types) {
            			if (fot.isType(hybridType)) {
            				String otResURI = OT_URI + hybridType.getClass().getSimpleName();
            				Resource otRes = model.createResource(otResURI);
            				if (!rdfizedOrbTypes.contains(ot)) {
            					model.add(otRes, RDF.type, ODK.ORBITALTYPE);
            					rdfizedOrbTypes.add(ot);
            				}
            				model.add(orbRes, ODK.HASORBITALTYPE, otRes);
            				break;
            			}
            		}
            		model.add(orbRes, ODK.HASELECTRONCOUNT, "" + fot.getElectronCount());
            	}
        	}
        }

        return model;
	}

	private static String cleanTypeName(String name) {
		return name.replaceAll("\\.", "");
	}

	public static IMolecule model2Molecule(Model model) {
		MoleculeFactory factory = new MoleculeFactory();
        return factory.getImmutable();
	}

	private static Model createODKModel() {
        Model model = ModelFactory.createOntologyModel();
        model.setNsPrefix("odk", ODK.URI);
        model.setNsPrefix("at", AT_URI);
        model.setNsPrefix("elem", ELEM_URI);
        model.setNsPrefix("ot", OT_URI);
        model.setNsPrefix("", "http://example.org/");
        return model;
    }
}
