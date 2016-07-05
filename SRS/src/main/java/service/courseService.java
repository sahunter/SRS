package service;

import model.Course;
import model.CourseCatalog;
import dao.CourseDao;

public class courseService {
	
	private static CourseCatalog  courses;
	private CourseDao courseDao = null;
	
	public courseService(CourseDao dao){
		this.courseDao = dao;
		courses = new CourseCatalog(dao.findAll());
	}

	public CourseCatalog getCourseCatalog() {
		return courses;
	}
	
	public Course findCourse(String courseNo){
	   return courses.findCourse(courseNo);
	}
}
