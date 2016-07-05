package dao;

import java.util.HashMap;

import model.Professor;
import model.Student;
import model.User;;

public interface PersonDao {
	
	public HashMap<String, Professor> findAllProfessors();
	public HashMap<String, Student> findAllStudents();
	public Student  getLoginStuent(User user);
}
