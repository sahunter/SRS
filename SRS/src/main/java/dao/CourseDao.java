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
}
