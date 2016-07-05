package model;

import java.util.*;
import java.io.*;

public class CourseCatalog {
	//------------
	// Attributes.
	//------------

	// This HashMap stores Course object references, using
	// the course no. of the Course (a String) as the key.

	private HashMap<String, Course> courses;

	//----------------
	// Constructor(s).
	//----------------

	public CourseCatalog() {
		// Note that we're instantiating empty support Collection(s).

		courses = new HashMap<String, Course>();
	}

	//------------------
	// Accessor methods.
	//------------------

	// None!

	//-----------------------------
	// Miscellaneous other methods.
	//-----------------------------

	public CourseCatalog(HashMap<String, Course> findAll) {
		// TODO Auto-generated constructor stub
	}

	public void display() {
		// Iterate through the HashMap and display all entries.

		for (Course c : courses.values()) {
			c.display();
			System.out.println();
		}
	}

	public void addCourse(Course c) {
		// We use the course no. as the key.

		String key = c.getCourseNo();
		courses.put(key, c);
	}

	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}

	public boolean isEmpty() {
		if (courses.size() == 0) return true;
		else return false;
	}
}
