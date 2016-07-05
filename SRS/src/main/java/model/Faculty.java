package model;

import java.util.*;
import java.io.*;

public class Faculty {
	//------------
	// Attributes.
	//------------

	// This HashMap stores Professor object references, using
	// the (String) ssn of the Professor as the key.

	private HashMap<String, Professor> professors;

	//----------------
	// Constructor(s).
	//----------------

	public Faculty() {
		// Note that we're instantiating empty support Collection(s).

		professors = new HashMap<String, Professor>();
	}

	//------------------
	// Accessor methods.
	//------------------

	// None!

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	public void display() {
		// Iterate through the HashMap and display all entries.

		for (Professor p : professors.values()) {
			p.display();
			System.out.println();
		}
	}

	public void addProfessor(Professor p) {
		professors.put(p.getSsn(), p);
	}

	public Professor findProfessor(String ssn) {
		return (Professor) professors.get(ssn);
	}

	public boolean isEmpty() {
		if (professors.size() == 0) return true;
		else return false;
	}
}
