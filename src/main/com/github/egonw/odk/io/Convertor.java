package com.github.egonw.odk.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.egonw.odk.atomtypes.AtomTypes;
import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IAtomType;
import com.github.egonw.odk.interfaces.IAtomicOrbital;
import com.github.egonw.odk.interfaces.IElement;
import com.github.egonw.odk.interfaces.IFilledOrbitalType;
import com.github.egonw.odk.interfaces.IMolecularOrbital;
import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.interfaces.IOrbital;
import com.github.egonw.odk.interfaces.IOrbitalType;
import com.github.egonw.odk.model.MoleculeFactory;
import com.github.egonw.odk.model.orbitals.OrbitalTypes;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
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
    	List<IMolecularOrbital> overlaps = molecule.getOverlaps();
    	Map<IMolecularOrbital,Integer> moNumbers = new HashMap<IMolecularOrbital,Integer>();
    	int overlapCount = 0;
        for (IMolecularOrbital overlap : overlaps) {
        	System.out.println("Overlap: " + overlap);
        	overlapCount++;
        	moNumbers.put(overlap, overlapCount);
        	Resource ovRes = model.createResource(
                "http://example.org/overlap" + overlapCount
            );
        	model.add(ovRes, RDF.type, ODK.OVERLAP);
        	model.add(molRes, ODK.HASOVERLAP, ovRes);
        	List<IOrbital> ovOrbitals = overlap.getOrbitals();
        	for (IOrbital orbital : ovOrbitals) {
        		System.out.println(orbital.getClass().getName());
        		Integer orbNumber = orbNumbers.get(orbital);
        		if (orbNumber == null) {
        			// OK, not an atomic orbital
        			orbNumber = moNumbers.get(orbital);
        			if (orbNumber == null) {
        				// OK, the MO is not yet defined
        				overlapCount++;
        				orbNumber = Integer.valueOf(overlapCount);
        				moNumbers.put(overlap, orbNumber);
        			}
        			model.add(ovRes, ODK.BINDS, model.createResource(
            			"http://example.org/overlap" + orbNumber
            		));
        		} else {
        			model.add(ovRes, ODK.BINDS, model.createResource(
        				"http://example.org/orbital" + orbNumber
        			));
        		}
        	}
        }

        return model;
	}

	private static String cleanTypeName(String name) {
		return name.replaceAll("\\.", "");
	}

	public static IMolecule model2Molecule(Model model) {
		AtomTypes atList = new AtomTypes();
		ResIterator mols =
            model.listSubjectsWithProperty(RDF.type, ODK.MOLECULE);
		MoleculeFactory factory = new MoleculeFactory();
		Map<String,IAtom> odkAtoms = new HashMap<String,IAtom>();
        if (mols.hasNext()) {
            Resource rdfMol = mols.next();
            StmtIterator atoms = rdfMol.listProperties(ODK.HASATOM);
            while (atoms.hasNext()) {
                Resource rdfAtom = atoms.nextStatement().getResource();
                StmtIterator atomTypes = rdfAtom.listProperties(ODK.HASATOMTYPE);
                if (atomTypes.hasNext()) {
                	Resource rdfAtomType = atomTypes.nextStatement().getResource();
                	String rdfAtName = cleanTypeName(rdfAtomType.getLocalName());
                	if (atList.atomTypes.containsKey(rdfAtName)) {
                		odkAtoms.put(rdfAtom.getURI(), factory.addAtom(atList.atomTypes.get(rdfAtName)));
                	} else {
                		System.out.println("HELP, unrecognized AT: " + rdfAtName);
                	}
                }
            }
            // Look up all overlaps and make a TODO list
            StmtIterator overlaps = rdfMol.listProperties(ODK.HASOVERLAP);
            List<Resource> todoListOfOverlaps = new ArrayList<Resource>();
            while (overlaps.hasNext()) {
                todoListOfOverlaps.add(overlaps.nextStatement().getResource());
            }
            // now work my way through the todo list, and solve easy stuff first
    		Map<String,IOrbital> moOrbitalsMap = new HashMap<String,IOrbital>();
            boolean solvedSomething = true;
            while (todoListOfOverlaps.size() > 0 && solvedSomething) {
            	solvedSomething = false; // reset
            	List<Resource> currentTodoList = new ArrayList<Resource>();
            	currentTodoList.addAll(todoListOfOverlaps);
            	for (Resource rdfOverlap : currentTodoList) {
            		System.out.println(rdfOverlap.getURI());
            		StmtIterator orbitals = rdfOverlap.listProperties(ODK.BINDS);
            		List<IOrbital> odkOrbitals = new ArrayList<IOrbital>();
            		boolean tooComplexForNow = false;
            		while (orbitals.hasNext()) {
            			Resource rdfOrbital = orbitals.nextStatement().getResource();
            			System.out.println(rdfOrbital.getURI());
            			// OK, first guess: atomic orbital
            			ResIterator rdfAtoms = model.listResourcesWithProperty(ODK.HASORBITAL, rdfOrbital);
            			StmtIterator eCounts = rdfOrbital.listProperties(ODK.HASELECTRONCOUNT);
            			StmtIterator orbTypes = rdfOrbital.listProperties(ODK.HASORBITALTYPE);
            			if (rdfAtoms.hasNext() && eCounts.hasNext() && orbTypes.hasNext()) {
            				// bingo
            				String atomURI = rdfAtoms.next().getURI();
            				System.out.println("atom: " + atomURI);
            				IAtom atom = odkAtoms.get(atomURI);
            				IOrbitalType orbType = OrbitalTypes.getOrbitalType(
            						orbTypes.next().getResource().getLocalName()
            				);
            				int eCount = eCounts.next().getInt();
            				if (eCount == 0) {
            					odkOrbitals.add(atom.getFreeEmpty(orbType));
            				} else if (eCount == 1) {
            					odkOrbitals.add(atom.getFreeSingleElectron(orbType));
            				} else if (eCount == 2) {
            					odkOrbitals.add(atom.getFreeLonePair(orbType));
            				} else {
            					System.out.println("HELP: unrecognized number of electrons");
            				}
            			} else if (moOrbitalsMap.containsKey(rdfOrbital.getURI())) {
            				// OK, found an existing MO...
            				IOrbital moOrb = moOrbitalsMap.get(rdfOrbital.getURI());
            				odkOrbitals.add(moOrb);
            				System.out.println("OK, bound to MO...");
            			} else {
            				// OK, found an non-yet recreated MO...
            				tooComplexForNow = true;
            			}
            		}
            		if (!tooComplexForNow) {
            			IMolecularOrbital moOrb = factory.bind(odkOrbitals.toArray(new IOrbital[0]));
            			todoListOfOverlaps.remove(rdfOverlap);
            			moOrbitalsMap.put(rdfOverlap.getURI(), moOrb);
            			System.out.println("Added MO: " + rdfOverlap.getURI());
            			solvedSomething = true;
            		}
            	}
            }
        }
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
