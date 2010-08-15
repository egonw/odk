package net.sf.cdk.tools;

import java.io.File;
import java.io.FileWriter;

import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.config.AtomTypeFactory;
import org.openscience.cdk.interfaces.IAtomType;
import org.openscience.cdk.interfaces.IAtomType.Hybridization;
import org.openscience.cdk.nonotify.NoNotificationChemObjectBuilder;
import org.openscience.cdk.tools.periodictable.PeriodicTable;

public class CreateAtomTypes {

	private final static String TEMPLATE =
"// autogenerated\n" +
"package com.github.egonw.odk.atomtypes;\n\n" +
"import java.util.ArrayList;\n" +
"import java.util.List;\n\n" +
"import com.github.egonw.odk.elements.$ELEMENTCLASSNAME$;\n" +
"import com.github.egonw.odk.interfaces.IAtomType;\n" +
"import com.github.egonw.odk.interfaces.IElement;\n" +
"import com.github.egonw.odk.interfaces.IOrbitalType;\n" +
"import com.github.egonw.odk.model.LonePair;\n" +
"import com.github.egonw.odk.model.orbitals.*;\n\n" +
"public class $ATOMTYPECLASSNAME$ implements IAtomType {\n\n" +
"	private static IAtomType type;\n\n" +
"	private $ATOMTYPECLASSNAME$() {}\n\n" +
"	public static IAtomType getInstance() {\n" +
"		if (type == null) type = new $ATOMTYPECLASSNAME$();\n" +
"		return type;\n" +
"	}\n\n" +
"	@Override\n" +
"	public IElement getElement() {\n" +
"		return $ELEMENTCLASSNAME$.getInstance();\n" +
"	}\n\n" +
"	@Override\n" +
"	public String getName() {\n" +
"		return \"$ATNAME$\";\n" +
"	}\n\n" +
"	@Override\n" +
"	public List<IOrbitalType> getOrbitalTypes() {\n" +
"		List<IOrbitalType> orbitals = new ArrayList<IOrbitalType>();\n" +
"$ORBITALS$" +
"		return orbitals;\n" +
"	}\n\n" +
"}\n";
	
	public static void main(String[] args) throws Exception {
		AtomTypeFactory factory = AtomTypeFactory.getInstance(
			"org/openscience/cdk/dict/data/cdk-atom-types.owl",
			NoNotificationChemObjectBuilder.getInstance()
		);
		for (IAtomType type : factory.getAllAtomTypes()) {
			String symbol = type.getSymbol();
			String elementClassName = upperCase(PeriodicTable.getName(symbol));
			String atomtypeClassName = upperCase(
				removeDots(type.getAtomTypeName())
			);
			StringBuilder orbitals = new StringBuilder();
			if (type.getHybridization() == Hybridization.SP3 &&
				type.getFormalCharge() == 0 &&
				!type.getAtomTypeName().contains("radical")) {
				int lpCount = (Integer)type.getProperty(CDKConstants.LONE_PAIR_COUNT);
				for (int i=0; i<lpCount; i++) {
					orbitals.append(
						"\t\torbitals.add(LonePair.getInstance(Sp3.getInstance()));\n"
					);
				}
				for (int i=0; i<(4-lpCount); i++) {
					orbitals.append(
						"\t\torbitals.add(Sp3.getInstance());\n"
					);
				}
			}

			if (orbitals.toString().length() > 5) {
				String fileContent = TEMPLATE;
				fileContent = fileContent.replace("$ELEMENTCLASSNAME$", elementClassName);
				fileContent = fileContent.replace("$ATOMTYPECLASSNAME$", atomtypeClassName);
				fileContent = fileContent.replace("$ATNAME$", type.getAtomTypeName());
				fileContent = fileContent.replace("$ORBITALS$", orbitals.toString());

				FileWriter fileWriter = new FileWriter(
					new File(
						"src/main/com/github/egonw/odk/atomtypes/" +
						atomtypeClassName + 
						".java"
					)
				);
				fileWriter.append(fileContent);
				fileWriter.close();
			}
		}
		
	}

	private static String removeDots(String atomTypeName) {
		return atomTypeName.replace(".", "");
	}

	private static String upperCase(String name) {
		String result = name.toLowerCase();
		return ("" + result.charAt(0)).toUpperCase() + result.substring(1);
	}

}
