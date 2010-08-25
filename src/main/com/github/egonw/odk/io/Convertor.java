package com.github.egonw.odk.io;

import com.github.egonw.odk.interfaces.IMolecule;
import com.github.egonw.odk.model.MoleculeFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;

public class Convertor {

	public static Model molecule2Model(IMolecule molecule) {
		Model model = createODKModel();
        Resource subject = model.createResource(
            "http://example.org/mol1"
        );
        model.add(subject, RDF.type, ODK.MOLECULE);
        return model;
	}

	public static IMolecule model2Molecule(Model model) {
		MoleculeFactory factory = new MoleculeFactory();
        return factory.getImmutable();
	}

	private static Model createODKModel() {
        Model model = ModelFactory.createOntologyModel();
        model.setNsPrefix("odk", ODK.URI);
        return model;
    }
}
