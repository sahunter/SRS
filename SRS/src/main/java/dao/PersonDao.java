package dao;

import java.util.HashMap;


import model.Professor;
import model.Student;
import model.User;;

public interface PersonDao {
	
	public HashMap<String, Professor> findAllProfessors();
	public HashMap<String, Student> findAllStudents();
	public Student  getLoginStuent(User user);
	void addProfessor(String type,Professor professor);

	java.util.List<Professor> searchProfessor(Professor professor);

	void updateProfessor(Professor professor);
	void deleteProfessor(Professor professor);

}
