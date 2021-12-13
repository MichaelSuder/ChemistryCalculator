package com.MichaelSuder.ChemistryCalculator.Utils;

public class GMAConversion {

	protected double grams;
	protected double moles;
	protected double atoms;

	// Grams to-- conversions
	public double gramsToMoles(double grams, double molarMass) {

		moles = grams / molarMass;
		return moles;
	}

	public double gramsToAtoms(double grams, double molarMass) {
		atoms = grams * Math.pow(molarMass, -1) * (6.022140857747 * Math.pow(10, 23));
		return atoms;
	}

	// Mole to-- conversions
	public double molesToGrams(double moles, double molarMass) {
		grams = moles * molarMass;
		return grams;
	}

	public double molesToAtoms(double moles) {

		atoms = moles * (6.022140857747 * Math.pow(10, 23));
		return atoms;
	}

	// Atom to-- conversions
	public double atomsToGrams(double atoms, double molarMass) {
		moles = atoms / (6.022140857747 * Math.pow(10, 23));
		grams = moles * molarMass;
		return grams;
	}

	public double atomsToMoles(double atoms) {
		moles = atoms / (6.022140857747 * Math.pow(10, 23));
		return moles;
	}

}
