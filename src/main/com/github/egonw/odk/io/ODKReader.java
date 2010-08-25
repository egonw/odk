package com.github.egonw.odk.io;

import java.io.IOException;
import java.io.Reader;

import com.github.egonw.odk.interfaces.IMolecule;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ODKReader {

    private Reader input;

    public ODKReader(Reader input) {
        this.input = input;
    }
    
    public IMolecule read() {
    	Model model = ModelFactory.createOntologyModel();
    	model.read(input, "", "N3");
    	return Convertor.model2Molecule(model);
    }

    public void close() throws IOException {
        input.close();
    }

}

