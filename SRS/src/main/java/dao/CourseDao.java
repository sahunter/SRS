package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import model.Course;
import model.CourseCatalog;
import model.Professor;
public interface CourseDao {
	
	public HashMap<String, Course> findAll();
	public HashMap<String, Course> findPrerequisite();
	List<Course> searchCourse(Course course);

	void addCourse(Course course);
	void updateCourse(Course course);
	void deleteCourse(Course course);
	
	void addPrerequisite(String ID, String presentcourse, String prerequisite);
	void updatePrerequisite(String ID, String presentcourse, String prerequisite);
	void deletePrerequisite(String ID, String presentcourse, String prerequisite1);
}
