package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import dao.CourseDao;
import dao.DaoFactory;
import dao.PersonDao;
import dao.SectionDao;
import dao.UserDao;
import daoImplsqlite.CourseDaoImpl;
import daoImplsqlite.PersonDaoImpl;
import model.Course;
import model.EnrollmentStatus;
import model.Section;
import model.Student;
import model.User;

public class systemService {
	
	SectionDao sectionDao =  DaoFactory.createSectionDao();
	CourseDao courseDao =  DaoFactory.createCourseDao();
	UserDao userDao = DaoFactory.createUserDao();
	PersonDao personDao =  DaoFactory.createPersonDao();
	
//	EnrollmentStatus status = sec1.enroll(student);
	//reportStatus(status);
	//attemptToEnroll(s1, sec2);
}
