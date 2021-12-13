package com.MichaelSuder.ChemistryCalculator.Utils;

public class AtomFinder {

    private Finder f = new Finder();
    private GMAConversion gma = new GMAConversion();
    private boolean running = true;


	// Method to check if an element is diatomic
	private double isDiatomic(String element) {
		String[] diatomics = { "H", "N", "F", "O", "I", "Cl", "B" };
		for (String s : diatomics) {
			if (element.equals(s))
				// getAtomicMass returns the atomic mass
				// getAtomicNumber uses the name of the element to return the place in the array
				// where you will find the atomic mass
				return f.getAtomicMass(f.getAtomicNumber(element)) * 2;
		}

		return f.getAtomicMass(f.getAtomicNumber(element));
	}

	/* GMA MODE */

	// all of the functions used such as: gramsToMoles, gramsToAtoms, etc. are from
	// the gmaConversion class
	public double gramsMolesAtoms(String conversionType, String atom, double unit) {
		while (running) {

			conversionType = conversionType.toLowerCase().replaceAll(" ", "");
			double molarMass;
			switch (conversionType) {
			// Grams to moles conversion
			case "gramstomoles":
				molarMass = isDiatomic(atom);
				return gma.gramsToMoles(unit, molarMass);
			case "gramstoatoms":
				molarMass = isDiatomic(atom);
				return gma.gramsToAtoms(unit, molarMass);
			case "molestograms":
				molarMass = isDiatomic(atom);
				return gma.molesToGrams(unit, molarMass);
			case "molestoatoms":
				return gma.molesToAtoms(unit);
			case "atomstograms":
				molarMass = isDiatomic(atom);
				return gma.atomsToGrams(unit, molarMass);
			case "atomstomoles":
				return gma.atomsToMoles(unit);
			default:
				return -2;
			}
		}
		return -1;
	}
}
