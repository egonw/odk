package com.github.egonw.odk.matrix;

import java.util.Set;

import com.github.egonw.odk.interfaces.IAtom;
import com.github.egonw.odk.interfaces.IMolecule;

public class DistanceMatrix {

	public static IMolecularMatrix getMatrix(IMolecule molecule) {	
		IMolecularMatrix conMatrix = AdjacencyMatrix.getMatrix(molecule);
    	// copy atom positions
    	IMolecularMatrix distMatrix = new MolecularMatrix(conMatrix.getDimension()); 
    	Set<IAtom> atoms = conMatrix.getAtoms();
    	for (IAtom atom : atoms) {
    		distMatrix.setAtomPosition(atom, conMatrix.getAtomPosition(atom));
    	}

    	// foo bar
        int i;
        int j;
        int k;
        int nrow = conMatrix.getDimension();
        for (i = 0; i < nrow; i++) {
            for (j = 0; j < nrow; j++) {
                if (conMatrix.getValue(i,j) == 0) {
                    distMatrix.setValue(i,j,999999999); // that's a really large molecule
                } else {
                	distMatrix.setValue(i,j,1); // atoms are connected
                }
            }
        }
        for (i = 0; i < nrow; i++) {
            distMatrix.setValue(i,i,0); // no self cycles
        }
        for (k = 0; k < nrow; k++) {
            for (i = 0; i < nrow; i++) {
                for (j = 0; j < nrow; j++) {
                    if (distMatrix.getValue(i,k) +
                    	distMatrix.getValue(k,j) <
                    	distMatrix.getValue(i,j)) {
                        distMatrix.setValue(i,j,
                        	distMatrix.getValue(i,k) +
                        	distMatrix.getValue(k,j)
                        );
                    }
                }
            }
        }
        return distMatrix;
    }

}
