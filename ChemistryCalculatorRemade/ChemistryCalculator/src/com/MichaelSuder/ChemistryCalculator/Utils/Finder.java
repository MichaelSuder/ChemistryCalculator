package com.MichaelSuder.ChemistryCalculator.Utils;

public class Finder extends AtomicInfo {

	public String getElementName(String element) {
		for (int i = 0; i < elements.length; i++) {
			if (element.equals(elements[i].substring(elements[i].length() - element.length()))) {
				return elements[i] + " Atomic Number: " + (i + 1) + ", MM: " + atomicMass[i];
			}
		}
		return "Element not found check spelling or capitalization. . .";
	}

	public boolean isElement(String element) {
		for (String s : elements) {
			if (element.equals(s.substring(s.length() - element.length()))) {
				return true;
			}
		}
		return false;
	}

	public String elementName(String element) {
		for (String s : elements) {
			String atomicSymbol = s.substring(s.length() - element.length());
			if (element.equals(atomicSymbol)) {
				return atomicSymbol;
			}
		}
		return "Enter a valid element";
	}

	public String getElementNumber(int e) {
		if (e <= elements.length) {
			return (elements[e - 1] + " MM: " + atomicMass[e - 1]);
		} else
			return "Element not found please check your number. . .";
	}

	public int getAtomicNumber(String element) {
		for (int i = 0; i < atomicMass.length; i++) {
			if (element.equals(elements[i].substring(elements[i].length() - element.length()))) {
				return i;
			}
		}
		return 1;
	}

	public double getAtomicMass(int atomicNumber) {
		return atomicMass[atomicNumber];
	}

}
