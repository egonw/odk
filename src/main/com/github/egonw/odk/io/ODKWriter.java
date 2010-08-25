package com.github.egonw.odk.io;

import java.io.IOException;
import java.io.Writer;

import com.github.egonw.odk.interfaces.IMolecule;
import com.hp.hpl.jena.rdf.model.Model;

public class ODKWriter {

    private Writer output;

    public ODKWriter(Writer output) {
        this.output = output;
    }

    public void close() throws IOException {
        if (output != null) output.close();
    }

    public void writeMolecule(IMolecule mol) {
        Model model = Convertor.molecule2Model(mol);
        model.write(output, "N3");
    }

}
